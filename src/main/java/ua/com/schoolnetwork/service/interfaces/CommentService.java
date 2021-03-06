package ua.com.schoolnetwork.service.interfaces;

import ua.com.schoolnetwork.dto.CommentsDto;
import ua.com.schoolnetwork.entity.Comments;

import java.util.List;

/**
 * Created by ваня on 25.02.2017.
 */
public interface CommentService {
    Comments findOne(int id);
    List<Comments>findAll();
    void delete(int id);
    void save(CommentsDto comments, int idUser);
    List<Comments>findCommentsForEvent(int idEvent);
    Comments commentsDtoToComments(CommentsDto commentsDto);
}
