package net.bak3dnet.samaritan_pubg_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/pubg-match-data-service")
public class MatchRequestController {

    private int counter = 0;

    @GetMapping()
    public MatchData index() {
        return new MatchData("Dancing Tight", ++counter);
    }

    @GetMapping("/resetCounter")
    public RedirectView resetConter() {
        counter = 0;
        return new RedirectView("/pubg-match-data-service");
    }

    @GetMapping("/shutdown")
    public void stop() {
        System.exit(0);
    }

}