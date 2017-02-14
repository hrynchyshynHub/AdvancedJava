package ua.com.schoolnetwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.schoolnetwork.entity.Image;

import java.util.List;

/**
 * Created by ваня on 13.02.2017.
 */
public interface ImageDao extends JpaRepository<Image,Integer> {
    @Query("select i from Image where i.user.id =:id")
    List<Image> fetchImageWithUser(@Param("id")int id);
}
