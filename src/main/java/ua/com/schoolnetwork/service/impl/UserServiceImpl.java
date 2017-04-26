package ua.com.schoolnetwork.service.impl;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.schoolnetwork.dao.UserDao;
import ua.com.schoolnetwork.dao.UserEventDao;
import ua.com.schoolnetwork.entity.Role;
import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.service.interfaces.UserEventService;
import ua.com.schoolnetwork.service.interfaces.UserService;
import ua.com.schoolnetwork.validation.Validator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ваня on 05.02.2017.
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService,UserDetailsService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    @Qualifier("userValidator")
    private Validator validator;
    @Autowired
    private UserEventDao userEventDao;
    @Autowired
    private UserEventService userEventService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDao.findByEmail(email);
    }

    @Override
    public void saveUser(User user) throws Exception {
        validator.validate(user);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User findOne(int id) {
        return userDao.getOne(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void changeUser(int id,User user) {
        User user1 = userDao.findOne(id);
        user1.setFirstName(user.getFirstName());
        user1.setSecondName(user.getSecondName());
        user1.setAge(user.getAge());
        user1.setStatus(user.getStatus());
        user1.setCity(user.getCity());
        user1.setPhoneNumber(user.getPhoneNumber());
        userDao.save(user1);
    }

    @Override
    public void saveProfileImage(MultipartFile file, int userId){
        User user = userDao.findOne(userId);

        String path = System.getProperty("catalina.home") + "/resources/avatar/origin/"
                + user.getId()+ "/" + file.getOriginalFilename();

        user.setPathToImage("resources/avatar/origin/" + user.getId() + "/" + file.getOriginalFilename());

        File file1 = new File(path);

        try {
            file1.mkdirs();
            try{
                FileUtils.cleanDirectory
                        (new File(System.getProperty("catalina.home") + "/resources/avatar/origin/" + user.getId() + "/"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            file.transferTo(file1);
        } catch (IOException e) {
            System.out.println("error with file");
        }
        userDao.save(user);
        //userEventService.save(myMultipartFile, userId);

    }

    @Override
    public List<User> findUserFriends(int userId) {
        return userDao.findUserFriends(userId);
    }

    @Override
    public void addToFriend(int userId, int userPricipal) {
        User user = userDao.findOne(userPricipal);
        user.getFriends().add(userDao.findOne(userId));
        userDao.save(user);
    }
}
