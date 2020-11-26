package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSubmit(@ModelAttribute UserModel user, Model model){
        UserModel userModel = userService.addUser((user));
        if(userModel == null) model.addAttribute("status", false);
        else model.addAttribute("status", true);
        model.addAttribute("user", user);
        return "home";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String updatePassword(HttpServletRequest request, Model model){
        String username = request.getRemoteUser();
        String[] listPassword = request.getParameterValues("password");
        boolean updateStatus = userService.updatePassword(username, listPassword);
        model.addAttribute("status", updateStatus);

        return "change-password";
    }

    @GetMapping("/update")
    public String updatePage(Model model){
        model.addAttribute("status", true);
        return "change-password";
    }
}
