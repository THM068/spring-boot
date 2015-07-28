package sample.jsp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sample.jsp.domain.Employee;
import sample.jsp.domain.EmployeeForm;
import sample.jsp.exceptions.BusinessException;
import sample.jsp.services.EmployeeService;
import sample.jsp.validators.EmployeeFormValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by thandomafela on 28/06/15.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeFormValidator employeeFormValidator;

    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeFormValidator employeeFormValidator) {
        this.employeeFormValidator = employeeFormValidator;
        this.employeeService = employeeService;
    }

    @InitBinder(value = "employee")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(employeeFormValidator);
    }

    @ModelAttribute(value = "employee")
    public EmployeeForm EmployeeFormCommand() {
        EmployeeForm employee = new EmployeeForm();
        return employee;
    }

    @RequestMapping(value = "create_emp.html", method = RequestMethod.GET)
    public ModelAndView create(@CookieValue("JSESSIONID") String cookie, @RequestHeader MultiValueMap<String,String> headers ) {
        System.out.println(String.format("The cookie value is %s", cookie));
        Set<String> keys = headers.keySet();

        for(String key: keys) {
            System.out.println(String.format(" %s : %s", key, headers.getFirst(key)));
        }

        ModelAndView mv = new ModelAndView("create_emp");
        return mv;
    }

    @RequestMapping(value = "save_emp.html", method = RequestMethod.POST)
    public String saveEmployee(HttpServletRequest request, @ModelAttribute("employee") @Valid EmployeeForm employeeForm, BindingResult bindingResult) {
        HttpSession session = request.getSession();
        if(bindingResult.hasErrors()) {
            return "create_emp";
        }

        try {
            Employee employee = mapptoEmployee(employeeForm);
            Employee e = employeeService.addEMployee(employee);
            System.out.println(e);
        }
        catch (BusinessException be) {
            bindingResult.reject("employee.null.message");
        }

        return "redirect:employee/employee_list.html";
    }

    @RequestMapping(value = "employee_list.html", method = RequestMethod.GET)
    public String employeeList(Model model) {
        List<Employee> employeeList = employeeService.list();
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        File f = new File("/usr/local/thando.jpg");
        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:employee/employee_list.html";

    }

    private Employee mapptoEmployee(EmployeeForm form) {
        Employee employee = new Employee();
        employee.setName(form.getName());
        employee.setLastName(form.getLastName());
        employee.setSocialSecurity(form.getSocialSecurity());
        employee.setAge(form.getAge());

        return employee;
    }

}
