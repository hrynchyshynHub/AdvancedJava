package ua.com.schoolnetwork.service.interfaces;

import ua.com.schoolnetwork.entity.Dialog;
import ua.com.schoolnetwork.entity.Message;

import java.util.List;

/**
 * Created by ваня on 22.04.2017.
 */
public interface DialogService {
    Dialog findOne(int id);
    List<Dialog> findUserDialogs(int userId);
    void saveDialog(Dialog dialog);
    void deleteDialog(int id);
    void createDialog(String name,int...idUsers);
    void addMembers(int idUser,int idDialog);
    List<Message> getMesssages(int idDialog);
}
