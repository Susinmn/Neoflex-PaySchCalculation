package net.susinmn;

import net.susinmn.Exeptions.XMLToObjectExeption;

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Created by Home on 29.02.2020.
 */

interface CreditDetailReader {
    CreditDetail read(InputStream is) throws XMLToObjectExeption;
}

public class CreditDetailDataReader implements CreditDetailReader {
    public CreditDetail read(InputStream is) throws XMLToObjectExeption{
        try {
            JAXBContext context = JAXBContext.newInstance(CreditDetail.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            CreditDetail creditDetail = (CreditDetail)unmarshaller.unmarshal(is);

            return creditDetail;
        } catch (JAXBException ex) {
            throw new XMLToObjectExeption(ex.getMessage());
        }
    }
}
