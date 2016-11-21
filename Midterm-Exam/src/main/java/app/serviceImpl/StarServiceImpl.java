package app.serviceImpl;

import app.domain.dto.JSON.importDto.StarImportDto;
import app.domain.models.SolarSystem;
import app.domain.models.Star;
import app.parser.JSONParserImpl;
import app.repository.StarRepository;
import app.service.SolarSystemService;
import app.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */
@Service
public class StarServiceImpl implements StarService{

    @Autowired
    private StarRepository starRepository;

    @Autowired
    private JSONParserImpl jsonParser;

    @Autowired
    private SolarSystemService solarSystemService;

    @Override
    public List<Star> findStars() {
        return this.starRepository.findAll();
    }

    @Override
    public Star findStar(long id) {
        return this.starRepository.findOne(id);
    }

    @Override
    public void save(Star star) {
        this.starRepository.saveAndFlush(star);
    }

    @Override
    public void importStarFromJSON() {
        String path="src/main/resources/files/input/json/stars.json";
        StarImportDto[] starImportDtos=new StarImportDto[]{};
        starImportDtos=this.jsonParser.readFromJSON(StarImportDto[].class,path);

        for (StarImportDto starImportDto:starImportDtos) {
            if(starImportDto.getName().toString().isEmpty() || starImportDto.getName()==null ){
                System.out.println("Error: Invalid data.");
                continue;
            }

            SolarSystem solarSystem=solarSystemService.findSolarSystemByName(starImportDto.getSolarSystem());
            if(solarSystem==null){
                System.out.println("Error: Invalid data.");
                continue;
            }

            Star star=new Star();
            star.setName(starImportDto.getName());
            star.setSolarSystem(solarSystem);

            System.out.printf("Successfully imported %s %s.\n","Star",star.getName());

            this.save(star);
        }
    }

    @Override
    public Star findStarByName(String name) {
        return this.starRepository.findStarByName(name);
    }
}
