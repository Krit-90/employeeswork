package humanresources;

public interface EmployeeGroup {
    String getName();

    void setName(String name);

    Employee getEmployee(String name, String surname);

    void remove(String name, String surname);

    void remove(Employee employee);

    Employee maxSalary();

    int getCount();

    Employee[] getEmployees();

    Employee[] getSortedEmployeesBySalary();
}
