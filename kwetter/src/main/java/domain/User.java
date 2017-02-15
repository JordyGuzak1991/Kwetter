package domain;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by Jordy on 15-2-2017.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "user.findByName", query = "SELECT u FROM User u WHERE u.name = :name")
})
public class User {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private String biography;

    public User() {}

    public User(String name, Integer age, String biography) {
        this.name = name;
        this.age = age;
        this.biography = biography;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
