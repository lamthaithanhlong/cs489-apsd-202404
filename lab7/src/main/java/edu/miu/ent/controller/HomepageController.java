package edu.miu.ent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"", "/", "/ads"})
public class HomepageController {

    @GetMapping(value = {"", "/home"})
    public String displayHomepage() {
        return "index";
    }

    @GetMapping(value = {"/about"})
    public String displayAboutUsPage() {
        return "about";
    }

}
