import net.susinmn.Exeptions.PaySchCalculationExeption;
import net.susinmn.PaySchCalculation;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.*;
/**
 * Created by Home on 02.03.2020.
 */
public class PaySchCalculationTest {

    @Test
    public void getAnnuityPaymentTest() {
        InputStream isIn = null;
        ByteArrayOutputStream baosIn = null;
        ByteArrayInputStream baisIn = null;

        InputStream isOut = null;
        ByteArrayOutputStream baosOut = null;
        try {
            File fileIn = new File("D:/Neoflex/Client.xml");
            isIn = new FileInputStream(fileIn);

            byte[] buff = new byte[64 * 1021];
            int bytesRead = 0;

            baosIn = new ByteArrayOutputStream();

            while ((bytesRead = isIn.read(buff)) != -1) {
                baosIn.write(buff, 0, bytesRead);
            }

            baisIn = new ByteArrayInputStream(baosIn.toByteArray());


            /*получаем подготовленный ответ*/
            File fileOut = new File("D:/Neoflex/ClientWithAnnuityPayment.xml");
            isOut = new FileInputStream(fileOut);

            buff = new byte[64 * 1021];
            bytesRead = 0;

            baosOut = new ByteArrayOutputStream();

            while ((bytesRead = isOut.read(buff)) != -1) {
                baosOut.write(buff, 0, bytesRead);
            }
            try {
                baosIn = new PaySchCalculation().getAnnuityPayment(baisIn);

                assertEquals("PaySchCalculation.getAnnuityPayment() to xml must be: \n" + baosIn, baosOut, baosIn);
            } catch (PaySchCalculationExeption ex) {
                //System.out.println(ex.getStackTrace());
                System.out.println(ex.getMessage());
            }


        } catch (FileNotFoundException ex) {
            /*NOP*/
        } catch (IOException ex) {
            /*NOP*/
        } finally {
            StreamClose(isIn);
            StreamFlushAndClose(baosIn);
            StreamClose(baisIn);

            StreamClose(isOut);
            StreamFlushAndClose(baosOut);
        }
    }

    private void StreamClose(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException ex) {
            /*NOP*/
            }
        }
    }

    private void StreamFlushAndClose(OutputStream os) {
        if (os != null) {
            try {
                os.flush();
                os.close();
            } catch (IOException ex) {
            /*NOP*/
            }
        }
    }
}
