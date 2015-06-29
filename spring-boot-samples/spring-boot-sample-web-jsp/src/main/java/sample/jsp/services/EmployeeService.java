package sample.jsp.services;
import org.springframework.stereotype.Component;
import sample.jsp.domain.Employee;
import sample.jsp.exceptions.BusinessException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thandomafela on 28/06/15.
 */
@Component
public class EmployeeService {


    public Employee addEMployee(Employee employee) throws BusinessException {
        System.out.println("Employee has been created");

        if(employee == null) {
            throw new BusinessException("This is employee is null");
        }
        return employee;
    }

    public List<Employee> list() {
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee e1 = new Employee("kerrie", "Channer", "1234567890", "28");
        Employee e2 = new Employee("Melta", "Mafela", "1234567890", "62");
        Employee e3 = new Employee("Lorraine", "Haye", "1234567890", "27");
        Employee e4 = new Employee("Zinzilee", "Mafela", "1234567890", "28");

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);

        return employeeList;
    }
}
