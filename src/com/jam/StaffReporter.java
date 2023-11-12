package com.jam;

import com.jam.internal.EmployeeCaster;
import com.jam.internal.EmployeeChecker;
import com.jam.internal.StaffReporterFactory;

public class StaffReporter<T extends Reportable> implements IReport {
    private Employee employee;

    public StaffReporter(Reportable employee) {
        this.employee = (Employee) employee;
    }

    @Override
    public void generateReport() {
        System.out.println("Staff Report");
        printEmployee(employee);
        System.out.print("Staff List: ");
        System.out.println(StaffReporterFactory.getStaffList(employee));
        if (EmployeeChecker.isDirector(employee)) {
            System.out.print("Manager List: ");
            System.out.println(EmployeeCaster.cast(employee, Director.class).getManagers());
        }
        System.out.println("============");
        System.out.println("Staff Report End");
    }

    private static void printEmployee(Employee employee) {
        System.out.println("============");
        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Hourly Rate: " + employee.getHourlyRate());
        System.out.println("Completed Hours: " + employee.getCompletedHours());
        System.out.println("Total Salary: " + employee.calculateSalary());
        System.out.println("============");
    }
}
