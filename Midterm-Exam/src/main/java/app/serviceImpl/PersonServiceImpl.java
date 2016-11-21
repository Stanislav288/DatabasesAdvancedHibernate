package app.serviceImpl;

import app.domain.dto.JSON.exportDto.PersonExportDto;
import app.domain.dto.JSON.exportDto.PlanetExportDto;
import app.domain.dto.JSON.importDto.PersonImportDto;
import app.domain.models.Person;
import app.domain.models.Planet;
import app.parser.JSONParserImpl;
import app.repository.PersonRepository;
import app.service.PersonService;
import app.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private JSONParserImpl jsonParser;

    @Autowired
    private PlanetService planetService;

    @Override
    public List<Person> findPersons() {
        return this.personRepository.findAll();
    }

    @Override
    public Person findPerson(long id) {
        return this.personRepository.findOne(id);
    }

    @Override
    public void save(Person person) {
        this.personRepository.saveAndFlush(person);
    }

    @Override
    public void importPersonsFromJSON() {
        String path = "src/main/resources/files/input/json/persons.json";
        PersonImportDto[] personImportDtos = new PersonImportDto[]{};
        personImportDtos = this.jsonParser.readFromJSON(PersonImportDto[].class, path);

        for (PersonImportDto personImportDto : personImportDtos) {

            String personName=personImportDto.getName();
            if(personName.isEmpty() || personName==null ){
                System.out.println("Error: Invalid data.");
                continue;
            }


            Planet homePlanet = this.planetService.findPlanetByName(personImportDto.getHomePlanet());
            if (homePlanet == null) {
                System.out.println("Error: Invalid data.");
                continue;
            }

            Person person=new Person();
            person.setName(personName);
            person.setHomePlanet(homePlanet);

            this.save(person);

            System.out.printf("Successfully imported %s %s.\n","Person",person.getName());
        }
    }

    @Override
    public Person findPersonByName(String name) {
        return this.personRepository.findPersonByName(name);
    }

    @Override
    public List<Person> findPersonsNotAffectedByAnomalies() {
        return this.personRepository.findPersonsNotAffectedByAnomalies();
    }

    @Override
    public void personsNotAffectedByAnomaliesToJSON(){
        String path="src\\main\\resources\\files\\output\\json\\persons-not-affected-by-anomalies.json";

        List<Person> personsFromDb=this.findPersonsNotAffectedByAnomalies();

        List<PersonExportDto> personsToJSON=new ArrayList<>();
        for (int i = 0; i <personsFromDb.size() ; i++) {

            PlanetExportDto planetExportDto=new PlanetExportDto();
            planetExportDto.setName(personsFromDb.get(i).getHomePlanet().getName());

            PersonExportDto personExportDto=new PersonExportDto();
            personExportDto.setName(personsFromDb.get(i).getName());
            personExportDto.setHomePlanet(planetExportDto);

            personsToJSON.add(personExportDto);
        }

        this.jsonParser.writeToJSON(personsToJSON,path);
    }
}
