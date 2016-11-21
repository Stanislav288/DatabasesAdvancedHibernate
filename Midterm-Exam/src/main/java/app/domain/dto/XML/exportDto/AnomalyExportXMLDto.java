package app.domain.dto.XML.exportDto;

import app.domain.dto.XML.importDto.VictimImportDto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 11/21/2016.
 */
@XmlRootElement(name="anomaly")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnomalyExportXMLDto {

    @XmlAttribute(name="id",required =true)
    private long id;

    @XmlAttribute(name="origin-planet",required =true)
    private String originPlanet;

    @XmlAttribute(name="teleport-planet",required =true)
    private String teleportPlanet;

    @XmlElementWrapper(name="victims")
    @XmlElement(name="victim")
    private List<VictimExportXMLDto> victims;

    public AnomalyExportXMLDto(){
        this.setVictims(new ArrayList<>());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<VictimExportXMLDto> getVictims() {
        return victims;
    }

    public void setVictims(List<VictimExportXMLDto> victims) {
        this.victims = victims;
    }
}
