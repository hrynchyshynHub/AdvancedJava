package ua.com.schoolnetwork.service;

import ua.com.schoolnetwork.entity.Message;

import java.util.List;

/**
 * Created by ваня on 04.03.2017.
 */
public interface MessageService {
    void save(Message message);
    void delete(int id);
    List<Message> findAll();
    Message findOne(int id);
    List<Message> findInboxMessageForUser(int idUser);
}
