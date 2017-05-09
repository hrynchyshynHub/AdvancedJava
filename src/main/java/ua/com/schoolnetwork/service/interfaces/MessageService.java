package ua.com.schoolnetwork.service.interfaces;

import ua.com.schoolnetwork.dto.MessageDto;
import ua.com.schoolnetwork.entity.Message;

import java.util.List;

/**
 * Created by ваня on 22.04.2017.
 */
public interface MessageService{
    void save(Message message);
    void delete(int idMessage);
    List<Message>findMessagesForDialog(int dialogId);
    void addMessageToDialog(Message message, int dialodId);
    MessageDto messageDtoToMessage(MessageDto messageDto, int userId);
}
