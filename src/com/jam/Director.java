package com.jam;

import com.jam.internal.IStaffReport;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public non-sealed class Director extends Employee implements Reportable, IStaffReport {
    private List<Manager> managers;
    private List<Staff> staff;
    public Director(int id, String name, int age, double hourlyRate, int completedHours) {
        super(id, name, age, hourlyRate, completedHours);
        managers = new ArrayList<>();
        staff = new ArrayList<>();
    }

    public Director(EmployeeModel employeeModel) {
        super(employeeModel);
        managers = new ArrayList<>();
        staff = new ArrayList<>();
        Database.addEmployee(this);
    }

    public void addManager(Manager manager) {
        managers.add(manager);
        staff.addAll(manager.getStaff());
    }

    public void removeManager(Manager manager) {
        managers.remove(manager);
        staff.removeAll(manager.getStaff());
        Database.removeEmployee(manager);
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    public void addStaff(Staff staff) {
        this.staff.add(staff);
        Database.addEmployee(staff);
    }

    public void removeStaff(Staff staff) {
        this.staff.remove(staff);
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{\n");
        sb.append("\tid: ");
        sb.append(this.getId());
        sb.append(",\n");
        sb.append("\tname: ");
        sb.append(this.getName());
        sb.append(",\n");
        sb.append("\tage: ");
        sb.append(this.getAge());
        sb.append(",\n");
        sb.append("\thourlyRate: ");
        sb.append(this.getHourlyRate());
        sb.append(",\n");
        sb.append("\tcompletedHours: ");
        sb.append(this.getCompletedHours());
        sb.append(",\n");
        sb.append("\tmanagers: ");
        sb.append(this.managers.toString());
        sb.append("\n");
        sb.append("\tstaff: ");
        sb.append(staff.toString());
        sb.append("}\n");
        return sb.toString();
    }
}
