package app.serviceImpl;

import app.domain.dto.JSON.exportDto.PlanetDto;
import app.domain.dto.JSON.exportDto.PlanetExportDto;
import app.domain.dto.JSON.importDto.PlanetImportDto;
import app.domain.models.Planet;
import app.domain.models.SolarSystem;
import app.domain.models.Star;
import app.parser.JSONParserImpl;
import app.repository.PlanetRepository;
import app.service.PlanetService;
import app.service.SolarSystemService;
import app.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */
@Service
public class PlanetServiceImpl implements PlanetService{

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private JSONParserImpl jsonParser;

    @Autowired
    private StarService starService;

    @Autowired
    private SolarSystemService solarSystemService;

    @Override
    public List<Planet> findPlanets() {
        return this.planetRepository.findAll();
    }

    @Override
    public Planet findPlanet(long id) {
        return this.planetRepository.findOne(id);
    }

    @Override
    public void save(Planet planet) {
        this.planetRepository.saveAndFlush(planet);
    }

    @Override
    public void importPlanetsFromJSON() {
        String path="src/main/resources/files/input/json/planets.json";
        PlanetImportDto[] planetImportDtos=new PlanetImportDto[]{};
        planetImportDtos=this.jsonParser.readFromJSON(PlanetImportDto[].class,path);

        for (PlanetImportDto planetImportDto:planetImportDtos) {

            String planetName=planetImportDto.getName();
            if(planetName.toString().isEmpty() || planetName==null ){
                System.out.println("Error: Invalid data.");
                continue;
            }

            SolarSystem solarSystem=this.solarSystemService.findSolarSystemByName(planetImportDto.getSolarSystem());
            if(solarSystem==null){
                System.out.println("Error: Invalid data.");
                continue;
            }

            Star star=this.starService.findStarByName(planetImportDto.getSun());
            if(star==null){
                System.out.println("Error: Invalid data.");
                continue;
            }

            Planet planet=new Planet();
            planet.setName(planetName);
            planet.setSolarSystem(solarSystem);
            planet.setSun(star);

            this.save(planet);

            System.out.printf("Successfully imported %s %s.\n","Planet",planet.getName());
        }
    }

    @Override
    public Planet findPlanetByName(String name) {
        return this.planetRepository.findPlanetByName(name);
    }

    @Override
    public List<Planet> planetsNotAffectedByAnomalies() {
        return this.planetRepository.planetsNotAffectedByAnomalies();
    }

    @Override
    public List<PlanetDto> planetsNotOriginOfAnomaly() {
        return this.planetRepository.planetsNotOriginOfAnomaly();
    }

    @Override
    public void planetsNotOriginOfAnomalyToJSON() {
        String path="src\\main\\resources\\files\\output\\json\\planets-not-origin-of-anomaly.json";

        List<PlanetExportDto> planets=new ArrayList<>();

        for (PlanetDto planetDto :this.planetsNotOriginOfAnomaly()) {
            PlanetExportDto planetExportDto=new PlanetExportDto();
            planetExportDto.setName(planetDto.getName());

            planets.add(planetExportDto);
        }

        this.jsonParser.writeToJSON(planets,path);
    }

}
