package net.susinmn;

/**
 * Created by Home on 11.03.2020.
 */
interface PaymentScheduleCalculationService {
    PaymentSchedule calculate(CreditDetail creditDetail);
}
public class PaymentScheduleCalculation implements PaymentScheduleCalculationService {
    public PaymentSchedule calculate(CreditDetail creditDetail) {

        return new PaymentSchedule();
    }
}
