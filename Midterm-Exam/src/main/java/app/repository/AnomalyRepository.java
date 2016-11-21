package app.repository;

import app.domain.models.Anomaly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 11/19/2016.
 */

@Repository
public interface AnomalyRepository extends JpaRepository<Anomaly, Long> {

    @Query("SELECT a,COUNT(a.id) " +
            "FROM Anomaly AS a " +
            "INNER JOIN a.victims AS av " +
            "GROUP BY a.id " +
            "HAVING COUNT(a.id)=(SELECT MAX(a2.victims.size) FROM Anomaly AS a2)")
    Object findAnomalyWithMostAffectedPeople();
}
