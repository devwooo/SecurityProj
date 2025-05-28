package com.made.securityproj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class COMainController {

    @GetMapping(value = "/")
    public String getMainPage() throws Exception {
        try {

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return "pages/index";
    }

}
