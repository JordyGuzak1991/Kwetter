package dao;

import domain.Kweet;
import domain.User;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by jordy on 2/22/2017.
 */
@Stateless
@Default
public class UserDaoColl implements UserDao {

    CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<User>();

    public void addUser(@NotNull User user) {
        users.add(user);
    }

    public void removeUser(@NotNull User user) {
        users.remove(user);
    }

    public void followUser(@NotNull User user, @NotNull User follower) {
        user.getFollowers().add(follower);
        follower.getFollowing().add(user);
    }

    public void unFollowUser(@NotNull User user, @NotNull User follower) {
        follower.getFollowing().remove(user);
        user.getFollowers().remove(follower);
    }

    public Collection<User> getUsers() {
        return this.users;
    }

    public User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().contentEquals(name)) {
                return user;
            }
        }
        return null;
    }
}
