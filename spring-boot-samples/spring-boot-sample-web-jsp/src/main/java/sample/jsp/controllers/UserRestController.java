package sample.jsp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.jsp.domain.User;
import sample.jsp.services.UserService;

import javax.validation.Valid;

/**
 * Created by tm1c14 on 29/06/2015.
 */
@RestController
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/userRest", method = RequestMethod.POST)
    public User createUser(@RequestBody @Valid User u) {
        User user = userService.save(u);

        return user;
    }
}
