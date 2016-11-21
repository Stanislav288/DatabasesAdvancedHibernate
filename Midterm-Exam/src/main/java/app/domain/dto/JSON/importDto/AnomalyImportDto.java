package app.domain.dto.JSON.importDto;

import java.io.Serializable;

/**
 * Created by ASUS on 11/19/2016.
 */
public class AnomalyImportDto implements Serializable {

    private String originPlanet;

    private String teleportPlanet;

    public AnomalyImportDto() {
    }

    public String getOriginPlanet() {
        return originPlanet;
    }

    public void setOriginPlanet(String originPlanet) {
        this.originPlanet = originPlanet;
    }

    public String getTeleportPlanet() {
        return teleportPlanet;
    }

    public void setTeleportPlanet(String teleportPlanet) {
        this.teleportPlanet = teleportPlanet;
    }
}
