package ua.com.schoolnetwork.dto;

import java.time.LocalDate;

/**
 * Created by ваня on 22.02.2017.
 */
public class UserEventDto {
    private int id;
    private String description;
    private LocalDate localDate;
    private int likeCounter;

    public UserEventDto(int id,String description, LocalDate localDate, int likeCounter) {
        this.id = id;
        this.description = description;
        this.localDate = localDate;
        this.likeCounter = likeCounter;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
