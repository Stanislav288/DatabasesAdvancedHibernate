package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */

@Entity
@Table(name="persons")
public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="home_planet_id")
    private Planet homePlanet;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "victims")
    private List<Anomaly> anomalies;

    public Person(){
        this.setAnomalies(new ArrayList<>());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Planet getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(Planet homePlanet) {
        this.homePlanet = homePlanet;
    }

    public List<Anomaly> getAnomalies() {
        return anomalies;
    }

    public void setAnomalies(List<Anomaly> anomalies) {
        this.anomalies = anomalies;
    }
}
