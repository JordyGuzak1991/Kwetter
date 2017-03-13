package dao;

import domain.Kweet;
import domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

/**
 * Created by Jordy on 15-2-2017.
 */
@Stateless @JPA
public class UserDaoJPA extends DaoFacade<User> implements UserDao {

    @PersistenceContext(unitName = "kwetter-pu")
    private EntityManager em;

    public UserDaoJPA(){ super(User.class); }


    public void addUser(@NotNull User user) {
        create(user);
    }

    public void removeUser(@NotNull User user) {
        User u = em.merge(user);
        u.clearGroups();
        remove(user);
    }

    public void followUser(@NotNull User user, @NotNull User follower) {
        follower.followUser(user);
        user.addFollower(follower);
        edit(follower);
        edit(user);
    }

    public void unFollowUser(@NotNull User user, @NotNull User follower) {
        follower.unfollowUser(user);
        user.removeFollower(follower);
        edit(follower);
        edit(user);
    }

    public User findUserByName(String name) {
        TypedQuery<User> query = em.createNamedQuery("user.findByName", User.class);
        query.setParameter("name", name);
        List<User> result = query.getResultList();
        return result.get(0);
    }

    public Collection<User> getUsers() {
        return null;
    }

    protected EntityManager getEntityManager() {
        return em;
    }
}
