package com.jam;

import com.jam.internal.EmployeeCaster;

import java.util.Objects;

public class BudgetReporter<T extends Reportable> implements IReport {
    private Employee employee;

    public BudgetReporter(Reportable employee) {
        this.employee = (Employee) employee;
    }

    @Override
    public void generateReport() {
        System.out.println("Budget Report");
        System.out.println(employee.toString());
        System.out.println("Budget: " + calculateBudget(employee));
        System.out.println("============");
        System.out.println("Budget Report End");
    }

    private double calculateBudget(Employee employee) {
        double budget = employee.calculateSalary();
        Manager manager = EmployeeCaster.cast(employee, Manager.class);

        if (Objects.nonNull(manager)) {
            return calculateManagerBudget(manager, budget);
        }

        Director director = EmployeeCaster.cast(employee, Director.class);
        if (Objects.nonNull(director)) {
            return calculateDirectorBudget(director, budget);
        }

        return budget;
    }

    private double calculateManagerBudget(Manager manager, double budget) {
        for (Staff staff : manager.getStaff()) {
            budget += staff.calculateSalary();
        }

        return budget;
    }

    private double calculateDirectorBudget(Director director, double budget) {
        for (Manager innerManager : director.getManagers()) {
            budget += innerManager.calculateSalary();
        }

        for (Staff staff : director.getStaff()) {
            budget += staff.calculateSalary();
        }

        return budget;
    }
}
