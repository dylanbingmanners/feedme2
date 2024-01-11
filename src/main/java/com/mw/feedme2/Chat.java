package com.mw.feedme2;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public final class Chat
{
    public static final Integer[] displayTimes = {1, 2, 3, 4, 5, 10, 30, 60, 300, 600};
    private static final String PREFIX_MAIN = "[§cFeedMe§f]";
    private static final String PREFIX_MONSTER = "<§4MONSTER§f>";

    public static void printMessageMain(String message)
    {
        Bukkit.broadcastMessage(PREFIX_MAIN + " " + message);
    }

    public static void printMessageMain(String message, Player player)
    {
        player.sendMessage(PREFIX_MAIN + " " + message);
    }

    public static void printMessageMonster(String message)
    {
        Bukkit.broadcastMessage(PREFIX_MONSTER + " " + message);
    }

    public static void printSeparator()
    {
        Bukkit.broadcastMessage(Config.STR_SEPARATOR);
    }

    public static void printPlayerLives(ArrayList<PlayerStats> playerStats)
    {
        for(PlayerStats ps : playerStats)
        {
            printMessageMain(String.format(Config.STR_PRINT_LIVES, ps.player.getDisplayName()) + "❤".repeat(ps.lives));
        }
    }
    public static String getSecondsOrMinutes(int seconds)
    {
        if(seconds < 60)
        {
            String unit = seconds > 1
                    ? "seconds"
                    : "second";
            return seconds + " " + unit;
        }
        else
        {
            int minutes = seconds / 60;
            String unit = minutes > 1
                    ? "minutes"
                    : "minute";
            return minutes + " " + unit;
        }
    }

    public static String getSecondsAndMinutes(int seconds)
    {
        if(seconds % 60 == 0 || seconds < 60)
        {
            return getSecondsOrMinutes(seconds);
        }
        else
        {
            String minutes = getSecondsOrMinutes(seconds);
            while(seconds > 60)
            {
                seconds -= 60;
            }
            return minutes + " " + getSecondsOrMinutes(seconds);
        }
    }
}
