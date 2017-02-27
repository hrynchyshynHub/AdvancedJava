package ua.com.schoolnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.schoolnetwork.dao.CommentsDao;
import ua.com.schoolnetwork.entity.Comments;

import java.util.List;

/**
 * Created by ваня on 25.02.2017.
 */
@Service
public class CommentsServiceImpl implements CommentService{
    @Autowired
    private CommentsDao commentsDao;

    @Override
    public Comments findOne(int id) {
        return commentsDao.findOne(id);
    }

    @Override
    public List<Comments> findAll() {
        return commentsDao.findAll();
    }

    @Override
    public void delete(int id) {
        commentsDao.delete(id);
    }

    @Override
    public void save(Comments comments) {
        commentsDao.save(comments);
    }

    @Override
    public List<Comments> findCommentsForEvent(int idEvent) {
        return commentsDao.findComentsForEvent(idEvent);
    }
}
