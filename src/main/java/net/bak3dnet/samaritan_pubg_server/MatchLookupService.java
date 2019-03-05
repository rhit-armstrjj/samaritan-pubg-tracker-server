package net.bak3dnet.samaritan_pubg_server;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.json.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MatchLookupService {

    private ArrayList<String> playersToGet = new ArrayList<String>();
    public static String apiKey;

    @Async
    public CompletableFuture<Map<String, Player>> get6PlayerMatches() throws InterruptedException {
        while(true) {
            if(!playersToGet.isEmpty()) {
                
                String preURL = "https://api.pubg.com/shards/steam/players?filter[playerNames]=";

                for(int i = 0; i < 6; i++) {

                    preURL += playersToGet.remove(0);

                    if(playersToGet.size() == 0) {

                        break;

                    }

                    preURL += ",";

                }

                URL url = new URL(preURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Authorization",String.format("Bearer %s",apiKey));
                conn.setRequestProperty("Accept", "application/vnd.api+json");

                JSONObject json = new JSONObject(IOUtils.toString(conn.getInputStream()));

                Thread.sleep(/*TODO Time*/);
                return CompletableFuture.completedFuture();
            }
        }
    }
}