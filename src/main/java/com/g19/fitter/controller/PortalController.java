package com.g19.fitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Created by davidsudia on 4/27/16.
 */
@Controller
public class PortalController {

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }
}
