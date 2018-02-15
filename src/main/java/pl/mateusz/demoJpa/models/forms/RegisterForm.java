package pl.mateusz.demoJpa.models.forms;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterForm {

    @Size(min=3,max=20,message = "Login musi mieć min: 3 znaki a max: 20 znaków")
    private String login;
    @Size(min=5,max=20, message = "Hasło musi mieć min: 5 znaki a max: 20 znaków")
    private String password;
    @Pattern(regexp = "[A-Za-z]+ [A-Za-z]+",message = "Forma name to Name Lastname")
    private String name;

    public RegisterForm(){

    }

    public RegisterForm(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
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
}
