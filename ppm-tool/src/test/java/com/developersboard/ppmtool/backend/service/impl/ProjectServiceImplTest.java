package com.developersboard.ppmtool.backend.service.impl;

import com.developersboard.ppmtool.backend.persistance.domain.Project;
import com.developersboard.ppmtool.backend.persistance.repositories.ProjectRepository;
import com.developersboard.ppmtool.backend.service.ProjectService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Matthew Puentes on 2019-07-25.
 * @version 1.0
 * @since 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectServiceImplTest {

    private ProjectService projectService = mock(ProjectService.class);

    @Test
    public void saveOrUpdateProject() {

        Project project1 = new Project();

        projectService.saveOrUpdateProject(project1);

        verify(projectService).saveOrUpdateProject(project1);
    }

    @Test
    public void findProjectByIdentifier() {

        final String IDENTIFIER = "DFGH";
        Project project1 = new Project();
        project1.setProjectIdentifier(IDENTIFIER);

        projectService.findProjectByIdentifier(IDENTIFIER);

        verify(projectService).findProjectByIdentifier(IDENTIFIER);
    }

    @Test
    public void findAllProject() {

        Project project1 = new Project();

        projectService.saveOrUpdateProject(project1);
        projectService.findAllProject();

        verify(projectService).saveOrUpdateProject(project1);
        verify(projectService).findAllProject();
    }

    @Test
    public void deleteProjectByIdentifier() {

        final String IDENTIFIER = "DFGH";
        Project project1 = new Project();
        project1.setProjectIdentifier(IDENTIFIER);

        projectService.saveOrUpdateProject(project1);
        projectService.deleteProjectByIdentifier(IDENTIFIER);


        verify(projectService).saveOrUpdateProject(project1);
        verify(projectService).deleteProjectByIdentifier(IDENTIFIER);

    }
}