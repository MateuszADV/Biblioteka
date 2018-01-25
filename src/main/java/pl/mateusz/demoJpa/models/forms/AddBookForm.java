package pl.mateusz.demoJpa.models.forms;

import org.hibernate.validator.constraints.NotEmpty;
import pl.mateusz.demoJpa.models.UserModel;

public class AddBookForm {
    private UserModel who;
    @NotEmpty(message = "pole nie może być puste")
    private String title;
    @NotEmpty(message = "pole nie może być puste")
    private String author;
    private int pages;

    public AddBookForm(){

    }

    public AddBookForm(UserModel who, String title, String author, int pages) {
        this.who = who;
        this.title = title;
        this.author = author;
        this.pages = pages;
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
}
