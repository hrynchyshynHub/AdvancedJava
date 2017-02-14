package ua.com.schoolnetwork.service;

import org.springframework.web.multipart.MultipartFile;
import ua.com.schoolnetwork.entity.Image;

import java.util.List;

/**
 * Created by ваня on 13.02.2017.
 */
public interface ImageService {
    void saveImage(MultipartFile file);
    List<Image> findAll();
    void delete(int id);
    Image findOne(int id);
    List<Image>findImageforUser(int id);
}
