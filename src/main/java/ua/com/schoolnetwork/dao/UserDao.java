package ua.com.schoolnetwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.schoolnetwork.entity.User;

/**
 * Created by ваня on 12.02.2017.
 */
public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email =:email")
    boolean userExistsByEmail(@Param("email") String email);
}
