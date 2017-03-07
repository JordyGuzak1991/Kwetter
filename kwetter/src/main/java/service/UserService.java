package service;

import dao.UserDao;
import domain.Kweet;
import domain.User;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by jordy on 2/22/2017.
 */
@Stateless
public class UserService {

    @Inject
    @Default
    private UserDao userDao;

    public UserService(){}

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void removeUser(User user) {
        userDao.removeUser(user);
    }

    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    public void followUser(User user, User follower) {
        userDao.followUser(user, follower);
    }

    public void unFollowUser(User user, User follower) {
        userDao.unFollowUser(user, follower);
    }

    public Collection<User> getUsers() {
        return userDao.getUsers();
    }
}
