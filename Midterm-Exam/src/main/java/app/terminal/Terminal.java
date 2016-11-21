package app.terminal;

import app.domain.dto.JSON.exportDto.AnomalyDto;
import app.domain.dto.JSON.exportDto.PlanetDto;
import app.domain.dto.JSON.exportDto.PlanetExportDto;
import app.domain.models.Anomaly;
import app.domain.models.Person;
import app.domain.models.Planet;
import app.parser.JSONParserImpl;
import app.parser.XMLParser;
import app.parser.XMLParserImpl;
import app.repository.PlanetRepository;
import app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by ASUS on 11/19/2016.
 */
@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private PlanetService planetService;

    @Autowired
    private SolarSystemService solarSystemService;

    @Autowired
    private StarService starService;

    @Autowired
    private AnomalyService anomalyService;

    @Autowired
    private PersonService personService;

    @Autowired
    private JSONParserImpl jsonParser;

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public void run(String... strings) throws Exception {

       // this.solarSystemService.importSolarSystemsFromJSON();
        //this.starService.importStarFromJSON();
        //this.planetService.importPlanetsFromJSON();
        //this.personService.importPersonsFromJSON();
       // this.anomalyService.importAnomaliesFromJSON();
        //this.anomalyService.importAnomaliesVictimsFromJSON();

        //this.anomalyService.importAnomaliesFromXML();

       // String path="C:\\Users\\ASUS\\Desktop\\Midterm Exam\\Exam\\src\\main\\resources\\files\\output\\json\\planetsNotAffectedByAnomalies.json";
      // this.jsonParser.writeToJSON(this.planetService.planetsNotAffectedByAnomalies().get(0).getName(),path);

       //this.planetService.planetsNotOriginOfAnomalyToJSON();

       // this.personService.personsNotAffectedByAnomaliesToJSON();

        //this.anomalyService.anomalyWithMostAffectedPeopleToJSON();
        this.anomalyService.exportAllAnomaliesToXML();
    }
}
