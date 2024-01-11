package com.mw.feedme2.challenges;

import com.mw.feedme2.PlayerStats;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public final class CollectionChallenge extends Challenge
{
    public final Collectable[] collectables;
    public final HashMap<PlayerStats, ItemStack> removedItems = new HashMap<>();

    public CollectionChallenge(Collectable[] collectables)
    {
        this.collectables = collectables;

        StringBuilder sb = new StringBuilder();
        int i = 0;

        sb.append("Collect ");
        for(Collectable collectable : collectables)
        {
            sb.append("§e").append(collectable.amount()).append(" ").append(collectable.displayName());
            if(i < collectables.length-1)
            {
                sb.append(" §for ");
            }
            i++;
        }

        completionString = sb.toString();
    }

    @Override
    public boolean checkCompletion(PlayerStats playerStats)
    {
        for(Collectable c : collectables)
        {
            ItemStack item_stack = new ItemStack(c.material(), c.amount());
            if(playerStats.player.getInventory().containsAtLeast(item_stack, item_stack.getAmount()))
            {
                playerStats.player.getInventory().removeItem(item_stack);
                removedItems.put(playerStats, item_stack);
                return true;
            }
        }
        return false;
    }

    @Override
    public void onBegin(PlayerStats playerStats)
    {
        removedItems.remove(playerStats);
    }

    @Override
    public void onRoundSucceed(PlayerStats playerStats) {}

    @Override
    public void onRoundFailed(PlayerStats playerStats)
    {
        ItemStack is = removedItems.get(playerStats);
        if(is != null)
        {
            playerStats.player.getInventory().addItem(is);
        }
    }
}
