package ua.com.schoolnetwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.schoolnetwork.dao.DialogDao;
import ua.com.schoolnetwork.dao.UserDao;
import ua.com.schoolnetwork.entity.Dialog;
import ua.com.schoolnetwork.entity.Message;
import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.service.interfaces.DialogService;

import java.util.List;

/**
 * Created by ваня on 22.04.2017.
 */
@Service
public class DialogServiceImpl implements DialogService {
    @Autowired
    private DialogDao dialogDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Dialog findOne(int id) {
        return dialogDao.findOne(id);
    }

    @Override
    public List<Dialog> findUserDialogs(int userId) {
        return dialogDao.findDialogs(userId);
    }

    @Override
    public void saveDialog(Dialog dialog) {
        dialogDao.save(dialog);
    }

    @Override
    public void deleteDialog(int id) {
        dialogDao.delete(id);
    }

    @Override
    public void createDialog(String name, int... idUsers) {
        Dialog dialog = new Dialog();
        dialog.setName(name);
        dialog.setMembers(idUsers.length);
        dialogDao.saveAndFlush(dialog);
        for (Integer id:idUsers) {
            User user = userDao.findOne(id);
            user.getDialogs().add(dialog);
            userDao.save(user);
        }

    }

    @Override
    public void addMembers(int idUser,int idDialog) {
        Dialog dialog = dialogDao.findOne(idDialog);
        dialog.getUsers().add(userDao.findOne(idUser));
        dialog.setMembers(dialog.getMembers()+1);
    }
    @Override
    public List<Message> getMesssages(int idDialog){
        return dialogDao.getMeesages(idDialog);
    }
}
