package com.jam;

import com.jam.internal.IStaffReport;

import java.util.ArrayList;
import java.util.List;

public non-sealed class Manager extends Employee implements Reportable, IStaffReport {
    private List<Staff> staff;

    public Manager(int id, String name, int age, double hourlyRate, int completedHours) {
        super(id, name, age, hourlyRate, completedHours);
        staff = new ArrayList<>();
        Database.addEmployee(this);
    }

    public Manager(EmployeeModel employeeModel) {
        super(employeeModel);
        staff = new ArrayList<>();
        Database.addEmployee(this);
    }

    public void addStaff(Staff staff) {
        this.staff.add(staff);
    }

    public void removeStaff(Staff staff) {
        this.staff.remove(staff);
        Database.removeEmployee(staff);
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();

        sb.append("{\n")
                .append("\tid: ")
                .append(this.getId())
                .append(",\n")
                .append("\tname: ")
                .append(this.getName())
                .append(",\n")
                .append("\tage: ")
                .append(this.getAge())
                .append(",\n")
                .append("\thourlyRate: ")
                .append(this.getHourlyRate())
                .append(",\n")
                .append("\tcompletedHours: ")
                .append(this.getCompletedHours())
                .append(",\n");
        return getStaffAsString(sb);
    }

    private String getStaffAsString(StringBuilder sb) {
        sb.append("\tstaff: ");
        sb.append(this.staff);
        sb.append("\n");
        sb.append("}\n");

        return sb.toString();
    }
}
