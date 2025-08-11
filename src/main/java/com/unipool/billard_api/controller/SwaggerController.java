package com.unipool.billard_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {
    @GetMapping("/")
    public String redirectToSwagger() {
        return "redirect:/swagger-ui.html"; // ou "/swagger-ui/index.html" selon votre version
    }
}
