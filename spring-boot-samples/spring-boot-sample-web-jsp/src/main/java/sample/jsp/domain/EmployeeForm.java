package sample.jsp.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by thandomafela on 28/06/15.
 */
public class EmployeeForm {

    @NotEmpty
    @Size(max=30)
    private String name;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @Size(min = 10, message="Social security must be 10 characters long.")
    private String socialSecurity;
    @NotEmpty
    @NotNull
    private String age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
