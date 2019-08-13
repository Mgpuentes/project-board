package com.developersboard.ppmtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Matthew Puentes on 2019-08-13.
 * @version 1.0
 * @since 1.0
 */

@Controller
public class GreetingController {

    @GetMapping
    public String greeting() {
        return "greeting";
    }
}
