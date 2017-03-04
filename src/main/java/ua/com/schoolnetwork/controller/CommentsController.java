package ua.com.schoolnetwork.controller;

import org.json.JSONObject;
import org.mortbay.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.schoolnetwork.dto.CommentsDto;
import ua.com.schoolnetwork.dto.DtoUtilMapper;
import ua.com.schoolnetwork.entity.Comments;
import ua.com.schoolnetwork.service.CommentService;

import java.security.Principal;
import java.util.List;

/**
 * Created by ваня on 25.02.2017.
 */
@RestController
public class CommentsController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value ="/loadComents", method = RequestMethod.POST)
    public @ResponseBody
    List<CommentsDto> loadComents(@RequestBody String index){
        List<Comments> commentses = commentService.findCommentsForEvent(Integer.parseInt(index));
        return DtoUtilMapper.commentsToComentsDto(commentses);
    }
    @RequestMapping(value = "/saveComent", method = RequestMethod.POST)
    public @ResponseBody void saveComent(@RequestBody Comments comments, Principal principal){
        commentService.save(comments,Integer.parseInt(principal.getName()));

    }
}
