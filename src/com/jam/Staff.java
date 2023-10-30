package com.jam;

public non-sealed class Staff extends Employee {
    public Staff(int id, String name, int age, double hourlyRate, int completedHours) {
        super(id, name, age, hourlyRate, completedHours);
        Database.addEmployee(this);
    }

    public Staff(EmployeeModel employeeModel) {
        super(employeeModel);
        Database.addEmployee(this);
    }
}
