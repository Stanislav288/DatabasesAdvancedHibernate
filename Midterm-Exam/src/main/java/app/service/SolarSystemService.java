package app.service;

import app.domain.models.SolarSystem;

import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */
public interface SolarSystemService {

    List<SolarSystem> findSolarSystems();

    SolarSystem findSolarSystem(long id);

    void save(SolarSystem solarSystem);

    void importSolarSystemsFromJSON();

    SolarSystem findSolarSystemByName(String name);
}
