package domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Jordy on 15-2-2017.
 */

@Entity
@Table(name = "USERS")
@NamedQueries({
        @NamedQuery(name = "user.findByName", query = "SELECT u FROM User u WHERE u.name = :name")
})
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private Integer age;
    private String location;
    private String website;
    private String photoUrl;
    private String biography;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_RELATIONS",
            joinColumns = @JoinColumn(name = "FOLLOWED"),
            inverseJoinColumns = @JoinColumn(name = "FOLLOWER"))
    private Collection<User> followers;

    @ManyToMany(mappedBy = "followers")
    private Collection<User> following;

    @OneToMany(mappedBy = "owner")
    private Collection<Kweet> kweets;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_GROUPS",
            joinColumns = @JoinColumn(name = "NAME", referencedColumnName = "NAME"),
            inverseJoinColumns = @JoinColumn(name = "GROUPNAME", referencedColumnName = "groupName"))
    private Collection<Group> groups;

    public User() {
    }

    public User(String name, Integer age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.location = "";
        this.website = "";
        this.photoUrl = "";
        this.biography = "";
        this.followers = new ArrayList<User>();
        this.following = new ArrayList<User>();
        this.kweets = new ArrayList<Kweet>();
    }

    public void addFollower(@NotNull User follower) {
        this.followers.add(follower);
    }

    public void removeFollower(@NotNull User follower) {
        this.followers.remove(follower);
    }

    public void followUser(@NotNull User user) {
        this.following.add(user);
    }

    public void unfollowUser(@NotNull User user) {
        this.following.remove(user);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Collection<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Collection<User> followers) {
        this.followers = followers;
    }

    public Collection<User> getFollowing() {
        return following;
    }

    public void setFollowing(Collection<User> following) {
        this.following = following;
    }

    public Collection<Kweet> getKweets() {
        return kweets;
    }

    public void setKweets(Collection<Kweet> kweets) {
        this.kweets = kweets;
    }

    public Collection<Group> getGroups() {
        return groups;
    }

    public void setGroups(Collection<Group> groups) {
        this.groups = groups;
    }

    public void clearGroups() {
        groups.clear();
    }

    public void clearFollowing() { following.clear(); }

    public void clearFollowers() { followers.clear(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;
        if (!email.equals(user.email)) return false;
        return groups != null ? groups.equals(user.groups) : user.groups == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (groups != null ? groups.hashCode() : 0);
        return result;
    }
}
