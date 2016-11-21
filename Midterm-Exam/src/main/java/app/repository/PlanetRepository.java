package app.repository;

import app.domain.dto.JSON.exportDto.PlanetDto;
import app.domain.dto.JSON.exportDto.PlanetExportDto;
import app.domain.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Planet findPlanetByName(String name);

    @Query("SELECT p FROM Planet AS p WHERE p.id NOT IN " +
            "(SELECT p.id FROM Planet AS p JOIN p.teleportFromPlanetAnomalies) " +
            "AND p.id NOT IN " +
            "(SELECT p.id FROM Planet AS p JOIN p.teleportToPlanetAnomalies)")
    List<Planet> planetsNotAffectedByAnomalies();

    @Query("SELECT p.name AS name " +
            "FROM Planet AS p " +
            "WHERE p.id NOT IN (SELECT p.id " +
            "FROM Planet AS p " +
            "INNER JOIN p.teleportFromPlanetAnomalies)")
    List<PlanetDto> planetsNotOriginOfAnomaly();
}
