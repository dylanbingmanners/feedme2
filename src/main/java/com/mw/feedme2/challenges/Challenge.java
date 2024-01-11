package com.mw.feedme2.challenges;

import com.mw.feedme2.PlayerStats;

public abstract class Challenge
{
    public String completionString;
    public abstract boolean checkCompletion(PlayerStats playerStats);
    public abstract void onBegin(PlayerStats playerStats);
    public abstract void onRoundSucceed(PlayerStats playerStats);
    public abstract void onRoundFailed(PlayerStats playerStats);
}
