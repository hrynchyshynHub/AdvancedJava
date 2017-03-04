package ua.com.schoolnetwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.schoolnetwork.entity.Message;

import java.util.List;

/**
 * Created by ваня on 04.03.2017.
 */
public interface MessageDao extends JpaRepository<Message,Integer> {
    @Query("select m from Message m where m.userTo.id =:id")
    List<Message>findByUserFromId(@Param("id")int id);
}
