package net.bak3dnet.samaritan_pubg_server;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MatchLookupService {

    private ArrayList<String> playersToGet = new ArrayList<String>();

    @Async
    public CompletableFuture<Map<String, Player>> get6PlayerMatches() throws InterruptedException {
        while(true) {
            if(!playersToGet.isEmpty()) {
                
                for() {}

                Thread.sleep(6000);
                return CompletableFuture.completedFuture();
            }
        }
    }
}