package app.domain.dto.JSON.importDto;

import java.io.Serializable;

/**
 * Created by ASUS on 11/19/2016.
 */
public class StarImportDto implements Serializable {

    private String name;

    private String solarSystem;

    public StarImportDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(String solarSystem) {
        this.solarSystem = solarSystem;
    }
}
