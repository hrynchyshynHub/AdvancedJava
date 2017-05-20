package ua.com.schoolnetwork.service.impl;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.schoolnetwork.dao.CommentsDao;
import ua.com.schoolnetwork.dao.UserDao;
import ua.com.schoolnetwork.dao.UserEventDao;
import ua.com.schoolnetwork.entity.Comments;
import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.entity.UserEvent;
import ua.com.schoolnetwork.service.interfaces.UserEventService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by ваня on 22.02.2017.
 */
@Service
public class UserEventServiceImpl implements UserEventService {
    @Autowired
    private UserEventDao userEventDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentsDao commentsDao;


    @Override
    public void save(UserEvent userEvent,int userId) {
        User user = userDao.findOne(userId);
        userEventDao.saveAndFlush(userEvent);
        userEvent.setUser(user);
        userEvent.setLocalDate(LocalDate.now());
        userEvent.setLikeCounter(0);
        userEventDao.save(userEvent);
    }

    @Override
    public void delete(int userEventId) {
        List<Comments> commentses = commentsDao.findComentsForEvent(userEventId);
        for (Comments comments : commentses) {
            comments.setUserEvent(null);
            comments.setUser(null);
            commentsDao.delete(comments);
        }
        UserEvent userEvent = userEventDao.getOne(userEventId);
        userEvent.setUser(null);
        userEventDao.delete(userEventId);
}

    @Override
    public List<UserEvent> findAll() {
        return userEventDao.findAll();
    }

    @Override
    public UserEvent findOne(int id) {
        return userEventDao.findOne(id);
    }

    @Override
    public List<UserEvent> findAll(int userId) {
        return userEventDao.findUserEvent(userId);
    }

    @Override
    public void save(MultipartFile file, int userId) {
        User user = userDao.findOne(userId);
        UserEvent userEvent = new UserEvent();
        String path1 = System.getProperty("catalina.home") + "/resources/userEvent/origin/"
                + user.getId()+ "/" + file.getOriginalFilename();

        File file2 = new File(path1);
        try {
            file2.mkdirs();
            try{
                FileUtils.cleanDirectory
                        (new File(System.getProperty("catalina.home") + "/resources/userEvent/origin/" + user.getId() + "/"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            file.transferTo(file2);
        } catch (IOException e) {
            System.out.println("error with file");
        }
        userEvent.setDescription(user.getFirstName() + " update profile photo");
        userEvent.setLocalDate(LocalDate.now());
        userEvent.setPathToImage("/resources/userEvent/origin/" + user.getId() + "/" + file.getOriginalFilename());
        userEvent.setUser(user);
        userEventDao.save(userEvent);
    }


}
