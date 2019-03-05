package net.bak3dnet.samaritan_pubg_server;

import java.util.ArrayList;

public class Matches {

    private final String playerId;

    public Matches(String id) {
        playerId = id;
    }

    public String getMatchId() {
        return playerId;
    }

    public String[] getRecentMatches() {

        

        return recentMatches;
    }

}