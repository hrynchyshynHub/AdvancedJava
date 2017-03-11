package ua.com.schoolnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.schoolnetwork.dao.MessageDao;
import ua.com.schoolnetwork.dao.UserDao;
import ua.com.schoolnetwork.entity.Message;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by ваня on 04.03.2017.
 */
@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private UserDao userDao;
    @Override
    public void save(Message message) {
        messageDao.save(message);
    }

    @Override
    public void delete(int id) {
        messageDao.delete(id);
    }

    @Override
    public List<Message> findAll() {
        return messageDao.findAll();
    }

    @Override
    public Message findOne(int id) {
        return messageDao.getOne(id);
    }

    @Override
    public List<Message> findInboxMessageForUser(int idUser) {
        return messageDao.findByUserFromId(idUser);
    }

    @Override
    public void save(Message message, int idUserTo,int idUserFrom) {
        messageDao.saveAndFlush(message);
        message.setUserTo(userDao.findOne(idUserTo));
        message.setUserFrom(userDao.findOne(idUserFrom));
        message.setLocalDate(LocalDate.now());
        messageDao.save(message);

    }

//    @Override
//    public List<Message> findDialog(int messageId) {
//        int userFromId = messageDao.findOne(messageId).getUserFrom().getId();
//        int userToId = messageDao.findOne(messageId).getUserTo().getId();
//        return messageDao.findDialog(userFromId,userToId);
//    }
}
