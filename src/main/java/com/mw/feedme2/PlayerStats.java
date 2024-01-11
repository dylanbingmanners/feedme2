package com.mw.feedme2;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public final class PlayerStats
{
    public Player player;
    public int lives;
    public PlayerStats(Player player, int lives)
    {
        this.player = player;
        this.lives = lives;
    }
}
