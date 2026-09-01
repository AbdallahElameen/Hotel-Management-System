package app.entity.employee;

import app.control.HotelController;

public abstract class Employee {

    private int employeeId;
    private String name;
    private String role;
    private double salary;
    private String password;

    protected HotelController hotelController;

    public Employee(int employeeId, String name, double salary, String role) {
        this.employeeId = employeeId;
        this.name       = name;
        this.salary     = salary;
        this.role       = role;
        this.password   = "employee123";
    }

    // Each subclass spells out what its day-to-day work looks like.
    public abstract void performDuty();

    @Override
    public String toString() {
        return "Employee{"
                + "employeeId=" + employeeId
                + ", name='"    + name    + '\''
                + ", role='"    + role    + '\''
                + ", salary="   + salary
                + '}';
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    protected void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HotelController getHotelController() {
        return hotelController;
    }

    public void setHotelController(HotelController hotelController) {
        this.hotelController = hotelController;
    }
}
