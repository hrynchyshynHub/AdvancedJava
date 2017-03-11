package ua.com.schoolnetwork.dto;

/**
 * Created by ваня on 13.02.2017.
 */
public class UserDto {
    private int id;
    private String firstName;
    private String secondName;
    private int age;
    private String status;
    private String city;
    private String phoneNumber;
    private String email;
    private String pathToImage;

    public UserDto(int id, String firstName, String secondName, int age, String status, String city, String phoneNumber, String email, String pathToImage) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.status = status;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.pathToImage = pathToImage;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
