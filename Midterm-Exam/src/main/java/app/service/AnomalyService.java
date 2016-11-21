package app.service;

import app.domain.dto.JSON.exportDto.AnomalyDto;
import app.domain.models.Anomaly;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */
public interface AnomalyService {

    List<Anomaly> findAnomalies();

    Anomaly findAnomaly(long id);

    void save(Anomaly anomaly);

    void importAnomaliesFromJSON();

    void importAnomaliesVictimsFromJSON();

    void importAnomaliesFromXML() throws JAXBException;

    Object findAnomalyWithMostAffectedPeople();

    void anomalyWithMostAffectedPeopleToJSON();

    void exportAllAnomaliesToXML() throws JAXBException;
}
