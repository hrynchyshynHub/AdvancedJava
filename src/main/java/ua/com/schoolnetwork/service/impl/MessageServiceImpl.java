package ua.com.schoolnetwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.schoolnetwork.dao.DialogDao;
import ua.com.schoolnetwork.dao.MessageDao;
import ua.com.schoolnetwork.entity.Dialog;
import ua.com.schoolnetwork.entity.Message;
import ua.com.schoolnetwork.service.interfaces.DialogService;
import ua.com.schoolnetwork.service.interfaces.MessageService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by ваня on 22.04.2017.
 */
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageDao messageDao;
    @Autowired
    private DialogDao dialogDao;

    @Override
    public void save(Message message) {
        message.setLocalDate(LocalDate.now());
        messageDao.save(message);
    }

    @Override
    public void delete(int idMessage) {
        messageDao.delete(idMessage);
    }

    @Override
    public List<Message> findMessagesForDialog(int dialogId) {
        return messageDao.findMessageFromDialog(dialogId);
    }

    @Override
    public void addMessageToDialog(Message message, int dialogId) {
        message.setLocalDate(LocalDate.now());
        messageDao.saveAndFlush(message);
        message.setDialog(dialogDao.findOne(dialogId));
        messageDao.save(message);
    }
}
