package dao;

import domain.User;

/**
 * Created by Jordy on 15-2-2017.
 */
public interface UserDao {
    void addUser(User user);
    void removeUser(User user);
    void followUser(User user, User follower);
    void unFollowUser(User user, User follower);
    User findUserByName(String name);
}
