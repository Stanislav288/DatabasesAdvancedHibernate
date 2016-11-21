package app.repository;

import app.domain.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{

    Person findPersonByName(String name);

    @Query("SELECT p FROM Person AS p " +
            "WHERE p.id NOT IN ( " +
            "SELECT p.id FROM Person AS p " +
            "INNER JOIN p.anomalies AS a)")
    List<Person> findPersonsNotAffectedByAnomalies();
}
