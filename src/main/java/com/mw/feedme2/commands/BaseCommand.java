package com.mw.feedme2.commands;

import com.mw.feedme2.commands.subcommands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseCommand implements CommandExecutor, TabCompleter
{
    private final HashMap<String, SubCommand> registeredSubCommands = new HashMap<>();

    public BaseCommand()
    {
        SubCommand[] subCommands = new SubCommand[] {
                new StartCommand(),
                new StopCommand(),
                new PauseCommand(),
                new ResumeCommand(),
                new SetLivesCommand()
        };

        for(SubCommand s : subCommands)
        {
            registeredSubCommands.put(s.getName(), s);
        }
    }

    @Override
    public boolean onCommand(@Nullable CommandSender sender,
                             @Nullable Command command,
                             @Nullable String label,
                             String[] args)
    {
        if(args.length > 0)
        {
            if(registeredSubCommands.containsKey(args[0].toLowerCase()))
            {
                return registeredSubCommands.get(args[0].toLowerCase()).execute(sender, command, label, args);
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(@Nullable CommandSender sender,
                                      @Nullable Command command,
                                      @Nullable String label,
                                      @Nullable String[] args)
    {
        if(args == null || args.length == 1)
        {
            return new ArrayList<>(registeredSubCommands.keySet());
        }
        else
        {
            return new ArrayList<>();
        }
    }
}
