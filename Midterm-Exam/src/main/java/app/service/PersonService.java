package app.service;

import app.domain.models.Person;

import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */
public interface PersonService {

    List<Person> findPersons();

    Person findPerson(long id);

    void save(Person person);

    void importPersonsFromJSON();

    Person findPersonByName(String name);

    List<Person> findPersonsNotAffectedByAnomalies();

    void personsNotAffectedByAnomaliesToJSON();
}
