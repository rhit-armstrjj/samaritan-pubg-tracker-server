package net.bak3dnet.samaritan_pubg_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class MatchLookupService extends Thread {

    static ArrayList<String> playersToGet = new ArrayList<String>();
    public static String apiKey;
    public static Map<String, ArrayList<String>> mappedPlayers = new HashMap<String, ArrayList<String>>();
    public static boolean gettingPlayersFlag = false;

    @Override
    public void run() {
        System.out.println("Beginning Loop!");
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            if (!playersToGet.isEmpty()) {
                try {
                    gettingPlayersFlag = true;

                    String preURL = "https://api.pubg.com/shards/steam/players?filter[playerNames]=";
                    System.out.println("Getting INFO");
                    Thread.sleep(6000);
                    for (int i = 0; i < 6; i++) {

                        preURL += playersToGet.remove(0);

                        if (playersToGet.size() == 0) {

                            break;

                        }

                        preURL += ",";

                    }

                    System.out.println(String.format("Final URL: %s", preURL));

                    URL url = new URL(preURL);

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Authorization", String.format("Bearer %s", apiKey));
                    conn.setRequestProperty("Accept", "application/vnd.api+json");

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    StringBuffer content = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }

                    JSONObject rJSON = new JSONObject(content.toString());

                    JSONArray playerList = rJSON.getJSONArray("data");
                    
                    for(int i = 0; i < playerList.length(); i++) {
                        ArrayList<String> newMatches = new ArrayList<String>();
                        JSONArray matchList =((JSONObject) playerList.get(i)).getJSONObject("relationships").getJSONObject("matches").getJSONArray("data");
                        
                        for(int l = 0; l < matchList.length(); l++) {
                            System.out.println(matchList.get(l).toString());
                            newMatches.add((String) matchList.getJSONObject(l).get("id"));
                        }
                        System.out.println(((JSONObject) playerList.get(i)).getJSONObject("attributes").getString("name"));
                        System.out.println(newMatches);
                        mappedPlayers.put(((JSONObject) playerList.get(i)).getJSONObject("attributes").getString("name"), newMatches);
                    }

                    System.out.println("Done!");

                } catch (Exception e) {
                    System.err.println("A 🦆");
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }

    public static boolean addPlayer(String name) {
        if(playersToGet.contains(name)) {
            return false;
        }

        playersToGet.add(name);

        return true;
    }

    public static int getQueSize() {
        return playersToGet.size();
    }

    public static int getLocation(String name) {
        return playersToGet.indexOf(name);
    }

	public static ArrayList<String> getMatches(String namae) {
        
        ArrayList<String> matches = mappedPlayers.get(namae);
        if(matches!=null) {
            return matches;
        } else {
            return new ArrayList<String>();
        }

	}

}