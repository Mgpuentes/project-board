package com.developersboard.ppmtool.controller;

import com.developersboard.ppmtool.backend.persistance.domain.Project;
import com.developersboard.ppmtool.backend.service.ProjectService;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;


import static org.junit.Assert.*;

/**
 * @author Matthew Puentes on 2019-07-23.
 * @version 1.0
 * @since 1.0
 */



@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectControllerTest {


    private ProjectService projectService = mock(ProjectService.class);

    @Test
    public void getAllProjects() {

        //create projects
        Project project1 = new Project();

        projectService.saveOrUpdateProject(project1);
        projectService.findAllProject();

        verify(projectService).saveOrUpdateProject(project1);
        verify(projectService).findAllProject();
    }

    @Test
    public void insertProject() {

        Project project1 = new Project();

        projectService.saveOrUpdateProject(project1);

        verify(projectService).saveOrUpdateProject(project1);
    }
}