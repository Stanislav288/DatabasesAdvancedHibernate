package app.repository;

import app.domain.models.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 11/19/2016.
 */

@Repository
public interface SolarSystemRepository extends JpaRepository<SolarSystem,Long> {

    SolarSystem findSolarSystemByName(String name);
}
