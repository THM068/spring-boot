package sample.jsp.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import sample.jsp.domain.User;
import sample.jsp.services.UserService;
import static org.mockito.Mockito.*;
/**
 * Created by tm1c14 on 29/06/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserRestControllerTest {

    @Mock
    private UserService userService;
    private UserRestController userController;

    @Before
    public void setup() {
        userService = mock(UserService.class);
        userController = new UserRestController(userService);
    }

    @Test
    public void shouldCreateUser() throws Exception {
        User u = new User();
        when(userService.save(u)).thenReturn(u);
        User returnedUser = userController.createUser(u);

        verify(userService, times(1)).save(u);
        boolean isUserInstance = returnedUser instanceof User;
        Assert.assertTrue(isUserInstance);
        Assert.assertNotNull(returnedUser);
    }

}
