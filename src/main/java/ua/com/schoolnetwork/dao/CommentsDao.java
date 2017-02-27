package ua.com.schoolnetwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.schoolnetwork.entity.Comments;

import java.util.List;

/**
 * Created by ваня on 25.02.2017.
 */
public interface CommentsDao extends JpaRepository<Comments,Integer> {
    @Query("select c from Comments c where c.userEvent.id =:id")
     List<Comments>findComentsForEvent(@Param("id")int id);
}
