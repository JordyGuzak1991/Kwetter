package dao;

import domain.Kweet;
import domain.User;

import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by Jordy on 15-2-2017.
 */
public interface KweetDao {
    void addKweet(@NotNull Kweet kweet);
    void removeKweet(@NotNull Kweet kweet);
    void likeKweet(@NotNull Kweet kweet, @NotNull User user);
    Collection<Kweet> getAllKweetsByUser(@NotNull User user);
}
