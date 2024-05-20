package org.example;

public class FindMaxSalaryWorker {
    private String name;
    private String  salary;

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FindMaxSalaryWorker{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
