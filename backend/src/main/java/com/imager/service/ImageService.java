package com.imager.service;

import com.imager.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    Image saveImage(String imageName, String contentType, byte[] data);
    Image saveImage(MultipartFile file) throws IOException;

    Image getImageById(Long id);
}
