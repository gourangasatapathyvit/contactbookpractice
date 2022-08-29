package com.contact.contactbook_prac.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.contact.contactbook_prac.model.User;
import com.contact.contactbook_prac.modelRepo.UserRepo;

@Controller
public class HomeController implements WebMvcConfigurer {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/signup").setViewName("signup");
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/regester")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result,
            @RequestParam(value = "checkbox", defaultValue = "false") boolean checkbox) {
        try {

            if (result.hasErrors()) {
                return "signup";
            }

            System.out.println(checkbox);
            System.out.println(user);

            if (checkbox == true) {
                System.out.println("checkbox ticked");
                userRepo.save(user);

            }
            return "signup";

        } catch (Exception e) {
            return "/";

        }
    }

}
