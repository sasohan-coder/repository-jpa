package bd.edu.seu.userregistration.service;


import bd.edu.seu.userregistration.model.Address;
import bd.edu.seu.userregistration.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Description of the file</h1>
 * <p></p>
 *
 * @author : Asaduzzaman Noor
 * @version : 2.0
 * @since : Wednesday, 12 November 2025 17:21
 */
@Service
public class UserService {
    private static final List<User> userList = new ArrayList<>();

    public User save(User user) {
        if (get(user.getEmail()) != null) {
            IO.println("User already exists");
            return null;
        }
        userList.add(user);

        return user;
    }

    public User get(String email) {
        return userList.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    public  boolean exists(String email, String password) {
        return userList.stream().anyMatch(u -> u.getEmail().equals(email) && u.getPassword().equals(password));
    }

    public List<User> getAll() {
        return userList;
    }

    public void delete(String email) {
        userList.removeIf(user -> user.getEmail().equals(email));
    }

    public void update(User user) {
        delete(user.getEmail());
        save(user);
    }

    public void testPrint() {
        IO.println("Hello from test print from UserService");
    }
}
