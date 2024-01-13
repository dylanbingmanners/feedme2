package com.mw.feedme2;

import com.mw.feedme2.challenges.Challenge;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

public final class Game implements ITimerListener
{
    private enum State {STOPPED, PAUSED, WARMUP, WAITING, RUNNING}

    private final ArrayList<Challenge> challenges = new ArrayList<>();
    private final Timer timer = new Timer();
    private final Randomizer randomizer = new Randomizer();
    private int currentRound;
    private final ArrayList<PlayerStats> playerStats = new ArrayList<>();
    private State state;
    private State previousState;
    private Runnable onWaitingFinished;

    public Game()
    {
        timer.addListener(this);
        state = State.STOPPED;
    }

    public void startNewGame(Player sender)
    {
        startNewGame(sender,1);
    }

    public void startNewGame(Player sender, int round)
    {
        if(state == State.STOPPED)
        {
            currentRound = round;
            playerStats.clear();
            for(Player p : FeedMe2.getInstance().getServer().getOnlinePlayers())
            {
                playerStats.add(new PlayerStats(p, Config.STARTING_LIVES));
            }

            if(playerStats.size() < 2)
            {
                Chat.printMessageMain(Config.STR_ONE_PLAYER, sender);
            }
            else
            {
                Chat.printSeparator();
                Chat.printMessageMain(String.format(Config.STR_NEW_GAME, sender.getDisplayName(), currentRound));
                Chat.printPlayerLives(playerStats);
                Chat.printSeparator();

                setWait(3, this::startWarmup);
            }
        }
        else
        {
            Chat.printMessageMain(Config.STR_ALREADY_RUNNING, sender);
        }
    }

    public void stopGame(Player sender)
    {
        if(state != State.STOPPED)
        {
            state = State.STOPPED;
            timer.stop();

            Chat.printSeparator();
            Chat.printMessageMain(String.format(Config.STR_STOP_GAME, sender.getDisplayName(), currentRound));
            Chat.printPlayerLives(playerStats);
            Chat.printSeparator();
        }
        else
        {
            Chat.printMessageMain(Config.STR_NO_RUNNING, sender);
        }
    }

    public void pauseGame(Player sender)
    {
        if(state == State.RUNNING || state == State.WAITING || state == State.WARMUP)
        {
            Chat.printMessageMain(String.format(Config.STR_PAUSED, sender.getDisplayName()));
            previousState = state;
            state = State.PAUSED;
            timer.stop();
        }
        else if(state == State.PAUSED)
        {
            Chat.printMessageMain(Config.STR_ALREADY_PAUSED, sender);
        }
        else
        {
            Chat.printMessageMain(Config.STR_NO_RUNNING, sender);
        }
    }

    public void resumeGame(Player sender)
    {
        if(state == State.PAUSED)
        {
            Chat.printMessageMain(String.format(Config.STR_RESUMED, sender.getDisplayName()));
            state = previousState;
            timer.start();
        }
        else if(state != State.STOPPED)
        {
            Chat.printMessageMain(Config.STR_ALREADY_RESUMED, sender);
        }
        else
        {
            Chat.printMessageMain(Config.STR_NO_RUNNING, sender);
        }
    }

    public void setLives(Player sender, String playerToSet, int lives)
    {
        if(state != State.STOPPED)
        {
            Player player = Bukkit.getPlayer(playerToSet);
            if(player != null && getActivePlayers().contains(player))
            {
                for(PlayerStats ps : playerStats)
                {
                    if(ps.player.getDisplayName().equals(player.getDisplayName()))
                    {
                        ps.lives = lives;
                        Chat.printSeparator();
                        Chat.printMessageMain(String.format(Config.STR_SET_LIVES,
                                                            sender.getDisplayName(),
                                                            ps.player.getDisplayName(),
                                                            ps.lives));
                        Chat.printPlayerLives(playerStats);
                        Chat.printSeparator();
                    }
                }
            }
            else
            {
                Chat.printMessageMain(String.format(Config.STR_UNKNOWN_PLAYER, playerToSet), sender);
            }
        }
        else
        {
            Chat.printMessageMain(Config.STR_NO_RUNNING, sender);
        }
    }

    private void startWarmup()
    {
        state = State.WARMUP;
        timer.set(Config.WARMUP_TIME);
        timer.start();
        Chat.printMessageMain(String.format(Config.STR_WARMUP_ENDS, Chat.getSecondsAndMinutes(Config.WARMUP_TIME)));
    }

