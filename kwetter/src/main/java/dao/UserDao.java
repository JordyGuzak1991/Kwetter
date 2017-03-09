package dao;

import domain.Kweet;
import domain.User;

import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by Jordy on 15-2-2017.
 */
public interface UserDao {
    void addUser(@NotNull User user);
    void removeUser(@NotNull User user);
    void followUser(@NotNull User user,@NotNull User follower);
    void unFollowUser(@NotNull User user,@NotNull User follower);
    User findUserByName(@NotNull String name);
    Collection<User> getUsers(); 
}
