package app.domain.dto.XML.exportDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ASUS on 11/21/2016.
 */
@XmlRootElement(name="victim")
@XmlAccessorType(XmlAccessType.FIELD)
public class VictimExportXMLDto {

    @XmlAttribute(name="name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
