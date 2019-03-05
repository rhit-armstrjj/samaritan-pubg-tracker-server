package net.bak3dnet.samaritan_pubg_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/pubg-match-data-service")
public class MatchRequestController {

    private int counter = 0;

    @GetMapping()
    public Object index(@RequestParam(defaultValue="",name="playerName") String namae) {
        return new MatchData(String.format("Dancing Tight %s",namae), ++counter);
    }

    @GetMapping("/resetCounter")
    public RedirectView resetConter() {
        counter = 0;
        return new RedirectView("/pubg-match-data-service");
    }

    @GetMapping("/shutdown")
    public String stop() {
        return "u thot 🦆🌊";
    }

}