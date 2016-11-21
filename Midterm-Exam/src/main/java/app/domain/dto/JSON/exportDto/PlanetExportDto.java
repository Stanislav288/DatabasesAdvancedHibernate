package app.domain.dto.JSON.exportDto;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by ASUS on 11/20/2016.
 */

public class PlanetExportDto implements Serializable,PlanetDto{

    @Expose
    private String name;

    public PlanetExportDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
