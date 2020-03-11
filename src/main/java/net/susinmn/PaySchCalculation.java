package net.susinmn;

import net.susinmn.Exeptions.ObjectToXMLExeption;
import net.susinmn.Exeptions.XMLToObjectExeption;
import net.susinmn.Exeptions.PaySchCalculationExeption;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by Home on 29.02.2020.
 */
public class PaySchCalculation {
    public static void main(String[] args) {
        /*NOP*/
    }

    public OutputStream getPaymentsScheduleData(InputStream is) throws PaySchCalculationExeption {
        try {
            CreditDetail creditDetail = new CreditDetailDataReader().read(is);

            PaymentScheduleCalculationService paymentScheduleCalculation = new PaymentScheduleCalculation();
            PaymentSchedule paymentSchedule = paymentScheduleCalculation.calculate(creditDetail);

            PaymentsScheduleWriter paymentsScheduleDataWriter = new PaymentsScheduleDataWriter();
            OutputStream os = new ByteArrayOutputStream();

            paymentsScheduleDataWriter.write(paymentSchedule, os);
            return os;
        } catch (XMLToObjectExeption ex) {
            throw new PaySchCalculationExeption(Messages.XML_To_Object_Exeption.getMessage());
        } catch (ObjectToXMLExeption ex) {
            throw new PaySchCalculationExeption(Messages.Object_To_XML_Exeption.getMessage());
        }
    }

    enum Messages {
        Object_To_XML_Exeption("Error converting Object to XML"),
        XML_To_Object_Exeption("Error converting XML to Object");

        private String message;

        Messages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
