package ua.com.schoolnetwork.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by ваня on 12.02.2017.
 */
@Entity
public class Comments{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private UserEvent userEvent;
    @ManyToOne
    private User user;
    private String comment;
    private LocalDate localDate;

    public Comments() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEvent getUserEvent() {
        return userEvent;
    }

    public void setUserEvent(UserEvent userEvent) {
        this.userEvent = userEvent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
