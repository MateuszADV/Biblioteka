package pl.mateusz.demoJpa.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz.demoJpa.models.AddBookModel;
import pl.mateusz.demoJpa.models.UserModel;

import java.util.List;

@Repository
public interface AddBookRepisitory extends CrudRepository<AddBookModel,Integer>{
    List<AddBookModel> findByWho(int id);
}
