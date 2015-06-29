package sample.jsp.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sample.jsp.domain.UserCreateForm;
import org.springframework.stereotype.Component;
/**
 * Created by thandomafela on 28/06/15.
 */
@Component
public class UserCreateFormPasswordValidator  implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return  UserCreateForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm)target;

        if(!form.getPassword1().equals(form.getPassword2())){
            errors.rejectValue("password2","user.error.password.no_match");
        }


    }
}
