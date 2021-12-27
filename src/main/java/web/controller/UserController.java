package web.controller;


import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    @Qualifier(value = "userServiceImpl")
    private UserService userService;

    @GetMapping("allUsers")
    public String AllUsers(Model model) {
        List<User> userList = userService.allUsers();
        model.addAttribute("usersList", userList);
        return "AllUsers";
    }

    @GetMapping(value = "/id")
    public String getById(@PathVariable int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "getById";
    }

    @GetMapping(value = "/new")
    public String createNewUsersT(@ModelAttribute("user") User user) {
        return "NewUser";
    }

    @PostMapping("/")
    public String createNewUser(@ModelAttribute ("user") User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "NewUser";
        }
        userService.add(user);
        return "redirect:/AllUsers";
    }

    @GetMapping("/id/edit")
    public String edit(Model model, @PathVariable int id){
        model.addAttribute("user", userService.getById(id));
        return "Edit";
    }

    @PatchMapping("/id")
    public String update(@ModelAttribute("user") User user, @PathVariable ("id") int id) {
        userService.edit(user);
        return "redirect:/AllUsers";
    }

    @DeleteMapping("/id")
    public String delete(@ModelAttribute("user") User user, @PathVariable ("id") int id) {
        userService.delete(user);
        return "redirect:/AllUsers";
    }

}
