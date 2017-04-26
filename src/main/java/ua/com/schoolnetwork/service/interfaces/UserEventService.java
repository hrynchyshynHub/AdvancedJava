package ua.com.schoolnetwork.service.interfaces;

import org.springframework.web.multipart.MultipartFile;
import ua.com.schoolnetwork.entity.UserEvent;

import java.util.List;

/**
 * Created by ваня on 22.02.2017.
 */
public interface UserEventService {
    void save(UserEvent userEvent,int userId);
    void delete(int userEventId);
    List<UserEvent> findAll();
    UserEvent findOne(int id);
    List<UserEvent> findAll(int userId);
    void save(MultipartFile file,int userId);
}
