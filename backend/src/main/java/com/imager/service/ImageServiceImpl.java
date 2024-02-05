package com.imager.service;

import com.imager.model.Image;
import com.imager.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image saveImage(String imageName, String contentType, byte[] data) {
        Image image = new Image();
        image.setImageName(imageName);
        image.setContentType(contentType);
        image.setData(data);
        return imageRepository.save(image);
    }

    public Image saveImage(MultipartFile file) throws IOException {
        return saveImage(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }

    @Override
    public Image getImageById(Long id) {
        return imageRepository.getReferenceById(id);
    }
}