    private void startRound()
    {
        state = State.RUNNING;
        timer.set(Config.ROUND_TIME);
        timer.start();

        Utils.playSoundToAll(getActivePlayers(), Sound.ENTITY_ENDER_DRAGON_HURT, 0.5f);
        Chat.printMessageMain(String.format(Config.STR_STARTING_ROUND, currentRound));

        challenges.clear();
        challenges.addAll(randomizer.getChallenges(currentRound));

        Chat.printSeparator();
        Chat.printMessageMonster(String.format(Config.STR_COMPLETE, Chat.getSecondsAndMinutes(Config.ROUND_TIME)));
        for(Challenge challenge : challenges)
        {
            Chat.printMessageMonster("- " + challenge.completionString);
        }
        Chat.printSeparator();
    }

    private void endRound()
    {
        Chat.printMessageMain(String.format(Config.STR_ROUND_OVER, currentRound));
        Utils.playSoundToAll(getActivePlayers(), Sound.ENTITY_ENDER_DRAGON_GROWL, 0.5f);

        // maintain list of players that failed a challenge
        ArrayList<PlayerStats> failedPlayers = new ArrayList<>();
        for(PlayerStats ps : playerStats)
        {
            boolean failed = false;
            for(Challenge challenge : challenges)
            {
                // challenge init method
                challenge.onBegin(ps);

                // for each challenge, check if it was completed
                // auto fail if player is offline
                if(!ps.player.isOnline() || !challenge.checkCompletion(ps))
                {
                    failed = true;
                    failedPlayers.add(ps);
                    break;
                }
            }

            for(Challenge challenge : challenges)
            {
                if(!failed)
                {
                    // player completed the round
                    challenge.onRoundSucceed(ps);
                }
                else
                {
                    // player failed the round
                    challenge.onRoundFailed(ps);
                }
            }
        }

        Chat.printSeparator();
        if(failedPlayers.size() == playerStats.size())
        {
            // all players failed
            Chat.printMessageMain(Config.STR_ALL_FAILED);
            //currentRound++; // TODO REMOVE
        }
        else
        {
            if(failedPlayers.isEmpty())
            {
                // all players succeeded
                Chat.printMessageMain(Config.STR_ALL_SUCCEED);
            }
            else
            {
                for(PlayerStats ps : failedPlayers)
                {
                    // remove a life from players that failed
                    Chat.printMessageMain(String.format(Config.STR_PLAYER_FAILED, ps.player.getDisplayName()));
                    ps.lives--;
                }
            }
            currentRound++;
        }
        Chat.printPlayerLives(playerStats);
        Chat.printSeparator();

        // remove players with 0 lives from the game
        playerStats.removeIf(ps -> ps.lives == 0);

        // one player left so declare the winner
        if(playerStats.size() == 1)
        {
            setWait(3, this::endGame);
        }
        else
        {
            setWait(10, this::startRound);
        }
    }

    private void endGame()
    {
        state = State.STOPPED;
        timer.stop();
        for(Player p : FeedMe2.getInstance().getServer().getOnlinePlayers())
        {
            p.playSound(new Location(p.getWorld(), 0, 10000, 0),
                    Sound.ENTITY_FIREWORK_ROCKET_LAUNCH,
                    Float.MAX_VALUE,
                    1.0f);
        }

        Chat.printMessageMain(String.format(Config.STR_WINNER, playerStats.get(0).player.getDisplayName()));
    }

    private void setWait(int seconds, Runnable finished)
    {
        state = State.WAITING;
        timer.set(seconds);
        timer.start();
        onWaitingFinished = finished;
    }

    private ArrayList<Player> getActivePlayers()
    {
        ArrayList<Player> players = new ArrayList<>();
        for(PlayerStats ps : playerStats)
        {
            players.add(ps.player);
        }
        return players;
    }

    @Override
    public void TimerTick(int seconds)
    {
        switch(state)
        {
            case STOPPED:
                break;

            case PAUSED:
                break;

            case WARMUP:
                if(seconds == 0)
                {
                    startRound();
                }
                else
                {
                    if(Arrays.asList(Chat.displayTimes).contains(seconds))
                    {
                        Chat.printMessageMain(String.format(Config.STR_WARMUP_ENDS, Chat.getSecondsOrMinutes(seconds)));
                    }
                }
                break;

            case WAITING:
                if(seconds == 0)
                {
                    onWaitingFinished.run();
                }
                break;

            case RUNNING:
                if(seconds == 0)
                {
                    endRound();
                }
                else
                {
                    if(Arrays.asList(Chat.displayTimes).contains(seconds))
                    {
                        Chat.printMessageMain(String.format(Config.STR_ROUND_ENDS, Chat.getSecondsOrMinutes(seconds)));
                    }
                }
                break;
        }
    }

}
