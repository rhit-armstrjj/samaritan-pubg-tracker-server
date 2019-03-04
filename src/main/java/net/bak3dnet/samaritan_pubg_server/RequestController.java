package net.bak3dnet.samaritan_pubg_server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RequestController {

    @RequestMapping("/")
    public String index() {
        return new String("QB9");
    }

}