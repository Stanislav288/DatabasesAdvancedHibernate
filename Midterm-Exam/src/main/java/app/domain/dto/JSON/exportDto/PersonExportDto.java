package app.domain.dto.JSON.exportDto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by ASUS on 11/20/2016.
 */
public class PersonExportDto implements Serializable{

    @Expose
    private String name;

    @Expose
    private PlanetExportDto homePlanet;

    public PersonExportDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlanetExportDto getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(PlanetExportDto homePlanet) {
        this.homePlanet = homePlanet;
    }
}
