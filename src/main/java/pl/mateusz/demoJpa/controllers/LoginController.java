package pl.mateusz.demoJpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mateusz.demoJpa.models.UserModel;
import pl.mateusz.demoJpa.models.forms.RegisterForm;
import pl.mateusz.demoJpa.models.repositories.UserRepository;
import pl.mateusz.demoJpa.models.services.UserService;

import javax.swing.*;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String loginGet(){
        userService.setLogIn(false);
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam("login") String login,
                            @RequestParam("password") String password,
                            Model model){
        boolean isCorectData=userRepository.existsByLoginAndPassword(login,password);

        if(isCorectData){
            userService.setLogIn(true);
            userService.setLogin(login);
            model.addAttribute("isLogin",userService.isLogIn());
            model.addAttribute("login",login);
            return "redirect:/";
        }else {
            model.addAttribute("info", "Błędne dane logowania");
            return "login";
        }

    }


    //====================================================

    @GetMapping("/register")
    public String registerGet(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("registerForm")@Valid RegisterForm form, BindingResult result,Model model){

        boolean checkLogin = userRepository.existsByLogin(form.getLogin());

        if(result.hasErrors()){
            System.out.println("Ma błędy!!!!!!");
            return "register";
        }else if(checkLogin){
            model.addAttribute("checkLogin", "Poany login już istnieje");
            return "register";
        }else{
            userRepository.save(new UserModel(form));
            model.addAttribute("logIn","Rejestracja się powiodła");
            return "login";
        }

    }
}
