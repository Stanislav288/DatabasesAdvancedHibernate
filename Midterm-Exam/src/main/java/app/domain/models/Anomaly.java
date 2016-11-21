package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */

@Entity
@Table(name="anomalies")
public class Anomaly implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @ManyToOne
    @JoinColumn(name="origin_planet_id")
    private Planet originPlanet;

    @ManyToOne
    @JoinColumn(name="teleport_planet_id")
    private Planet teleportPlanet;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "anomaly_victims",
            joinColumns = {@JoinColumn(name = "anomaly_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id",referencedColumnName = "id")})
    private List<Person> victims;

    public Anomaly(){
        this.setVictims(new ArrayList<>());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Planet getOriginPlanet() {
        return originPlanet;
    }

    public void setOriginPlanet(Planet originPlanet) {
        this.originPlanet = originPlanet;
    }

    public Planet getTeleportPlanet() {
        return teleportPlanet;
    }

    public void setTeleportPlanet(Planet teleportPlanet) {
        this.teleportPlanet = teleportPlanet;
    }

    public List<Person> getVictims() {
        return victims;
    }

    public void setVictims(List<Person> victims) {
        this.victims = victims;
    }
}
