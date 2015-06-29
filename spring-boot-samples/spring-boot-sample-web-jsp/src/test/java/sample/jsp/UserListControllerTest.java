package sample.jsp;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import sample.jsp.controllers.UserController;
import sample.jsp.domain.User;
import sample.jsp.domain.UserCreateForm;
import sample.jsp.services.UserService;
import sample.jsp.validators.UserCreateFormPasswordValidator;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tm1c14 on 26/06/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserListControllerTest {

    @Mock
    private UserService userService;

    private UserCreateFormPasswordValidator userCreateFormPasswordValidator;

    private UserController userController;

    @Before
    public void setup() throws Exception {
        userCreateFormPasswordValidator = new UserCreateFormPasswordValidator();
        userController = new UserController(userService, userCreateFormPasswordValidator);
    }

    @Test
    public void shouldGetUserList() {
        when(userService.getList()).thenReturn(getUserList());
        ModelAndView mv = userController.getUserList();

        verify(userService, times(1)).getList();
        List<User> userList = (List<User>)mv.getModel().get("users");
        Assert.assertEquals(5, userList.size());
        Assert.assertEquals("user_list", mv.getViewName());
    }

    @Test
    public void display_create_form() {
        ModelAndView mv = userController.create();
        UserCreateForm form = (UserCreateForm)mv.getModel().get("form");

        assert form instanceof UserCreateForm;
        assertEquals("userCreate", mv.getViewName());
    }

    private List<User> getUserList() {
        String [] users = {"thando.p0", "kerrie.p1", "Melta.p2", "Zinzilee.p3", "Fikile.p4"};
        List<User> userList = new ArrayList<User>();

        for(String s : users) {
            String [] array = s.split("\\.");
            User user = new User(array[0], array[1]);
            userList.add(user);
        }

        return userList;
    }

}
