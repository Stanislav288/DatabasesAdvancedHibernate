package app.parser;

import javax.xml.bind.JAXBException;

/**
 * Created by ASUS on 11/19/2016.
 */
public interface XMLParser {

    <T> T readFromXml(Class<T> classes,String fileName) throws JAXBException;

    <T> void writeToXml(T object,String fileName) throws JAXBException;
}
