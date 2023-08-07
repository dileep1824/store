package com.project.utils;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.File;
import java.io.IOException;

public class ImageUtils {
    // get image from the url specified and return the base64 string related to the image
    public static String imageToBase64String (String fileUrl) throws IOException{
        byte[] fileContent = FileUtils.readFileToByteArray(new File(fileUrl));
        String encodedString = Base64.encodeBase64String(fileContent);
        return encodedString;
    }
}


