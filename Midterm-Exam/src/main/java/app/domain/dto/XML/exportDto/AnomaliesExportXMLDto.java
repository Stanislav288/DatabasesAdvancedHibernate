package app.domain.dto.XML.exportDto;

import app.domain.dto.JSON.exportDto.AnomalyExportDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 11/21/2016.
 */
@XmlRootElement(name="anomalies")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnomaliesExportXMLDto {

    @XmlElement(name="anomaly")
    private List<AnomalyExportXMLDto> anomalyExportDtos;

    public AnomaliesExportXMLDto(){
        this.setAnomalyExportDtos(new ArrayList<>());
    }

    public List<AnomalyExportXMLDto> getAnomalyExportDtos() {
        return anomalyExportDtos;
    }

    public void setAnomalyExportDtos(List<AnomalyExportXMLDto> anomalyExportDtos) {
        this.anomalyExportDtos = anomalyExportDtos;
    }
}
