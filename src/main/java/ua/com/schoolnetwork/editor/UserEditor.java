package ua.com.schoolnetwork.editor;

import ua.com.schoolnetwork.service.interfaces.UserService;

import java.beans.PropertyEditorSupport;

/**
 * Created by ваня on 22.04.2017.
 */
public class UserEditor extends PropertyEditorSupport{
    private final UserService userService;

    public UserEditor(UserService userService) {
        this.userService = userService;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(userService.findOne(Integer.parseInt(text)));
    }
}
