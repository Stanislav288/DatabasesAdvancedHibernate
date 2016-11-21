package app.parser;


import org.hibernate.validator.internal.util.privilegedactions.Unmarshal;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by ASUS on 11/19/2016.
 */
@Component
public class XMLParserImpl implements XMLParser {

    @Override
    public <T> T readFromXml(Class<T> classes, String fileName) throws JAXBException {
        JAXBContext jaxbContext=JAXBContext.newInstance(classes);
        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
        File file=new File(fileName);
        T objects=(T) unmarshaller.unmarshal(file);
        return objects;
    }

    @Override
    public <T> void writeToXml(T object, String fileName) throws JAXBException {
        JAXBContext jaxbContext=JAXBContext.newInstance(object.getClass());
        Marshaller jaxbMarshaller=jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        File file=new File(fileName);
        jaxbMarshaller.marshal(object,file);
    }
}
