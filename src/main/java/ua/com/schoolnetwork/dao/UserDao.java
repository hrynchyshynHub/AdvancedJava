package ua.com.schoolnetwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.schoolnetwork.entity.User;

/**
 * Created by ваня on 12.02.2017.
 */
public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);

}
