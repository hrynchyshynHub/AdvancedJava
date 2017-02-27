package ua.com.schoolnetwork.service;

import ua.com.schoolnetwork.entity.Comments;

import java.util.List;

/**
 * Created by ваня on 25.02.2017.
 */
public interface CommentService {
    Comments findOne(int id);
    List<Comments>findAll();
    void delete(int id);
    void save(Comments comments);
    List<Comments>findCommentsForEvent(int idEvent);
}
