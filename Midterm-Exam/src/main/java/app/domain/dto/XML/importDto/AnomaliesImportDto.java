package app.domain.dto.XML.importDto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */

@XmlRootElement(name="anomalies")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnomaliesImportDto implements Serializable {

    @XmlElement(name="anomaly")
    private List<AnomalyWithVictimImportDto> anomalies;

    public List<AnomalyWithVictimImportDto> getAnomalies() {
        return anomalies;
    }

    public void setAnomalies(List<AnomalyWithVictimImportDto> anomalies) {
        this.anomalies = anomalies;
    }
}
