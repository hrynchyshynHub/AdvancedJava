package ua.com.schoolnetwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.schoolnetwork.dao.CommentsDao;
import ua.com.schoolnetwork.dao.UserDao;
import ua.com.schoolnetwork.dao.UserEventDao;
import ua.com.schoolnetwork.dto.CommentsDto;
import ua.com.schoolnetwork.dto.DtoUtilMapper;
import ua.com.schoolnetwork.entity.Comments;
import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.service.interfaces.CommentService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by ваня on 25.02.2017.
 */
@Service
public class CommentsServiceImpl implements CommentService {
    @Autowired
    private CommentsDao commentsDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserEventDao userEventDao;

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

    @Transactional
    @Override
    public void save(CommentsDto commentsDto, int idUser) {
        Comments comments = commentsDtoToComments(commentsDto);
        commentsDao.saveAndFlush(comments);
        User user = userDao.findOne(idUser);
        comments.setUser(user);
        comments.setLocalDate(LocalDate.now());
        commentsDao.save(comments);
    }

    @Override
    public List<Comments> findCommentsForEvent(int idEvent) {
        return commentsDao.findComentsForEvent(idEvent);
    }

    @Override
    public Comments commentsDtoToComments(CommentsDto commentsDto){
        Comments comments = new Comments();
        comments.setUserEvent(userEventDao.findOne(commentsDto.getUserEventId()));
        comments.setComment(commentsDto.getComment());
        return comments;
    }
}
