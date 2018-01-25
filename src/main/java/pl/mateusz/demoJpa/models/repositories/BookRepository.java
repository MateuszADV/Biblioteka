package pl.mateusz.demoJpa.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz.demoJpa.models.BookModel;
import pl.mateusz.demoJpa.models.UserModel;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookModel, Integer> {
    List<BookModel> findAllBy();
    List<BookModel> findByPagesGreaterThan(int gt); //wyszukuje książki ktre mają więcej stron niż
    List<BookModel> findByAuthorContaining (String litera);   //sprawdza czyt tytuł zawiera dany ciąg znaków
    List<BookModel> findByAuthorIgnoreCaseStartingWith(String litera);
    List<BookModel> findByPagesBetween(int poczatek, int koniec);

}
