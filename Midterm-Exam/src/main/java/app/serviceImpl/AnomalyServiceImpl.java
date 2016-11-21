package app.serviceImpl;

import app.domain.dto.JSON.exportDto.AnomalyDto;
import app.domain.dto.JSON.exportDto.AnomalyExportDto;
import app.domain.dto.JSON.exportDto.PlanetExportDto;
import app.domain.dto.JSON.importDto.AnomalyImportDto;
import app.domain.dto.JSON.importDto.AnomalyVictimsImportDto;
import app.domain.dto.XML.exportDto.AnomaliesExportXMLDto;
import app.domain.dto.XML.exportDto.AnomalyExportXMLDto;
import app.domain.dto.XML.exportDto.VictimExportXMLDto;
import app.domain.dto.XML.importDto.AnomaliesImportDto;
import app.domain.dto.XML.importDto.AnomalyWithVictimImportDto;
import app.domain.dto.XML.importDto.VictimImportDto;
import app.domain.models.Anomaly;
import app.domain.models.Person;
import app.domain.models.Planet;
import app.parser.JSONParserImpl;
import app.parser.XMLParser;
import app.repository.AnomalyRepository;
import app.service.AnomalyService;
import app.service.PersonService;
import app.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */
@Service
@Transactional
public class AnomalyServiceImpl implements AnomalyService {

    @Autowired
    private AnomalyRepository anomalyRepository;

    @Autowired
    private JSONParserImpl jsonParser;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private PersonService personService;

    @Autowired
    private XMLParser xmlParser;


    @Override
    public List<Anomaly> findAnomalies() {
        return this.anomalyRepository.findAll();
    }

    @Override
    public Anomaly findAnomaly(long id) {
        return this.anomalyRepository.findOne(id);
    }

    @Override
    public void save(Anomaly anomaly) {
        this.anomalyRepository.saveAndFlush(anomaly);
    }

    @Override
    public void importAnomaliesFromJSON() {
        String path = "src/main/resources/files/input/json/anomalies.json";
        AnomalyImportDto[] anomalyImportDtos = new AnomalyImportDto[]{};
        anomalyImportDtos = this.jsonParser.readFromJSON(AnomalyImportDto[].class, path);

        for (AnomalyImportDto anomalyImportDto : anomalyImportDtos) {

            Planet originPlanet = this.planetService.findPlanetByName(anomalyImportDto.getOriginPlanet());
            if (originPlanet == null) {
                System.out.println("Error: Invalid data.");
                continue;
            }

            Planet teleportPlanet = this.planetService.findPlanetByName(anomalyImportDto.getTeleportPlanet());
            if (teleportPlanet == null) {
                System.out.println("Error: Invalid data.");
                continue;
            }

            Anomaly anomaly = new Anomaly();
            anomaly.setOriginPlanet(originPlanet);
            anomaly.setTeleportPlanet(teleportPlanet);

            this.save(anomaly);

            System.out.println("Successfully imported anomaly.");
        }
    }

    @Override
    public void importAnomaliesVictimsFromJSON() {
        String path = "src/main/resources/files/input/json/anomaly-victims.json";
        AnomalyVictimsImportDto[] anomalyVictimsImportDtos = new AnomalyVictimsImportDto[]{};
        anomalyVictimsImportDtos = this.jsonParser.readFromJSON(AnomalyVictimsImportDto[].class, path);

        for (AnomalyVictimsImportDto anomalyVictimsImportDto : anomalyVictimsImportDtos) {

            Anomaly anomaly = this.anomalyRepository.getOne(anomalyVictimsImportDto.getId());
            if (anomaly == null) {
                // System.out.println("Error: Invalid data.");
                continue;
            }

            Person person = this.personService.findPersonByName(anomalyVictimsImportDto.getPerson());
            if (person == null) {
                // System.out.println("Error: Invalid data.");
                continue;
            }

            anomaly.getVictims().add(person);
            this.save(anomaly);

            System.out.println("Successfully imported anomaly.");
        }
    }

