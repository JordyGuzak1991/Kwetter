package test;

import api.UserResource;
import dao.UserDaoJPA;
import domain.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import service.UserService;

import static org.junit.Assert.*;

/**
 * Created by jordy on 3/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserDaoJPA userDaoJPA;

    @InjectMocks
    private UserService service;

    User testUser = new User("test", 23, "test@mail.com", "password");

    @Before
    public void setUp() throws Exception {
        service.addUser(testUser);
    }

    @After
    public void cleanUp() {
        service.removeUser(testUser);
    }

    @Test
    public void getUserByName() {
        User user = service.findUserByName("test");
        assertNotNull(user);
        assertEquals("test", user.getName());
    }
}
