//package com.g19.fitter.controller;
//
//import com.g19.fitter.database.UserAccount;
//import com.g19.fitter.database.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import java.security.Principal;
//
///*
// * Created by davidsudia on 4/27/16.
// */
//@Controller
//@SessionAttributes("user")
//public class PortalController {
//
//    @Autowired
//    UserService userService;
//
//    @RequestMapping("/")
//    public String getIndex() {
//        return "index";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String getLogin() {
//        return "login";
//    }
//
//    @RequestMapping(value = "/signup", method = RequestMethod.GET)
//    public String getSignup(Model model) {
//        UserAccount newUser = new UserAccount();
//        model.addAttribute("user", newUser);
//        return "signup";
//    }
//
//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public String addUser(@ModelAttribute("user") UserAccount userAccount) {
//        System.out.println("signup post was called");
//        userService.create(userAccount);
//        return "redirect:/login?success=true";
//    }
//
//    @RequestMapping("/myaccount")
//    public String myAccount(ModelMap modelMap, Principal principal) {
//        String username = principal.getName();
//        System.out.println(username);
//        UserAccount user = userService.getByUsername(username);
//        modelMap.put("user", user);
//        return "account";
//    }
//
//    @RequestMapping("/docs")
//    public String docs() {
//        return "docs";
//    }
//}
