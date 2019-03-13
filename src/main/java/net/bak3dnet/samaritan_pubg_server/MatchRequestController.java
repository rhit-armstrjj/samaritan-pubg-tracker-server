package net.bak3dnet.samaritan_pubg_server;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pubg-player-match-data-service")
public class MatchRequestController {

    @PostMapping()
    public int index(@RequestParam(name = "playerId") String namae) {

        namae = namae.split(",")[0];

        System.out.println(String.format("Appending %s to players to get.",namae));

        if(MatchLookupService.addPlayer(namae)) {
            System.out.println("Verified player not in que!");
            return MatchLookupService.getQueSize();
        }

        System.out.println("Redirecting to player in list");
        return MatchLookupService.getLocation(namae);
        

    }

    @GetMapping
    protected ArrayList<String> getMatches(@RequestParam(name = "playerId") String namae) {

        return MatchLookupService.getMatches(namae);

    }

    /*
    @GetMapping("/resetCounter")
    public RedirectView resetConter() {
        counter = 0;
        return new RedirectView("/pubg-match-data-service");
    }*/

    @GetMapping("/shutdown")
    public String stop() { 
        return "🚫🦆🌊";
    }

}