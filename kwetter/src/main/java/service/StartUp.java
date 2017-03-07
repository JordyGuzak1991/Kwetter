package service;

import domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created by Jordy on 15-2-2017.
 */
@Singleton
@Startup
public class StartUp {

    @Inject
    private UserService service;

    public StartUp() {}

    @PostConstruct
    public void initData() {
        service.addUser(new User("Jordy", 25, "jordy@mail.com", "password"));
        service.addUser(new User("Anne", 19, "anne@mail.com", "password"));
        service.addUser(new User("Frank", 29, "frank@mail.com", "password"));
        service.addUser(new User("Tom", 21, "tom@mail.com", "password"));
        service.addUser(new User("Louise", 33, "louise@mail.com", "password"));
    }
}
