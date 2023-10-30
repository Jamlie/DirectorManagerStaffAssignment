package com.jam.internal;

import com.jam.*;

import java.util.List;

public final class StaffReporterFactory {
    private static IStaffReport staffReport;

    private StaffReporterFactory() {}

    public static List<Staff> getStaffList(Employee employee) {
        assign(employee);
        return staffReport.getStaff();
    }

    private static void assign(Employee employee) {
        if (EmployeeChecker.isManager(employee)) {
            staffReport = EmployeeCaster.cast(employee, Manager.class);
        } else if (EmployeeChecker.isDirector(employee)) {
            staffReport = EmployeeCaster.cast(employee, Director.class);
        }
    }
}
