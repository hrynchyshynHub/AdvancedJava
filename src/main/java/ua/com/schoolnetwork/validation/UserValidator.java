package ua.com.schoolnetwork.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.schoolnetwork.dao.UserDao;
import ua.com.schoolnetwork.entity.User;

/**
 * Created by ваня on 20.02.2017.
 */
@Component("userValidator")
public class UserValidator implements Validator {
    @Autowired
    private UserDao userDao;
    @Override
    public void validate(Object o) throws Exception {
        User user = (User) o;
        if(user.getPassword().length()<5) throw new UserValidatorException(ValidationMessages.PASSWORD_IS_EASY);
        if(user.getPassword().length()>20) throw new UserValidatorException(ValidationMessages.PASSWORD_IS_MORE_THEN_20_CARACHTER);
        if(userDao.userExistsByEmail(user.getEmail())) throw new UserValidatorException(ValidationMessages.USER_ALREDY_EXISTS);

    }
}
