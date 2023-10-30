package com.jam;

import java.util.Objects;

public abstract sealed class Employee permits Director, Manager, Staff {
    private int id;
    private String name;
    private int age;
    private double hourlyRate;
    private int completedHours;

    protected Employee(int id, String name, int age, double hourlyRate, int completedHours) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hourlyRate = hourlyRate;
        this.completedHours = completedHours;
    }

    protected Employee(EmployeeModel employeeModel) {
        this.id = employeeModel.id();
        this.name = employeeModel.name();
        this.age = employeeModel.age();
        this.hourlyRate = employeeModel.hourlyRate();
        this.completedHours = employeeModel.completedHours();
    }

    public EmployeeModel toModel() {
        return new EmployeeModel(id, name, age, hourlyRate, completedHours);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getCompletedHours() {
        return completedHours;
    }

    public void setCompletedHours(int completedHours) {
        this.completedHours = completedHours;
    }

    public double calculateSalary() {
        return hourlyRate * completedHours;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\tid: " + this.getId() + ",\n" +
                "\tname: " + this.getName() + ",\n" +
                "\tage: " + this.getAge() + ",\n" +
                "\thourlyRate: " + this.getHourlyRate() + ",\n" +
                "\tcompletedHours: " + this.getCompletedHours() +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && Double.compare(hourlyRate, employee.hourlyRate) == 0 && completedHours == employee.completedHours && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, hourlyRate, completedHours);
    }
}
