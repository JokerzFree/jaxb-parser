package com.jokerz.maven.jaxb.parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Andrew on 25.12.2016.
 */
public class JaxbParser {
    /**
     * Deserialize information from XML file to object
     *
     * @param filename which should be deserialize
     * @param c        by which class attributes
     * @return Object of some type
     */
    public Object getObjectFromXml(String filename, Class c) {
        try {
            File file = new File(getClass().getResource(filename).getFile());
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(file);
        } catch (JAXBException jEx) {
            System.out.println(jEx.toString());
        }
        return null;
    }

    /**
     * Serialize information to XML file to object
     *
     * @param filename where should be serialize
     * @param o        which serialize to file
     */
    public void saveToXml(String filename, Object o) {
        try {
            File file = new File(getClass().getResource(filename).getFile());
            JAXBContext context = JAXBContext.newInstance(o.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(o, file);
        } catch (JAXBException jEx) {
            System.out.println(jEx.toString());
        }
    }
}
