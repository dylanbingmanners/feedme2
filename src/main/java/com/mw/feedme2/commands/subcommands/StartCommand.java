package com.mw.feedme2.commands.subcommands;

import com.mw.feedme2.FeedMe2;
import com.mw.feedme2.commands.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public final class StartCommand extends SubCommand
{
    @Override
    public String getName()
    {
        return "start";
    }

    @Override
    public boolean execute(@Nullable CommandSender sender,
                           @Nullable Command command,
                           @Nullable String label,
                           String[] args)
    {
        if(sender instanceof Player)
        {
            Player player = (Player)sender;

            if(args.length > 1)
            {
                try
                {
                    int round = Integer.parseInt(args[1]);
                    if(round < 1) { throw new NumberFormatException(); }
                    FeedMe2.getInstance().game.startNewGame(player, round);
                    return true;
                }
                catch(NumberFormatException e)
                {
                    return false;
                }
            }
            else
            {
                FeedMe2.getInstance().game.startNewGame(player);
                return true;
            }
        }
        else
        {
            return false;
        }
    }
}
