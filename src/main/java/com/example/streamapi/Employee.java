package com.example.streamapi;

import java.util.List;

public class Employee {

    private String firstName;
    private String lastName;
    private Double salary;
    private List<String> project;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Double salary, List<String> project) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.project = project;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", project=" + project +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<String> getProject() {
        return project;
    }

    public void setProject(List<String> project) {
        this.project = project;
    }
}
