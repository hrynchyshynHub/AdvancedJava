package ua.com.schoolnetwork.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.schoolnetwork.dto.CommentsDto;
import ua.com.schoolnetwork.dto.DtoUtilMapper;
import ua.com.schoolnetwork.entity.Comments;
import ua.com.schoolnetwork.service.interfaces.CommentService;
import java.security.Principal;
import java.util.List;

@RestController
public class CommentsController{

    @Autowired
    private CommentService commentService;

    @RequestMapping(value ="/loadComments", method = RequestMethod.POST)
    public @ResponseBody
    List<CommentsDto> loadComents(@RequestBody String index){
        List<Comments> commentses = commentService.findCommentsForEvent(Integer.parseInt(index));
        return DtoUtilMapper.commentsToComentsDto(commentses);
    }
    @RequestMapping(value = "/saveComment", method = RequestMethod.POST)
    public @ResponseBody void saveComment(@RequestBody Comments comments, Principal principal){
        System.out.println("inside save comrnyts methof");
        commentService.save(comments,Integer.parseInt(principal.getName()));

    }
}
