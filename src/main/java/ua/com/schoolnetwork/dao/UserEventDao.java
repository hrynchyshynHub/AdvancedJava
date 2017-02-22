package ua.com.schoolnetwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.schoolnetwork.entity.UserEvent;

import java.util.List;

/**
 * Created by ваня on 22.02.2017.
 */
public interface UserEventDao extends JpaRepository<UserEvent,Integer> {
    @Query("select u from UserEvent u where u.user.id =:id")
    List<UserEvent>findUserEvent(@Param("id")int id);

}
