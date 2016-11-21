package app.domain.dto.XML.importDto;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */
@XmlRootElement(name="anomaly")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnomalyWithVictimImportDto implements Serializable {

    @XmlAttribute(name="origin-planet",required =true)
    private String originPlanet;

    @XmlAttribute(name="teleport-planet",required =true)
    private String teleportPlanet;

    @XmlElementWrapper(name="victims")
    @XmlElement(name="victim")
    private List<VictimImportDto> victims;

    public AnomalyWithVictimImportDto(){}

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

    public List<VictimImportDto> getVictims() {
        return victims;
    }

    public void setVictims(List<VictimImportDto> victims) {
        this.victims = victims;
    }
}
