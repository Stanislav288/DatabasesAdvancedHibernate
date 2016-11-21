package app.domain.dto.XML.importDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ASUS on 11/19/2016.
 */

@XmlRootElement(name="victim")
@XmlAccessorType(XmlAccessType.FIELD)
public class VictimImportDto {

    @XmlAttribute(name="name")
    private String name;

    public VictimImportDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
