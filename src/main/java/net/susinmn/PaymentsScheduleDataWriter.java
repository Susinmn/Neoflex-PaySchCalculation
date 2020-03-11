package net.susinmn;

import net.susinmn.Exeptions.ObjectToXMLExeption;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 * Created by Home on 02.03.2020.
 */
interface PaymentsScheduleWriter {
    void write(PaymentSchedule paymentSchedule, OutputStream os) throws ObjectToXMLExeption;
}

public class PaymentsScheduleDataWriter implements PaymentsScheduleWriter {
    public void write(PaymentSchedule paymentSchedule, OutputStream os) throws ObjectToXMLExeption {
        try {
            JAXBContext context = JAXBContext.newInstance(PaymentSchedule.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(paymentSchedule, os);
        } catch (JAXBException ex) {
            throw new ObjectToXMLExeption(ex.getMessage());
        }
    }
}
