package net.susinmn;

import net.susinmn.Exeptions.ObjectToXMLExeption;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

/**
 * Created by Home on 02.03.2020.
 */
public class ObjectToBaos {
    public ByteArrayOutputStream getBaosFromClient(Client client) throws ObjectToXMLExeption {
        try {
            JAXBContext context = JAXBContext.newInstance(Client.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            marshaller.marshal(client, baos);

            return baos;
        } catch (JAXBException ex) {
            System.out.println(ex);
            throw new ObjectToXMLExeption("");
        }
    }
}
