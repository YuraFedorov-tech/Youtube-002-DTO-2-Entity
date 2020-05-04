package ru.yura.web.service;
/*
 *
 *@Data 16.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */


import org.springframework.stereotype.Service;
import ru.yura.web.model.Image;
import ru.yura.web.repositiry.ImageRepository;

@Service
public class ImageService {
    final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    public void save(Image image) {
        imageRepository.save(image);
    }

    public Image findByName(String name) {
        return imageRepository.findByName(name);
    }

}

