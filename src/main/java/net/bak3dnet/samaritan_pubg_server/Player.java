package net.bak3dnet.samaritan_pubg_server;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Player {

    private String name;
    private String[] matches;

    public void setName(String name) {
        this.name = name;
    }

    public void setMatches(String[] matches) {
        this.matches = matches;
    }

    public String getName() {
        return name;
    }

    public String[] getMatches() {
        return matches;
    } 

}