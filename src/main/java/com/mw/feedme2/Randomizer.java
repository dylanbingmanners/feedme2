package com.mw.feedme2;

import com.mw.feedme2.challenges.Challenge;
import com.mw.feedme2.challenges.Collectable;
import com.mw.feedme2.challenges.CollectionChallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Randomizer
{
    private final Random rng = new Random();
    private final int SPLIT_CHANCE = 80;
    private final int EXTRA_ONE_CHANCE = 20;
    private final int EXTRA_TWO_CHANCE = 10;
    public final ArrayList<Challenge> getChallenges(int round)
    {
        int points = Config.TIER_COSTS[0] + (round-1)*5;
        ArrayList<Challenge> challenges = new ArrayList<>();

        while(points > 0)
        {
            //Bukkit.broadcastMessage("Points " + points);
            if(points < Config.TIER_COSTS[0])
            {
                points = 0;
            }
            else
            {
                int max_affordable_tier = getMaxAffordableTier(points);
                int selected_tier;

                if(rng.nextInt(100) < SPLIT_CHANCE || points < Config.TIER_COSTS[1])
                {
                    points -= Config.TIER_COSTS[max_affordable_tier];
                    selected_tier = max_affordable_tier;
                    //Bukkit.broadcastMessage("Tier " + max_affordable_tier);
                }
                else
                {
                    int split = rng.nextInt(max_affordable_tier);
                    points -= Config.TIER_COSTS[split];
                    selected_tier = split;
                    //Bukkit.broadcastMessage("Tier " + split);
                }

                int extra_item_roll = rng.nextInt(100);
                int extra_items = 0;
                if(extra_item_roll < EXTRA_TWO_CHANCE)
                {
                    extra_items += 2;
                }
                else if(extra_item_roll < (EXTRA_ONE_CHANCE + EXTRA_TWO_CHANCE))
                {
                    extra_items += 1;
                }

                Collectable[] carr = new Collectable[1+extra_items];
                Collections.shuffle(Config.collectableTiers.get(selected_tier));
                for(int i = 0; i < 1+extra_items; i++)
                {
                    carr[i] = Config.collectableTiers.get(selected_tier).get(i).getCollectable();
                }
                CollectionChallenge cc = new CollectionChallenge(carr);
                challenges.add(cc);
            }
        }

        return challenges;
    }

    private int getMaxAffordableTier(int points)
    {
        for(int i = Config.TIER_COSTS.length-1; i >= 0; i--)
        {
            if(points >= Config.TIER_COSTS[i])
            {
                return i;
            }
        }
        return -1;
    }
}
