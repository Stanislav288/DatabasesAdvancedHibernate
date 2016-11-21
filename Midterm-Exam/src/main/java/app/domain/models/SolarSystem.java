package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ASUS on 11/19/2016.
 */

@Entity
@Table(name="solar_systems")
public class SolarSystem implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name",nullable = false)
    private String name;

    public SolarSystem(){}

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
}
