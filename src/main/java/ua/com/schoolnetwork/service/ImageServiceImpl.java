package ua.com.schoolnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import ua.com.schoolnetwork.dao.ImageDao;
import ua.com.schoolnetwork.entity.Image;

import java.util.List;

/**
 * Created by ваня on 13.02.2017.
 */
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public void saveImage(MultipartFile file) {

    }

    @Override
    public List<Image> findAll() {
        return imageDao.findAll();
    }

    @Override
    public void delete(int id) {
        imageDao.delete(id);
    }

    @Override
    public Image findOne(int id) {
        return imageDao.getOne(id);
    }

    @Override
    public List<Image> findImageforUser(int id) {
        return imageDao.fetchImageWithUser(id);
    }
}
