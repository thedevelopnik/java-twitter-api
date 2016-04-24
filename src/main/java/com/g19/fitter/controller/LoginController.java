package com.g19.fitter.controller;

import com.g19.fitter.data.UserRepository;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created by davidsudia on 4/15/16.
 */
@Controller
@Component
public class LoginController {

    private Twitter twitter;
    private UserRepository userRepository;

    private ConnectionRepository connectionRepository;

    @Inject
    public LoginController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(value = "/developer", method = RequestMethod.GET)
    public String loginTwitter(Model model) {
        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
            return "redirect:/connect/twitter";
        }

        model.addAttribute(twitter.userOperations().getUserProfile());
        return "You are logged in!";
    }
}
