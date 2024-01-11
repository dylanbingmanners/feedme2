package com.mw.feedme2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import javax.annotation.Nullable;

public abstract class SubCommand
{
    public abstract String getName();
    public abstract boolean execute(@Nullable CommandSender sender,
                                    @Nullable Command command,
                                    @Nullable String label,
                                    String[] args);
}
