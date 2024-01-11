package com.mw.feedme2;

import com.mw.feedme2.commands.BaseCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class FeedMe2 extends JavaPlugin
{
    public Game game;
    @Override
    public void onEnable()
    {
        //getLogger().info("onEnable is called!");
        getCommand("feedme").setExecutor(new BaseCommand());
        Config.loadConfig();
        game = new Game();
    }

    @Override
    public void onDisable()
    {

    }

    public static FeedMe2 getInstance()
    {
        return getPlugin(FeedMe2.class);
    }
}
