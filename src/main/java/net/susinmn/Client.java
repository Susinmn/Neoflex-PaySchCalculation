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
@XmlType(name = "client")
@XmlRootElement
public class Client{
    //@XmlElement(name = "months")
    private int months;
    //@XmlElement(name = "rate")
    private float rate;
    //@XmlElement(name = "amount")
    private float amount;
    //@XmlElement(name = "annuitypayment")
    private float annuityPayment;
    //@XmlElement(name = "differentiatedpayment")
    private float differentiatedPayment;

    public void setMonths(int months) { this.months = months; }

    public int getMonths() { return this.months; }

    public void setRate(float rate) { this.rate = rate; }

    public float getRate() { return this.rate; }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAmount() { return this.amount; }

    public void setAnnuityPayment(float annuityPayment) { /*NOP*/ }

    public float getAnnuityPayment() { return this.annuityPayment; }

    public void setDifferentiatedPayment(float differentiatedPayment) { /*NOP*/ }

    public float getDifferentiatedPayment() { return this.differentiatedPayment; }

    public void calculateAnnuityPayment() {
        float monthrRate = this.rate / 12;
        float annuityRatio = monthrRate * (float) Math.pow(1 + monthrRate, 36) / ((float) Math.pow(1 + monthrRate, 36) - 1);

        this.annuityPayment = round(annuityRatio * this.amount, 2);
    }

    public void calculateDifferentiatedPayment() {
        int yearDays = getYearDays();
        int monthDays = getMonthDays();

        this.differentiatedPayment = round(this.amount * this.rate * monthDays / yearDays, 2);
    }

    private int getYearDays() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return ((year % 4 != 0) | (year % 100 == 0) & (year % 400 != 0)) ? 365 : 366;
    }

    private int getMonthDays() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private static float round(float value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return (float)bd.doubleValue();
    }
}
