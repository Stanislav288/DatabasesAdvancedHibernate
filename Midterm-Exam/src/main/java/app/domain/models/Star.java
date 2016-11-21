package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ASUS on 11/19/2016.
 */

@Entity
@Table(name="stars")
public class Star implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="solar_system_id")
    private SolarSystem solarSystem;

    public Star(){}

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

    public SolarSystem getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }
}
