package ua.com.schoolnetwork.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by ваня on 12.02.2017.
 */
@Entity
public class UserEvent{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private User user;
    private String description;
    private LocalDate localDate;
    private String pathToImage;
    private int likeCounter;
    @OneToMany(mappedBy = "userEvent")
    List<Comments> commentses;

    public UserEvent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
    }

    public List<Comments> getCommentses() {
        return commentses;
    }

    public void setCommentses(List<Comments> commentses) {
        this.commentses = commentses;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }
}
