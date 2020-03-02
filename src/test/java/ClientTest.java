import net.susinmn.Client;
import org.junit.Test;
import static junit.framework.Assert.*;
/**
 * Created by Home on 02.03.2020.
 */

public class ClientTest {

    @Test
    public void getAnnuityPaymentTest() {
        Client client = new Client();
        client.setMonths(36);
        client.setRate(0.2f);
        client.setAmount(1000000.0f);
        client.calculateAnnuityPayment();

        assertEquals("getAnnuityPayment must be 37163.61", 37163.61f, client.getAnnuityPayment());
    }

    @Test
    public void getDifferentiatedPaymentTest() {
        Client client = new Client();
        client.setMonths(6);
        client.setRate(0.2f);
        client.setAmount(300000.0f);
        client.calculateDifferentiatedPayment();

        assertEquals("getDifferentiatedPayment must be 5081.97", 5081.97f, client.getDifferentiatedPayment());
    }
}
