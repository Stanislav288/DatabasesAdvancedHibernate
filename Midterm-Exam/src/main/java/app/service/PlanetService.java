package app.service;

import app.domain.dto.JSON.exportDto.PlanetDto;
import app.domain.dto.JSON.exportDto.PlanetExportDto;
import app.domain.models.Planet;

import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */
public interface PlanetService {

    List<Planet> findPlanets();

    Planet findPlanet(long id);

    void save(Planet planet);

    void importPlanetsFromJSON();

    Planet findPlanetByName(String name);

    List<Planet> planetsNotAffectedByAnomalies();

    List<PlanetDto> planetsNotOriginOfAnomaly();

    void planetsNotOriginOfAnomalyToJSON();
}
