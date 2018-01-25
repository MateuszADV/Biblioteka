package pl.mateusz.demoJpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mateusz.demoJpa.models.BookModel;
import pl.mateusz.demoJpa.models.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookControler {

    @Autowired
    BookRepository repository;

    List<BookModel> listBook =new ArrayList<>();

    @GetMapping("/book")
    @ResponseBody
    public String bookGet(){

        //listBook=repository.findAllBy();

        //listBook = repository.findByPagesGreaterThan(400);
        //listBook = repository.findByAuthorContaining("K");
        //listBook = repository.findByAuthorIgnoreCaseStartingWith("m");
        //listBook=repository.findByPagesBetween(600,1000);

         BookModel bookModel = repository.findOne(7);

//
//        BookModel bookModel = new BookModel();
//        bookModel.setWho(2);
//        bookModel.setTitle("Repozytory");
//        bookModel.setAuthor("Kowalski");
//        bookModel.setPages(987);
//        repository.save(bookModel);

       // return listBook.toString();
        return "Autor: "+bookModel.getWho().getName()+" "+bookModel.getAuthor();
    }
}
