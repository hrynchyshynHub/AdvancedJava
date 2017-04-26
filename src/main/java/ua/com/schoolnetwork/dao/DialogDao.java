package ua.com.schoolnetwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.schoolnetwork.entity.Dialog;
import ua.com.schoolnetwork.entity.Message;

import java.util.List;

/**
 * Created by ваня on 22.04.2017.
 */
public interface DialogDao extends JpaRepository<Dialog, Integer>{
    @Query("from Dialog d left join fetch d.users user where user.id =:id")
    List<Dialog> findDialogs(@Param("id")int id);
    @Query("from Message m left join fetch m.dialog dialog where dialog.id =:id order by localDate asc ")
    List<Message> getMeesages(@Param("id") int id);
}
