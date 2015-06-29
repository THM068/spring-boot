package sample.jsp.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sample.jsp.domain.User;
import sample.jsp.domain.UserCreateForm;
import sample.jsp.services.UserService;
import sample.jsp.validators.UserCreateFormPasswordValidator;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tm1c14 on 26/06/2015.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;
    private UserCreateFormPasswordValidator userCreateFormPasswordValidator;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService, UserCreateFormPasswordValidator userCreateFormPasswordValidator) {
        this.userCreateFormPasswordValidator = userCreateFormPasswordValidator;
        this.userService = userService;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(userCreateFormPasswordValidator);
    }

    @RequestMapping("user_list.html")
    public ModelAndView getUserList() {
        ModelMap model = new ModelMap();
        List<User> userList = userService.getList();
        model.addAttribute("users", userList);
        ModelAndView mv = new ModelAndView("user_list", model);
        return mv;
    }

    @RequestMapping(value = "user_create.html", params = "new")
    public ModelAndView create() {
        UserCreateForm form = new UserCreateForm();
        ModelAndView mv = new ModelAndView("userCreate","form", form);
        return mv;
    }

    @RequestMapping(value = "user_save.html")
    public String save(@ModelAttribute("form") @Valid UserCreateForm form, BindingResult result) {
        log.debug("Received result to create {}, with result {}", form, result);

        if(result.hasErrors()) {
            return "userCreate";
        }

        User user = new User(form.getUsername(), form.getPassword1());
        userService.save(user);

        return "user_list";
    }
}
