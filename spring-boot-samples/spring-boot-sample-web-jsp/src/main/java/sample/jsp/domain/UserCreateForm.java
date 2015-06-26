package sample.jsp.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by tm1c14 on 26/06/2015.
 */
public class UserCreateForm {

    @NotEmpty
    @Size(max = 64)
    private String username;

    @NotEmpty
    @Size(max = 64)
    private
    String password1;
    private String password2;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
