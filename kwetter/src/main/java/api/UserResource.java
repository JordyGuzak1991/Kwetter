package api;

import domain.User;
import service.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Collection;

/**
 * Created by jordy on 3/4/2017.
 */
@Path("/user")
public class UserResource {

    @Inject
    UserService service;

    @GET
    @Produces("application/json")
    public Collection<User> getUsers() {
        return service.getUsers();
    }

    @GET
    @Path("{name}")
    @Produces("application/json")
    public User getUserByName(@PathParam("name") String name) {
        return service.findUserByName(name);
    }
}
