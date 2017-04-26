package ua.com.schoolnetwork.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by ваня on 12.02.2017.
 */
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private User userFrom;
    @ManyToOne
    private Dialog dialog;
    private LocalDate localDate;
    private String message;
    private boolean isReading;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isReading() {
        return isReading;
    }

    public void setReading(boolean reading) {
        isReading = reading;
    }
}
