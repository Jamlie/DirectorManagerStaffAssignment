package com.jam.internal;

import com.jam.Employee;

public final class EmployeeCaster {

    public static <T extends Employee> T cast(Employee employee, Class<T> c) {
        if (c.isInstance(employee)) {
            return c.cast(employee);
        }
        return null;
    }
}
