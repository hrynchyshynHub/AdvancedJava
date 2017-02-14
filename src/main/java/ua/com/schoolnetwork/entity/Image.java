package ua.com.schoolnetwork.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by ваня on 12.02.2017.
 */
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private User user;
    private String description;
    private LocalDate localDate;
    private int likeCounter;
    @OneToMany(mappedBy = "image")
    List<Comments> commentses;

    public Image() {
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
}