    public void importAnomaliesFromXML() throws JAXBException {
        String path = "src\\main\\resources\\files\\input\\xml\\new-anomalies.xml";
        AnomaliesImportDto anomaliesImportDto;
        anomaliesImportDto = this.xmlParser.readFromXml(AnomaliesImportDto.class, path);

        for (AnomalyWithVictimImportDto anomalyWithVictimImportDto : anomaliesImportDto.getAnomalies()) {

            Planet originPlanet = this.planetService.findPlanetByName(anomalyWithVictimImportDto.getOriginPlanet());
            if (originPlanet == null) {
                System.out.println("Error: Invalid data.");
                continue;
            }

            Planet teleportPlanet = this.planetService.findPlanetByName(anomalyWithVictimImportDto.getTeleportPlanet());
            if (teleportPlanet == null) {
                System.out.println("Error: Invalid data.");
                continue;
            }

            Anomaly anomaly = new Anomaly();
            anomaly.setTeleportPlanet(teleportPlanet);
            anomaly.setOriginPlanet(originPlanet);

            List<Person> victims = new ArrayList<>();
            for (VictimImportDto victimImportDto : anomalyWithVictimImportDto.getVictims()) {
                Person person = this.personService.findPersonByName(victimImportDto.getName());
                if (person == null) {
                    // System.out.println("Error: Invalid data.");
                    continue;
                }

                victims.add(person);
            }

            anomaly.getVictims().addAll(victims);
            this.save(anomaly);
            System.out.println("Successfully imported data.");
        }
    }

    @Override
    public Object findAnomalyWithMostAffectedPeople() {
        return this.anomalyRepository.findAnomalyWithMostAffectedPeople();
    }

    @Override
    public void anomalyWithMostAffectedPeopleToJSON() {
        String path="src\\main\\resources\\files\\output\\json\\anomaly-with-most-affected-people.json";

        Object[] anomalyInfo = (Object[]) this.findAnomalyWithMostAffectedPeople();
        Anomaly anomaly = (Anomaly) anomalyInfo[0];
        long victimsCount = (long) anomalyInfo[1];

        PlanetExportDto originPlanet=new PlanetExportDto();
        originPlanet.setName(anomaly.getOriginPlanet().getName());

        PlanetExportDto teleportPlanet=new PlanetExportDto();
        teleportPlanet.setName(anomaly.getTeleportPlanet().getName());

        AnomalyExportDto anomalyExportDto=new AnomalyExportDto();
        anomalyExportDto.setId(anomaly.getId());
        anomalyExportDto.setOriginPlanet(originPlanet);
        anomalyExportDto.setTeleportPlanet(teleportPlanet);
        anomalyExportDto.setVictimsCount(victimsCount);

        this.jsonParser.writeToJSON(anomalyExportDto,path);
    }

    @Override
    public void exportAllAnomaliesToXML() throws JAXBException {
        String path="src\\main\\resources\\files\\output\\xml\\all-anomalies.xml";

        List<Anomaly> anomalies=this.findAnomalies();

        AnomaliesExportXMLDto anomaliesExportXMLDto=new AnomaliesExportXMLDto();

        for (Anomaly anomaly:anomalies) {

            AnomalyExportXMLDto anomalyExportDto=new AnomalyExportXMLDto();
            anomalyExportDto.setId(anomaly.getId());
            anomalyExportDto.setTeleportPlanet(anomaly.getTeleportPlanet().getName());
            anomalyExportDto.setOriginPlanet(anomaly.getOriginPlanet().getName());


            for (Person person:anomaly.getVictims()) {
                VictimExportXMLDto victimExportXMLDto=new VictimExportXMLDto();
                victimExportXMLDto.setName(person.getName());

                anomalyExportDto.getVictims().add(victimExportXMLDto);
            }

            anomaliesExportXMLDto.getAnomalyExportDtos().add(anomalyExportDto);
        }

        this.xmlParser.writeToXml(anomaliesExportXMLDto,path);
    }
}
