package net.susinmn;

import java.math.BigDecimal;
import java.util.Calendar;
import java.lang.Math;
import java.math.RoundingMode;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * Created by Home on 29.02.2020.
 */
@XmlType(name = "creditdetail")
@XmlRootElement
public class CreditDetail {
    //@XmlElement(name = "term")
    private int term;
    //@XmlElement(name = "rate")
    private BigDecimal rate;
    //@XmlElement(name = "amount")
    private BigDecimal amount;
    //@XmlElement(name = "paymenttype")
    private String paymenttype;

    public void setTerm(int term) { this.term = term; }

    public int getTerm() { return this.term; }

    public void setRate(BigDecimal rate) { this.rate = rate; }

    public BigDecimal getRate() { return this.rate; }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() { return this.amount; }

    public void setPaymenttype(String paymenttype) { this.paymenttype = paymenttype; }

    public String getPaymenttype() { return this.paymenttype; }

/*
    public void calculateAnnuityPayment() {
        BigDecimal monthRate = this.rate / 12;
        float annuityRatio = monthRate * (float) Math.pow(1 + monthRate, 36) / ((float) Math.pow(1 + monthRate, 36) - 1);

        this.annuityPayment = round(annuityRatio * this.amount, 2);
    }

    public void calculateDifferentiatedPayment() {
        int yearDays = getYearDays();
        int monthDays = getMonthDays();

        this.differentiatedPayment = round(this.amount * this.rate * monthDays / yearDays, 2);
    }
    */

    private int getYearDays() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return ((year % 4 != 0) | (year % 100 == 0) & (year % 400 != 0)) ? 365 : 366;
    }

    private int getMonthDays() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /*
    private static float round(float value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.CEILING);
        return (float)bd.doubleValue();
    }
    */
}
