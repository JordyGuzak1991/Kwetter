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

    //@PersistenceContext(unitName = "kwetter-pu")
    private EntityManager em;

    private UserDaoJPA(){ super(User.class); }

    public void addUser(User user) {

    }

    public void removeUser(User user) {

    }

    public void followUser(User user, User follower) {

    }

    public void unFollowUser(User user, User follower) {

    }

    public Collection<User> getUsers() {
        return null;
    }

    public User findUserByName(String name) {
        TypedQuery<User> query = em.createNamedQuery("user.findByName", User.class);
        query.setParameter("name", name);
        List<User> result = query.getResultList();
        return result.get(0);
    }

    protected EntityManager getEntityManager() {
        return em;
    }
}
