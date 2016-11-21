package app.serviceImpl;

import app.domain.dto.JSON.importDto.SolarSystemImportDto;
import app.domain.models.SolarSystem;
import app.parser.JSONParserImpl;
import app.repository.SolarSystemRepository;
import app.service.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 11/19/2016.
 */
@Service
public class SolarSystemServiceImpl implements SolarSystemService{

    @Autowired
    private SolarSystemRepository solarSystemRepository;

    @Autowired
    private JSONParserImpl jsonParser;

    @Override
    public List<SolarSystem> findSolarSystems() {
        return this.solarSystemRepository.findAll();
    }

    @Override
    public SolarSystem findSolarSystem(long id) {
        return this.solarSystemRepository.findOne(id);
    }

    @Override
    public void save(SolarSystem solarSystem) {
        this.solarSystemRepository.saveAndFlush(solarSystem);
    }

    @Override
    public void importSolarSystemsFromJSON() {
        String path="src/main/resources/files/input/json/solar-systems.json";
        SolarSystemImportDto[] SolarSystemImportDtos=new SolarSystemImportDto[]{};
        SolarSystemImportDtos=this.jsonParser.readFromJSON(SolarSystemImportDto[].class,path);

        for (SolarSystemImportDto solarSystemImportDto:SolarSystemImportDtos) {
            if(solarSystemImportDto.getName().toString().isEmpty() || solarSystemImportDto.getName()==null ){
                System.out.println("Error: Invalid data.");
                continue;
            }

            SolarSystem solarSystem=new SolarSystem();
            solarSystem.setName(solarSystemImportDto.getName());

            System.out.printf("Successfully imported %s %s.\n","Solar System",solarSystem.getName());

            this.save(solarSystem);
        }
    }

    @Override
    public SolarSystem findSolarSystemByName(String name) {
        return this.solarSystemRepository.findSolarSystemByName(name);
    }
}
