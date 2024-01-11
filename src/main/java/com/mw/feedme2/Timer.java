package com.mw.feedme2;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

public final class Timer
{
    private final ArrayList<ITimerListener> listeners = new ArrayList<>();
    private int seconds = 0;
    private BukkitTask task;
    private final BukkitScheduler scheduler = Bukkit.getScheduler();
    private boolean isRunning = false;

    public void addListener(ITimerListener listener)
    {
        listeners.add(listener);
    }

    public void start()
    {
        if(!isRunning)
        {
            isRunning = true;
            task = scheduler.runTaskTimer(FeedMe2.getInstance(), this::countDown, 20L, 20L);
        }
    }

    public void stop()
    {
        if(isRunning)
        {
            isRunning = false;
            task.cancel();
        }
    }

    public void set(int seconds)
    {
        this.seconds = seconds;
    }

    private void countDown()
    {
        if(seconds > 0)
        {
            seconds--;
            updateListeners(seconds);
        }
        else
        {
            stop();
        }
    }

    private void updateListeners(int seconds)
    {
        for(ITimerListener listener : listeners)
        {
            listener.TimerTick(seconds);
        }
    }
}
