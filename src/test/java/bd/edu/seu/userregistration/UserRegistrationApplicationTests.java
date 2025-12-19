package bd.edu.seu.userregistration;

import bd.edu.seu.userregistration.model.User;
import bd.edu.seu.userregistration.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRegistrationApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testMethod() {
        IO.println("Hello from test method");
    }

    @Test
    public void testMethod2() {
        IO.println("Hello from test method2");
        User user = new User();
        user.setId(101);
        user.setName("John");
        userService.save(user);

        List<User> userList = userService.getAll();
        IO.println("Size: " + userList.size());
        for (User u : userList) {
            System.out.println(u.getId() + " " + u.getName());
        }
    }

}
