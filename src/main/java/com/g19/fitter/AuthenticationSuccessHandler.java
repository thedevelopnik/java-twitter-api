//package com.g19.fitter;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///*
// * Created by davidsudia on 4/28/16.
// */
//public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {
//
//    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        handle(request, response, authentication);
//    }
//
//    private void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
//        String targetUrl = "/myaccount";
//
//        try {
//            redirectStrategy.sendRedirect(request, response, targetUrl);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
