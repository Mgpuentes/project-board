package com.developersboard.ppmtool.backend.exception;

import lombok.Data;

/**
 * @author Matthew Puentes on 2019-07-17.
 * @version 1.0
 * @since 1.0
 */

@Data
public class ProjectIdExceptionResponse {

    private String projectIdentifier;

    public ProjectIdExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
