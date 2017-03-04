package ua.com.schoolnetwork.dto;

/**
 * Created by ваня on 04.03.2017.
 */
public class MessageDto {
    private int id;
    private String message;
    private boolean isReading;
    private String userFrom;

    public MessageDto(int id, String message, boolean isReading, String userFrom) {
        this.id = id;
        this.message = message;
        this.isReading = isReading;
        this.userFrom = userFrom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }
}
