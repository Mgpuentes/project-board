package com.developersboard.ppmtool.controller;

import com.developersboard.ppmtool.backend.persistance.domain.Project;
import com.developersboard.ppmtool.backend.service.ProjectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Matthew Puentes on 2019-07-19.
 * @version 1.0
 * @since 1.0
 */

@RestController
@RequestMapping("api/v1/ppm")
public class ProjectController {

    @Autowired
    private final ProjectService  projectService;


    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Project> getAllProjects() {
        return projectService.findAllProject();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertProject(@RequestBody Project project) {
        projectService.saveOrUpdateProject(project);

    }
}
