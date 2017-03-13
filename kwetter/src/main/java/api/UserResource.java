package api;

import domain.User;
import service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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

    @POST
    @Path("create")
    @Consumes("application/json")
    public Response createUser(User user) {
        try {
            service.addUser(user);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }
    }

    @POST
    @Path("remove")
    @Consumes("text/plain")
    public Response removeUser(String name) {
        try {
            User user = service.findUserByName(name);
            service.removeUser(user);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }
    }

}
