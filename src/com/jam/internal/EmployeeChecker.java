package com.jam.internal;

import com.jam.Director;
import com.jam.Employee;
import com.jam.Manager;
import com.jam.Staff;

public final class EmployeeChecker {
    private EmployeeChecker() {}

    public static boolean isManager(Employee employee) {
        return employee instanceof Manager;
    }

    public static boolean isDirector(Employee employee) {
        return employee instanceof Director;
    }

    public static boolean isStaff(Employee employee) {
        return employee instanceof Staff;
    }
}
