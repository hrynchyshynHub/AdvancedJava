package ua.com.schoolnetwork.dto;

import java.time.LocalDate;

/**
 * Created by ваня on 25.02.2017.
 */
public class CommentsDto {
    private int id;
    private String comment;
    private LocalDate localDate;
    private String firstName;
    private String secondName;

    public CommentsDto(int id, String comment, LocalDate localDate, String firstName, String secondName) {
        this.id = id;
        this.comment = comment;
        this.localDate = localDate;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
