package com.developersboard.ppmtool.s3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Component;

/**
 * @author Matthew Puentes on 2019-08-13.
 * @version 1.0
 * @since 1.0
 */

@Component
public class SpringCloudS3 {

    private final ResourceLoader resourceLoader;

    @Autowired
    public SpringCloudS3(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void downloadS3Object(String s3Url) throws IOException {

        Resource resource = resourceLoader.getResource(s3Url);
        File downloadS3Object = new File(resource.getFilename());
        try(InputStream inputStream = resource.getInputStream()) {
            Files.copy(inputStream, downloadS3Object.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

    }

    public void uploadFileToS3(File file, String s3Url) throws IOException {
        WritableResource resource = (WritableResource) resourceLoader.getResource(s3Url);
        try (OutputStream outputStream = resource.getOutputStream()) {
            Files.copy(file.toPath(), outputStream);
        }
    }
}
