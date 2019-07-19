package com.developersboard.ppmtool.backend.service;

import com.developersboard.ppmtool.backend.persistance.domain.Project;

import java.util.List;

/**
 * @author Matthew Puentes on 2019-07-17.
 * @version 1.0
 * @since 1.0
 */

public interface ProjectService {
    Project saveOrUpdateProject(Project project);
    Project findProjectByIdentifier(String projectId);
    List<Project> findAllProject();
    void deleteProjectByIdentifier(String projectId);
}
