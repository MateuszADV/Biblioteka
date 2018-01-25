package pl.mateusz.demoJpa.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz.demoJpa.models.UserModel;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
    boolean existsByLoginAndPassword(String login, String password);        //sprawdza czy dane logowania istnieją w bazie
    boolean existsByLogin(String login);
    UserModel findByLogin(String login);
}
