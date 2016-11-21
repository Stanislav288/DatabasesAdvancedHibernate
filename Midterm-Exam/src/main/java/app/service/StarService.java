package app.service;

import app.domain.models.Star;

import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */
public interface StarService {

    List<Star> findStars();

    Star findStar(long id);

    void save(Star star);

    void importStarFromJSON();

    Star findStarByName(String name);
}
