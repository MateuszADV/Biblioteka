package pl.mateusz.demoJpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mateusz.demoJpa.models.AddBookModel;
import pl.mateusz.demoJpa.models.BookModel;
import pl.mateusz.demoJpa.models.UserModel;
import pl.mateusz.demoJpa.models.repositories.AddBookRepisitory;
import pl.mateusz.demoJpa.models.repositories.BookRepository;
import pl.mateusz.demoJpa.models.repositories.UserRepository;
import pl.mateusz.demoJpa.models.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AddBookRepisitory addBookRepisitory;

    private List<UserModel> userModelList = new ArrayList<>();
    private List<AddBookModel> addBookModels = new ArrayList<>();

    @GetMapping("/test")
   // @ResponseBody
    public String userGet(Model model){

       /* UserModel userModel = new UserModel();
        userModel.setLogin("Loginlogin");
        userModel.setName("Karolak");
        userModel.setPassword("Tajnehaslopoeinnobyc");

        userRepository.save(userModel);*/

        addBookModels = addBookRepisitory.findByWho(9);


        model.addAttribute("userModel",addBookModels);
        //return "Utworzyłem nowy rekord w bazie";
        //return "Autor: "+userModel.getBookModels();
        return "test";
    }
   /* @GetMapping("/text/")
    @ResponseBody
    public String textGet(){
        return userService.getText();
    }

    @GetMapping("/text/{text}")
    @ResponseBody
    public String textGet(@PathVariable("text") String cos){
        userService.setText(cos);
        return "Zmieniłem text";
    }*/
}
