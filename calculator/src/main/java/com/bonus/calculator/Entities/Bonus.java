package com.bonus.calculator.Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bonus {

    private String empName;
    private long amount;
    private String currency;
    private String joiningDate;
    private String exitDate;

    public Bonus() {
    }


    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getJoiningDate() throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
            Date date =  sdf.parse(joiningDate);
            return date;
    }

    //I have considered that there might be some case in which we don't have exit date of employee
    public Date getExitDate() throws ParseException {
        if(exitDate!=null && !exitDate.isEmpty()){
            SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
            Date date =  sdf.parse(exitDate);
            return date;
        }
        return new Date();
    }

    public boolean validBonus() throws ParseException {
        Date date = new Date();
        if(joiningDate==null || joiningDate.isEmpty()){
            return false;
        }
        return !(getExitDate().compareTo(date) < 0 || getJoiningDate().compareTo(date) > 0);
    }

    @Override
    public String toString() {
        return "Bonus{" +
                "empName=" + empName +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", joiningDate='" + joiningDate + '\'' +
                ", exitDate='" + exitDate + '\'' +
                '}';
    }


}
