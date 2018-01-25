package pl.mateusz.demoJpa.models;

import pl.mateusz.demoJpa.models.forms.RegisterForm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //pokazujeHibernate że jest to wartość zwiększana automatycznie
    private int id;
    private String login;
    private String password;
    private String name;
    @Transient // Hibernate nie mapuje tego pola
    private String polePomocnicze;

    @OneToMany(mappedBy = "who") //Spring wie poczym ma mapować jeden urzytkownik do wielu ksiażek
    List<BookModel> bookModels;

    public UserModel(){

    }
    public UserModel(int id, String login, String password, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public UserModel(RegisterForm form) {
        this.login=form.getLogin();
        this.password=form.getPassword();
        this.name=form.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookModel> getBookModels() {
        return bookModels;
    }

    public void setBookModels(List<BookModel> bookModels) {
        this.bookModels = bookModels;
    }
}
