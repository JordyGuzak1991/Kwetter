package dao;

import domain.Kweet;
import domain.User;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by Jordy on 15-2-2017.
 */
@Stateless @Default
public class KweetDaoColl implements KweetDao {

    public void addKweet(@NotNull Kweet kweet) {
        kweet.getOwner().getKweets().add(kweet);
    }

    public void removeKweet(@NotNull Kweet kweet) {
        kweet.getOwner().getKweets().remove(kweet);
    }

    public void likeKweet(@NotNull Kweet kweet, @NotNull User user) {
        kweet.getLikedByUsers().add(user);
    }

    public Collection<Kweet> getAllKweetsByUser(@NotNull User user) {
        return user.getKweets();
    }
}
