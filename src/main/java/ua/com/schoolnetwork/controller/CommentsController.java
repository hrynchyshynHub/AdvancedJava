package ua.com.schoolnetwork.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.schoolnetwork.dto.CommentsDto;
import ua.com.schoolnetwork.dto.DtoUtilMapper;
import ua.com.schoolnetwork.entity.Comments;
import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.service.interfaces.CommentService;
import ua.com.schoolnetwork.service.interfaces.UserService;

import java.security.Principal;
import java.util.List;

@RestController
public class CommentsController{

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @RequestMapping(value ="/loadComments", method = RequestMethod.POST)
    public @ResponseBody
    List<CommentsDto> loadComents(@RequestBody String index){
        List<Comments> commentses = commentService.findCommentsForEvent(Integer.parseInt(index));
        return DtoUtilMapper.commentsToComentsDto(commentses);
    }
    @RequestMapping(value = "/saveComment", method = RequestMethod.POST)
    public @ResponseBody CommentsDto saveComment(@RequestBody CommentsDto commentDto, Principal principal){
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        CommentsDto commentsDto = new CommentsDto(commentDto.getComment(), commentDto.getId());
        commentsDto.setUserEventId(commentDto.getUserEventId());
        commentsDto.setFirstName(user.getFirstName());
        commentsDto.setSecondName(user.getSecondName());
        commentService.save(commentsDto,Integer.parseInt(principal.getName()));
        return commentDto;
    }
}
