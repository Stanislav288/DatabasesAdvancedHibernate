package app.domain.dto.JSON.importDto;

import java.io.Serializable;

/**
 * Created by ASUS on 11/19/2016.
 */
public class PersonImportDto implements Serializable {

    private String name;

    private String homePlanet;

    public PersonImportDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    }
}
