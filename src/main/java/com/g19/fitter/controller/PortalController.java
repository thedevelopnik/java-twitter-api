package com.g19.fitter.controller;

import com.g19.fitter.database.UserAccount;
import com.g19.fitter.database.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/*
 * Created by davidsudia on 4/27/16.
 */
@Controller
@SessionAttributes("user")
public class PortalController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignup(Model model) {
        UserAccount newUser = new UserAccount();
        model.addAttribute("user", newUser);
        System.out.println(model);
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") UserAccount userAccount) {
        System.out.println(userAccount.getUsername());
        System.out.println(userAccount.getFirstname());
        System.out.println(userAccount.getLastname());
        System.out.println("signup post was called");
        userService.create(userAccount);
        return "redirect:/login?success=true";
    }
}
