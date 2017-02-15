package dao;

import domain.User;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Jordy on 15-2-2017.
 */
@Stateless @Default
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "kwetter-pu")
    private EntityManager em;

    public void addUser(User user) {

    }

    public void removeUser(User user) {

    }

    public void followUser(User user, User follower) {

    }

    public void unFollowUser(User user, User follower) {

    }

    public User findUserByName(String name) {
        return null;
    }
}
