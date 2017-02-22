package ua.com.schoolnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.schoolnetwork.dao.UserDao;
import ua.com.schoolnetwork.dao.UserEventDao;
import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.entity.UserEvent;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by ваня on 22.02.2017.
 */
@Service
public class UserEventServiceImpl implements UserEventService{
    @Autowired
    private UserEventDao userEventDao;
    @Autowired
    private UserDao userDao;


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
}
