package com.developersboard.ppmtool.backend.service;

import com.developersboard.ppmtool.s3.SpringCloudS3;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Matthew Puentes on 2019-08-15.
 * @version 1.0
 * @since 1.0
 */

@Component
public class SpringCloudS3Service {

    private static final Logger logger = LoggerFactory.getLogger(SpringCloudS3Service.class);

    private final SpringCloudS3 springCloudS3;

    @Autowired
    public SpringCloudS3Service(SpringCloudS3 springCloudS3) {
        this.springCloudS3 = springCloudS3;
    }

    public void downloadObject(String bucketName, String objectName) {
        String s3Url = "s3://" + bucketName + "/" + objectName;
        try {
            springCloudS3.downloadS3Object(s3Url);
            logger.info("{} file download result: {}", objectName, new File(objectName).exists());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void uploadObject(String bucketName, String objectName) {
        String s3Url = "s3://" + bucketName + "/" + objectName;
        File file = new File(objectName);
        try {
            springCloudS3.uploadFileToS3(file, s3Url);
        } catch (IOException e) {

        }
    }

}
