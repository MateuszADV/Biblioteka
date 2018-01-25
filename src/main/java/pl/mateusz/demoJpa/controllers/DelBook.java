package pl.mateusz.demoJpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mateusz.demoJpa.models.repositories.AddBookRepisitory;
import pl.mateusz.demoJpa.models.services.UserService;

import java.lang.reflect.Executable;

@Controller
public class DelBook {

    @Autowired
    AddBookRepisitory addBookRepisitory;

    @Autowired
    UserService userService;


    @GetMapping("/delBook")
    public String delBookGet(){
        if(userService.isLogIn()==true){

            return "delBook";
        }

        return "login";
    }

    @PostMapping("/delBook")
    public String delBookPost(@RequestParam("id") String someId, Model model){

        if (userService.isLogIn()==true) {
            model.addAttribute("error", "podane Id to: " + someId);
       /* try
        {
            addBookRepisitory.delete(Integer.parseInt(someId));
            model.addAttribute("error","pomyśnie usunięto książke o Id "+someId);
        }catch (Exception e){
            model.addAttribute("error", "poane Id nieistnieje "+someId);

        }*/
       return "delBook";
        }
        return "/login";
    }
}
