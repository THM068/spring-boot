package sample.jsp.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sample.jsp.domain.EmployeeForm;
import org.springframework.stereotype.Component;
/**
 * Created by thandomafela on 28/06/15.
 */

@Component
public class EmployeeFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeForm employeeForm = (EmployeeForm)target;
        String socialSecurity = employeeForm.getSocialSecurity();

        if(socialSecurity.length() > 10) {
            errors.rejectValue("socialSecurity","employee.socialSecurity.size");
        }

        try{
            Integer.parseInt(socialSecurity);
        }
        catch (NumberFormatException ex) {
            errors.rejectValue("socialSecurity", "employee.socialSecurity.notNumber");
        }


    }
}
