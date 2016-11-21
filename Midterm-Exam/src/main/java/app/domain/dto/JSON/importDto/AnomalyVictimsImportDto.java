package app.domain.dto.JSON.importDto;

import java.io.Serializable;

/**
 * Created by ASUS on 11/19/2016.
 */
public class AnomalyVictimsImportDto implements Serializable {

    private Long id;

    private String person;

    public AnomalyVictimsImportDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
