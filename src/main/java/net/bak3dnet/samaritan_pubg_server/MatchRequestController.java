package net.bak3dnet.samaritan_pubg_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pubg-player-match-data-service")
public class MatchRequestController {

    @GetMapping()
    public Object index(@RequestParam(name="playerName") String namae) {
        return new Matches(namae);
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