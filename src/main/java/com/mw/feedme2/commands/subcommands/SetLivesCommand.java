package com.mw.feedme2.commands.subcommands;

import com.mw.feedme2.FeedMe2;
import com.mw.feedme2.commands.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public class SetLivesCommand extends SubCommand
{
    @Override
    public String getName()
    {
        return "setlives";
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

            if(args.length > 2)
            {
                try
                {
                    int lives = Integer.parseInt(args[2]);
                    if (lives < 1)
                    {
                        throw new NumberFormatException();
                    }
                    FeedMe2.getInstance().game.setLives(player, args[1], lives);
                    return true;
                }
                catch (NumberFormatException e)
                {
                    return false;
                }
            }
        }
        return false;
    }
}
