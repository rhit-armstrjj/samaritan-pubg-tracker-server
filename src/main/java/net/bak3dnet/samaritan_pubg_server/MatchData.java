package net.bak3dnet.samaritan_pubg_server;

import java.util.ArrayList;

public class MatchData {

    private final String matchId;

    private final ArrayList<String> eventList = new ArrayList<String>();
    private int counter = 0;

    public MatchData(String id, int counter) {
        matchId = id;
        this.counter = counter;
    }

    public String getMatchId() {
        return matchId;
    }

    public ArrayList<String> getEventList() {
        int i =0;
        do{
            eventList.add(Integer.toString(i));
            i++;
        } while(i < counter);
        return eventList;
    }

}