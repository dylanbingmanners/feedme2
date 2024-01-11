package com.mw.feedme2;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Utils
{
    public static void playSoundToAll(ArrayList<Player> players, Sound sound, float pitch)
    {
        for(Player player : players)
        {
            player.playSound(new Location(player.getWorld(), 0, 10000, 0),
                    sound,
                    Float.MAX_VALUE, pitch);
        }
    }
}
