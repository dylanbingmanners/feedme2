package com.mw.feedme2.commands.subcommands;

import com.mw.feedme2.FeedMe2;
import com.mw.feedme2.commands.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public class ResumeCommand extends SubCommand
{
    @Override
    public String getName()
    {
        return "resume";
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
            FeedMe2.getInstance().game.resumeGame(player);

            return true;
        }
        else
        {
            return false;
        }
    }
}
