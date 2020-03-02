package net.susinmn;

import net.susinmn.Exeptions.XMLToObjectExeption;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Created by Home on 29.02.2020.
 */
public class BaisToObject {
    public Client getClientFromBais(ByteArrayInputStream bais) throws XMLToObjectExeption {
        try {
            JAXBContext context = JAXBContext.newInstance(Client.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            Client client = (Client)unmarshaller.unmarshal(bais);

            return client;
        } catch (JAXBException ex) {
            throw new XMLToObjectExeption("");
        }
    }
}
