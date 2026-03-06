package mod2;

import java.util.List;

public  class Employee {
    private String name;
    private String department;
    private boolean isFullTime;
    private String email;
    private Double salary;
    List<String> phones;

    public Employee() {
    }

    public Employee(String name, String department, boolean isFullTime, String email, Double salary, List<String> phones) {
        this.name = name;
        this.department = department;
        this.isFullTime = isFullTime;
        this.salary = salary;
        this.email = email;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", isFullTime=" + isFullTime +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", phones=" + phones +
                '}';
    }
}
