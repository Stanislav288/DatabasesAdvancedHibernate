package app.domain.dto.JSON.exportDto;

/**
 * Created by ASUS on 11/21/2016.
 */
public interface AnomalyDto {

    long getId();

    void setId(long id);

    PlanetExportDto getOriginPlanet();

    void setOriginPlanet(PlanetExportDto originPlanet);

    PlanetExportDto getTeleportPlanet();

    void setTeleportPlanet(PlanetExportDto teleportPlanet);

    long getVictimsCount();

    void setVictimsCount(long victimsCount);
}
