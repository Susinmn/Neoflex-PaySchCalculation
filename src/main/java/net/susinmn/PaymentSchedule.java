package net.susinmn;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Home on 11.03.2020.
 */
@XmlType(name = "paymentschedule")
@XmlRootElement
public class PaymentSchedule {
    private List<Payment> payments;

    public void setPayments(List<Payment> payments) { this.payments = payments; }

    public List<Payment> getPayments() { return this.payments; }
}
