package edu.miu.cs489.lab1b.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private BigDecimal yearlySalary;
    private PensionPlan pensionPlan;

    // Constructor, getters, and setters
    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, BigDecimal yearlySalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public BigDecimal getYearlySalary() {
        return yearlySalary;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public boolean isEligibleForPension(LocalDate checkDate) {
        return employmentDate.plusYears(5).isBefore(checkDate) && pensionPlan == null;
    }
}