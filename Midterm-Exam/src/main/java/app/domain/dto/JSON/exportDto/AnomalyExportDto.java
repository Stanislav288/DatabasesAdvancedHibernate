package app.domain.dto.JSON.exportDto;

import app.domain.models.Planet;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by ASUS on 11/20/2016.
 */
public class AnomalyExportDto implements Serializable,AnomalyDto{

    @Expose
    private long id;

    @Expose
    private PlanetExportDto originPlanet;

    @Expose
    private PlanetExportDto teleportPlanet;

    @Expose
    private long victimsCount;

    public AnomalyExportDto(){}

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public PlanetExportDto getOriginPlanet() {
        return originPlanet;
    }

    @Override
    public void setOriginPlanet(PlanetExportDto originPlanet) {
        this.originPlanet = originPlanet;
    }

    @Override
    public PlanetExportDto getTeleportPlanet() {
        return teleportPlanet;
    }

    @Override
    public void setTeleportPlanet(PlanetExportDto teleportPlanet) {
        this.teleportPlanet = teleportPlanet;
    }

    @Override
    public long getVictimsCount() {
        return victimsCount;
    }

    @Override
    public void setVictimsCount(long victimsCount) {
        this.victimsCount = victimsCount;
    }
}
