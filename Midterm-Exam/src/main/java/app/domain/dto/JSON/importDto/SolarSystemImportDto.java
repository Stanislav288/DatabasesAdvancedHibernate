package app.domain.dto.JSON.importDto;

import java.io.Serializable;

/**
 * Created by ASUS on 11/19/2016.
 */
public class SolarSystemImportDto implements Serializable {

    private String name;

    public SolarSystemImportDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
