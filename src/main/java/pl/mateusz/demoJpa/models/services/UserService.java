package pl.mateusz.demoJpa.models.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS) //Ustawia zasięg sesyjny kazdy będzie miał
public class UserService {                                              //swoją sesję

    private String login;
    private boolean isLogIn;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isLogIn() {
        return isLogIn;
    }

    public void setLogIn(boolean logIn) {
        isLogIn = logIn;
    }
}

