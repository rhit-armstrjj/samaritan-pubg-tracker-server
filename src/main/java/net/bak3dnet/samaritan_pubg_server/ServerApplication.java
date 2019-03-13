package net.bak3dnet.samaritan_pubg_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.bak3dnet.samaritan_pubg_server.MatchLookupService;

@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        MatchLookupService.apiKey = args[0];
        Thread playerGetter = new Thread(new MatchLookupService(), "Lookup Service");
        playerGetter.start();

        SpringApplication.run(ServerApplication.class, args);
    }

}