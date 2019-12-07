package humanresources;

public interface GroupsManager {
    void add(EmployeeGroup employeeGroup);

    int getCount();

    int removeCounted(EmployeeGroup employeeGroup);

    boolean remove(String name);

    EmployeeGroup getGroup(String name);

    EmployeeGroup[] toArray();

    int getEmployeesCount();

    int getEmployeesCountByJobTitle(JobTitlesEnum jobTitle);

    Employee maxSalary();

    EmployeeGroup getEmployeeGroup(String name, String surname);
}
