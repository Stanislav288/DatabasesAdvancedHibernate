package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */

@Entity
@Table(name="planets")
public class Planet implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="sun_id")
    private Star sun;

    @ManyToOne
    @JoinColumn(name="solar_system_id")
    private SolarSystem solarSystem;

    @OneToMany(mappedBy = "originPlanet")
    private List<Anomaly> teleportFromPlanetAnomalies;

    @OneToMany(mappedBy = "teleportPlanet")
    private List<Anomaly> teleportToPlanetAnomalies;

    public Planet(){}

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

    public Star getSun() {
        return sun;
    }

    public void setSun(Star sun) {
        this.sun = sun;
    }

    public SolarSystem getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }

    public void setTeleportFromPlanetAnomalies(List<Anomaly> teleportFromPlanetAnomalies) {
        this.teleportFromPlanetAnomalies = teleportFromPlanetAnomalies;
    }

    public void setTeleportToPlanetAnomalies(List<Anomaly> teleportToPlanetAnomalies) {
        this.teleportToPlanetAnomalies = teleportToPlanetAnomalies;
    }
}
