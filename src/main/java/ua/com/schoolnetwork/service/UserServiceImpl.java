package ua.com.schoolnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.schoolnetwork.dao.UserDao;
import ua.com.schoolnetwork.entity.Role;
import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.validation.Validator;

import java.util.List;

/**
 * Created by ваня on 05.02.2017.
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService,UserDetailsService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    @Qualifier("userValidator")
    private Validator validator;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDao.findByEmail(email);
    }

    @Override
    public void saveUser(User user) throws Exception {
        validator.validate(user);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User findOne(int id) {
        return userDao.getOne(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void changeUser(int id,User user) {
        User user1 = userDao.findOne(id);
        user1.setFirstName(user.getFirstName());
        user1.setSecondName(user.getSecondName());
        user1.setAge(user.getAge());
        user1.setStatus(user.getStatus());
        user1.setCity(user.getCity());
        user1.setPhoneNumber(user.getPhoneNumber());
        userDao.save(user1);
    }
}
