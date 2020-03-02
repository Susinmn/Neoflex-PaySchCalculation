package net.susinmn;

import net.susinmn.Exeptions.ObjectToXMLExeption;
import net.susinmn.Exeptions.XMLToObjectExeption;
import net.susinmn.Exeptions.PaySchCalculationExeption;

import java.io.*;

/**
 * Created by Home on 29.02.2020.
 */
public class PaySchCalculation {
    public static void main(String[] args) {
        /*NOP*/
    }

    public ByteArrayOutputStream getAnnuityPayment(ByteArrayInputStream bais) throws PaySchCalculationExeption {
        try {
            Client client = new BaisToObject().getClientFromBais(bais);
            client.calculateAnnuityPayment();
            return new ObjectToBaos().getBaosFromClient(client);
        } catch (XMLToObjectExeption ex) {
            throw new PaySchCalculationExeption(Messages.XML_To_Object_Exeption.getMessage());
        } catch (ObjectToXMLExeption ex) {
            throw new PaySchCalculationExeption(Messages.Object_To_XML_Exeption.getMessage());
        }
    }

    public ByteArrayOutputStream getDifferentiatedPayment(ByteArrayInputStream bais) throws PaySchCalculationExeption {
        try {
            Client client = new BaisToObject().getClientFromBais(bais);
            client.calculateDifferentiatedPayment();
            return new ObjectToBaos().getBaosFromClient(client);
        } catch (XMLToObjectExeption ex) {
            throw new PaySchCalculationExeption(Messages.XML_To_Object_Exeption.getMessage());
        } catch (ObjectToXMLExeption ex) {
            throw new PaySchCalculationExeption(Messages.Object_To_XML_Exeption.getMessage());
        }
    }

    enum Messages {
        Object_To_XML_Exeption("Ошибка преобразования объекта в xml"),
        XML_To_Object_Exeption("Ошибка преобразования xml в объект");

        private String message;

        Messages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
