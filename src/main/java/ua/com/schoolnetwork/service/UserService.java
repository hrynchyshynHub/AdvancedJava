package ua.com.schoolnetwork.service;

import org.springframework.web.multipart.MultipartFile;
import ua.com.schoolnetwork.entity.User;

import java.util.List;

/**
 * Created by ваня on 12.02.2017.
 */
public interface UserService  {
    void saveUser(User user) throws Exception;
    List<User>findAll();
    void delete(int id);
    User findOne(int id);
    User findByEmail(String email);
    void changeUser(int id,User user);
    void saveProfileImage(MultipartFile file, int userId);
}
