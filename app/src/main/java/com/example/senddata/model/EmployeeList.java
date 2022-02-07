package com.example.senddata.model;

import java.util.ArrayList;

public class EmployeeList {
   public static ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();

    public static void addEmployees(Employee emp) {
        employeeArrayList.add(emp);
    }
    public static ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }
}
