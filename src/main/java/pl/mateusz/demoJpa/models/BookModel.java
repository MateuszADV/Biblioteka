package pl.mateusz.demoJpa.models;

import pl.mateusz.demoJpa.models.forms.AddBookForm;

import javax.persistence.*;

@Entity
@Table(name="book")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne //RElacja wiele do ednego
    @JoinColumn(name = "who") //tworzymy nową kolumnę who do wyswietlenia, podajemy nazwę kolumny jeśli jest inna
    private UserModel who;// pobiera Automatyczne id z UserModel
    private String title;
    private String author;
    private int pages;

    public BookModel(){

    }

    public BookModel(int id, UserModel who, String title, String author, int pages) {
        this.id = id;
        this.who = who;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public BookModel(AddBookForm form){
        this.who=form.getWho();
        this.title=form.getTitle();
        this.author=form.getAuthor();
        this.pages=form.getPages();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getWho() {
        return who;
    }

    public void setWho(UserModel who) {
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

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", who=" + who +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +"\n"+
                '}';
    }
}
