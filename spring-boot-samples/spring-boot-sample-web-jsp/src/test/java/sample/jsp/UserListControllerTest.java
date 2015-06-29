package sample.jsp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import sample.jsp.controllers.UserController;
import sample.jsp.services.UserService;

/**
 * Created by tm1c14 on 26/06/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserListControllerTest {

    @Mock
    private UserService userService;

    private UserController userController;

    @Before
    public void setup() throws Exception {
        userController = new UserController(userService);
    }

    @Test
    public void shouldGetUserList() {
        assert true;
    }

}
