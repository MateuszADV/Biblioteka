package pl.mateusz.demoJpa.models;

import pl.mateusz.demoJpa.models.forms.AddBookForm;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class AddBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int who;
    private String title;
    private String author;
    private int pages;

    public AddBookModel(){

    }

    public AddBookModel(int id, int who, String title, String author, int pages) {
        this.id = id;
        this.who = who;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWho() {
        return who;
    }

    public void setWho(int who) {
        this.who = who;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
