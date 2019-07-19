package com.developersboard.ppmtool.backend.persistance.repositories;

import com.developersboard.ppmtool.backend.persistance.domain.Project;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Matthew Puentes on 2019-07-17.
 * @version 1.0
 * @since 1.0
 */

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long > {

    Project findByProjectIdentifier(String projectIdentifier);


    @Override
    List<Project> findAll();

}
