package ua.com.schoolnetwork.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ваня on 22.04.2017.
 */
@Entity
public class Dialog{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int members;
    @OneToMany(mappedBy = "dialog")
    private List<Message>messages;
    @ManyToMany
    @JoinTable(
            name = "user_dialog",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "dialog_id")
    )
    private List<User>users;
    public Dialog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }
}
