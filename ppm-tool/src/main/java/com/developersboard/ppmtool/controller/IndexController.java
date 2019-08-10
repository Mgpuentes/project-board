package com.developersboard.ppmtool.controller;

import com.developersboard.ppmtool.backend.persistance.domain.Project;
import com.developersboard.ppmtool.backend.service.ProjectService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @author Matthew Puentes on 2019-08-05.
 * @version 1.0
 * @since 1.0
 */

@Controller
public class IndexController {

    private final ProjectService projectService;

    @Autowired
    public IndexController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projects", projectService.findAllProject());
        model.addAttribute("projectAdded", new Project());
        return "hello";
    }

    @PostMapping("/addingProject")
    public String projectSubmit(@ModelAttribute("projectAdded") Project project) {
        projectService.saveOrUpdateProject(project);
        return "redirect:/";
    }
}
