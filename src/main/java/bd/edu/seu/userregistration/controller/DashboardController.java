package bd.edu.seu.userregistration.controller;

import bd.edu.seu.userregistration.model.User;
import bd.edu.seu.userregistration.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {
    private final UserService userService;

    public DashboardController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexPage(Model model, HttpSession session) {
        String name = (String) session.getAttribute("name");
        if (name != null) {
            List<User> userList = userService.getAll();
            IO.println("Users: " + userList.size());

            model.addAttribute("name", name);
            model.addAttribute("users", userList);

            return "dashboard";
        } else {
            return "redirect:login";
        }
    }
}
