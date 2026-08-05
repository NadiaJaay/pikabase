package com.nadiajaay.pika_base.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/game")
    public String game() {
        return "game";
    }

    @GetMapping("/discussion")
    public String discussion() {
        return "discussion";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
