package bd.edu.seu.userregistration.controller;

import bd.edu.seu.userregistration.dto.LoginDto;
import bd.edu.seu.userregistration.dto.RegistrationDto;
import bd.edu.seu.userregistration.model.User;
import bd.edu.seu.userregistration.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login")
    public String loginPage(Model model, HttpSession session) {
        String name = (String) session.getAttribute("name");
        if (name != null) {
            return "redirect:/";
        } else {
            model.addAttribute("dto", new LoginDto("", "", false));
            return "login";
        }

    }

    @PostMapping("login")
    public String login(@ModelAttribute LoginDto dto, Model model, HttpSession session){
        IO.println("Login: " + dto);

        if(userService.exists(dto.email(), dto.password())){
            User user = userService.get(dto.email());
            session.setAttribute("name", user.getName());

            return "redirect:/";
        } else {
            return "redirect:login?login=failed";
        }
    }

    /***************************************/
    /***************************************/
    /***************************************/
    /***************************************/

    @GetMapping("registration")
    public String registrationPage(Model model, HttpSession session) {
        String name = (String) session.getAttribute("name");
        if (name != null) {
            return "redirect:/";
        } else {
            model.addAttribute("dto", new RegistrationDto("", "", ""));
            return "registration";
        }
    }

    @PostMapping("registration")
    public String doRegistration(@ModelAttribute RegistrationDto dto) {
        IO.println("Registration: " + dto);

        User user = userService.save(dto.toUser());
        if (user == null) {
            return "redirect:registration?signup=failed";
        } else {
            return "redirect:login?signup=true";
        }

    }

    /***************************************/
    /***************************************/
    /***************************************/
    /***************************************/

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login?logout=true";
    }
}
