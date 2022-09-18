package com.bonus.calculator.Entities;

public class Employee {
    private String name;
    private long amount;

    public Employee(String name,long amount) {
        this.name = name;
        this.amount = amount;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
