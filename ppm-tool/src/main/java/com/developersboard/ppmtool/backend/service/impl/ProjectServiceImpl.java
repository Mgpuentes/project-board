package com.developersboard.ppmtool.backend.service.impl;

import com.developersboard.ppmtool.backend.exception.ProjectIdExceptionResponse;
import com.developersboard.ppmtool.backend.persistance.domain.Project;
import com.developersboard.ppmtool.backend.persistance.repositories.ProjectRepository;
import com.developersboard.ppmtool.backend.service.ProjectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Matthew Puentes on 2019-07-17.
 * @version 1.0
 * @since 1.0
 */

@Service
public class ProjectServiceImpl implements ProjectService {


    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project saveOrUpdateProject(Project project) {

            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
    }

    @Override
    public Project findProjectByIdentifier(String projectId) {

        return projectRepository.findByProjectIdentifier(projectId);
    }

    @Override
    public List<Project> findAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProjectByIdentifier(String projectId) {
        projectRepository.deleteById((projectRepository.findByProjectIdentifier(projectId)).getId());
    }
}
