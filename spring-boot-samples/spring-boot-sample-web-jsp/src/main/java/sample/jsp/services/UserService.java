package sample.jsp.services;

import org.springframework.stereotype.Component;
import sample.jsp.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tm1c14 on 26/06/2015.
 */
@Component
public class UserService {

    public List<User> getList() {
        String [] users = {"thando.p0", "kerrie.p1", "Melta.p2", "Zinzilee.p3", "Fikile.p4"};
        List<User> userList = new ArrayList<User>();

        for(String s : users) {
            String [] array = s.split("\\.");
            User user = new User(array[0], array[1]);
            userList.add(user);
        }

        return userList;
    }

    public User save(User user){
        System.out.println("User has been saved");
        return user;
    }
}
