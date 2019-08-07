package com.developersboard.ppmtool.controller;

import com.developersboard.ppmtool.backend.service.ProjectService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author Matthew Puentes on 2019-08-05.
 * @version 1.0
 * @since 1.0
 */

@Controller
public class IndexController {

    private final ProjectService projectService;

    public IndexController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projects", projectService.findAllProject());
        return "hello";
    }

}
