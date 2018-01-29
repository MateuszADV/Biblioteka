package pl.mateusz.demoJpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mateusz.demoJpa.models.AddBookModel;
import pl.mateusz.demoJpa.models.UserModel;
import pl.mateusz.demoJpa.models.forms.AddBookForm;
import pl.mateusz.demoJpa.models.repositories.AddBookRepisitory;
import pl.mateusz.demoJpa.models.repositories.BookRepository;
import pl.mateusz.demoJpa.models.repositories.UserRepository;
import pl.mateusz.demoJpa.models.services.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddBookRepisitory addBookRepisitory;

    @Autowired
    BookRepository bookRepository;

    private  UserModel userModel;

    @GetMapping("/")
    public String indexGet(Model model){
        userModel= userRepository.findByLogin(userService.getLogin());

        if(userService.isLogIn()==true){
            model.addAttribute("bookForm",new AddBookForm());
            checkLogin(model);
            bookList(model, userModel);

            return "index";
        }else {
            return "redirect:/login";
        }
    }

    private List<AddBookModel> addBookModels = new ArrayList<>();

    @PostMapping("/")
    public String indexPost(@ModelAttribute("bookForm")@Valid AddBookForm form, BindingResult result,
                            @RequestParam(value = "id",required = false) String someId,
                            Model model){



        if(someId!="" && someId!=null){     //sprawdzanie czy Id jest pustu lub null
            Boolean checkIdEqualsInList = checkIdBoogInList(someId); //zwraca czy dana książka którą user
                                                                    //chce usunąć znajduje sie w jego bazie książęk
            model.addAttribute("checkID",checkIdEqualsInList);
            System.out.println(checkIdEqualsInList);

            //Usuwanie książki na podstawie podanego id przez usera
            if(checkIdEqualsInList==true) {
                addBookRepisitory.delete(Integer.parseInt(someId)); //usuwanie książki o podanym id przez usera z bazy danych
                model.addAttribute("error", "Pomyślnie usunięto książkę o ID: " + someId);
                bookList(model, userModel);
                checkLogin(model);
                return "index";

               /* try {
                    model.addAttribute("error", "Pomyślnie usunięto książkę: " + someId);
                    addBookRepisitory.delete(Integer.parseInt(someId));
                    bookList(model, userModel);
                    return "index";
                } catch (Exception e) {
                    model.addAttribute("error", "Podane id nie istnieje: " + someId);
                    return "index";
                }*/
            }else {
                model.addAttribute("error", "Ksiązka o id " + someId+" nie istnieje w twojej bazie");
                bookList(model, userModel);
                checkLogin(model);
                return "index";
            }
        }

        UserModel userModel= userRepository.findByLogin(userService.getLogin());
        if(result.hasErrors() && userService.isLogIn()==true){
            bookList(model, userModel);
            checkLogin(model);
            return "index";
        }

        if(userService.isLogIn()==true){
            model.addAttribute("bookForm",new AddBookForm());
            checkLogin(model);              //Sprawdza czy User jest zalogowany
            addBook(form, userModel);       //Dodawanie nowej książki do bazy
            bookList(model, userModel);     //wysyłanie listy książek zalogowanego usera na strone
            return "redirect:/";
        }

        return "redirect:/login";
    }


    //-------------------------------------METODY--------------------------------------------------

    //Sprawdza czy id książki które wpisał urzytkownik jest w bazie książek, które dodał
    private Boolean checkIdBoogInList(@RequestParam(value = "id", required = false) String someId) {
        addBookModels = addBookRepisitory.findByWho(userModel.getId()); //pobranie listy książek usera
        Boolean checkIdEqualsInList=false;
        //pętla sprawdzająca czy dane id książki jest w bazie usera
        for (AddBookModel addBookModel : addBookModels) {
            if(addBookModel.getId()==Integer.parseInt(someId)){
                checkIdEqualsInList=true;  // zwraca true jeśli id książki zostało znalezione
            }
        }
        return checkIdEqualsInList;
    }

    // Dodawanei nowej ksiązki przez usera do bazy danych
    private void addBook(@ModelAttribute("bookForm") @Valid AddBookForm form, UserModel userModel) {
        AddBookModel addBookModel = new AddBookModel();
        addBookModel.setWho(userModel.getId());
        addBookModel.setTitle(form.getTitle());
        addBookModel.setAuthor(form.getAuthor());
        addBookModel.setPages(form.getPages());

        addBookRepisitory.save(addBookModel);
    }

    private void checkLogin(Model model) {
        model.addAttribute("isLogin",userService.isLogIn()); //wysyłanie na stronę czy user jest zalogowany
        model.addAttribute("login",userService.getLogin());  //wysyłanie na stronę loginu usera na stronę
    }

    private void bookList(Model model, UserModel userModel) {
        addBookModels = addBookRepisitory.findByWho(userModel.getId());  //pobieranie listy książek usera
        model.addAttribute("bookModel",addBookModels);      //wysyłanie lity książek na strone
    }
}
