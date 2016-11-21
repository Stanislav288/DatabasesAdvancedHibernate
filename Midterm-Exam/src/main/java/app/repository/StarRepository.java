package app.repository;

import app.domain.models.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 11/19/2016.
 */
@Repository
public interface StarRepository extends JpaRepository<Star,Long> {

    Star findStarByName(String name);
}
