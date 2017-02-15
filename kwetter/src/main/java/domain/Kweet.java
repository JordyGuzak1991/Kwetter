package domain;

import javax.persistence.*;

/**
 * Created by Jordy on 15-2-2017.
 */
@Entity
@NamedQueries({@NamedQuery(name = "", query = "")})
public class Kweet {

    @Id @GeneratedValue
    private Long id;
    private User user;
    private String message;

    public Kweet() {
    }

    public Kweet(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
