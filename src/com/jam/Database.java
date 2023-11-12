package com.jam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Database {
    private static final Map<Integer, Employee> employees = new HashMap<>();

    private static Database instance = null;

    private Database() {
        System.out.println("Connecting to database...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Error: Database connection interrupted!");
            return;
        }
        System.out.println("Connected to database!");
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public static void addEmployee(Employee employee) {
        if (employees.containsKey(employee.hashCode())) {
            System.err.println("Error: Employee already exists!");
            return;
        }
        employees.put(employee.hashCode(), employee);
    }

    public static void removeEmployee(Employee employee) {
        employees.remove(employee.hashCode());
    }

    public static Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public void printEmployees() {
        if (Objects.isNull(instance)) {
            System.err.println("Error: Database not connected!");
            return;
        }
        System.out.println("Employees:");
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    public void close() {
        System.out.println("Closing database...");
        Database.instance = null;
    }
}
