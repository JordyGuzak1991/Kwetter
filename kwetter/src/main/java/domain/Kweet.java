package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Jordy on 15-2-2017.
 */
@Entity
public class Kweet implements Serializable {

    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private User owner;
    private String message;
    private Date postDate;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "KWEETS_LIKES",
            joinColumns = @JoinColumn(name = "KWETTER_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "id"))
    private Collection<User> likedByUsers;

    public Kweet() {
    }

    public Kweet(User owner, String message) {
        this.owner = owner;
        this.message = message;
        this.postDate = new Date();
        this.likedByUsers = new ArrayList<User>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Collection<User> getLikedByUsers() {
        return likedByUsers;
    }

    public void setLikedByUsers(Collection<User> likedByUsers) {
        this.likedByUsers = likedByUsers;
    }
}
