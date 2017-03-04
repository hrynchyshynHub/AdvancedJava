package ua.com.schoolnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.schoolnetwork.dao.MessageDao;
import ua.com.schoolnetwork.entity.Message;

import java.util.List;

/**
 * Created by ваня on 04.03.2017.
 */
@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageDao messageDao;
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
}
