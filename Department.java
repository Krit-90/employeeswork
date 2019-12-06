package humanresources;

import java.util.Arrays;
import java.util.Objects;

public class Department implements EmployeeGroup {
    private static final int DEFAULT_COUNT = 0;
    private String name;
    private Employee[] employees;
    private int count;

    public Department(String name) {
        this.name = name;
        this.employees = new Employee[8];
        this.count = DEFAULT_COUNT;
    }

    public Department(String name, int countWorkers) {
        this.name = name;
        this.employees = new Employee[countWorkers];
        this.count = DEFAULT_COUNT;
    }

    public Department(String name, Employee[] employees) {
        this.name = name;
        this.employees = employees;
        this.count = employees.length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmployee(Employee emp) {
        if (ensureCapacity()) {
            employees[count++] = emp;
        } else {
            Employee[] temp = new Employee[employees.length * 2];
            System.arraycopy(employees, 0, temp, 0, count);
            employees = temp;
        }
    }

    private boolean ensureCapacity() {
        return count < employees.length;
    }

    public void remove(String name, String surname) {
        for (int i = 0; i < count; i++) {
            if (checkName(name, surname, employees[i])) {
                shift(i);
                count--;
            }
        }
    }

    private boolean checkName(String name, String surname, Employee employee) {
        return employee.getName().equals(name) && employee.getSurname().equals(surname);
    }

    private void shift(int i) {
        System.arraycopy(employees, i + 1, employees, i, count - i - 1);
        employees[count - 1] = null;
    }

    public boolean remove(String jobTitle) {
        JobTitlesEnum jobTitleEnumValue = JobTitlesEnum.valueOf(jobTitle);
        return remove(jobTitleEnumValue);
    }

    public boolean remove(JobTitlesEnum title) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getJobTitle() == title) {
                shift(i);
                count--;
                return true;
            }
        }
        return false;
    }

    public void remove(Employee employee) {
        for (int i = 0; i < count; i++) {
            if (employees[i].equals(employee)) {
                shift(i);
                count--;
            }
        }
    }

    public Employee getEmployee(String name, String surname) {
        for (int i = 0; i < count; i++) {
            if (checkName(name, surname, employees[i])) {
                return employees[i];
            }
        }
        return null;
    }

    public boolean hasEmployee(String name, String surname) {
        return getEmployee(name, surname) != null;
    }

    public int getCount() {
        return count;
    }

    public Employee[] getEmployees() {
        Employee[] array = new Employee[count];
        System.arraycopy(employees, 0, array, 0, count);
        return array;
    }

    public Employee[] getEmployeesByJobTitle(JobTitlesEnum jobTitle) {
        int countJobTitle = 0;
        Employee[] employeesByJobTitle = new Employee[count];
        for (int i = 0; i < count; i++) {
            if (jobTitle == employees[i].getJobTitle()) {
                employeesByJobTitle[countJobTitle++] = employees[i];
            }
        }
        Employee[] array = new Employee[countJobTitle];
        System.arraycopy(employeesByJobTitle, 0, array, 0, countJobTitle);
        return array;
    }

    public Employee[] getSortedEmployeesBySalary() { // По убыванию зарплаты
        Employee[] employees = getEmployees();
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length; j++) {
                if (employees[i].getSalary() >= employees[j].getSalary()) {
                    Employee x = employees[i];
                    employees[i] = employees[j];
                    employees[j] = x;
                }
            }
        }
        return employees;

    }

    public JobTitlesEnum[] jobTitlesArray() {

        JobTitlesEnum[] array = new JobTitlesEnum[14];
        boolean unique;

        for (int i = 0, k = 0; i < count; i++) {
            unique = contains(i);
            if (unique) {
                array[k++] = employees[i].getJobTitle();
            }
        }
        return array;
    }

    private boolean contains(int i) {
        for (int j = i + 1; j < count - 1; j++) {
            if (employees[i].getJobTitle() == employees[j].getJobTitle()) {
                return false;
            }
        }
        return true;
    }

    public Employee maxSalary() {
        Employee richMan = employees[0];
        for (int i = 1; i < count; i++) {
            if (employees[i].getSalary() > richMan.getSalary()) {
                richMan = employees[i];
            }
        }
        return richMan;
    }

    public Employee[] getBusinessTravelerArray() {
        int countStaffEmployee = 0;
        StaffEmployee[] temp = new StaffEmployee[count];
        for (int i = 0; i < count; i++) {
            if (employees[i] instanceof StaffEmployee) {
                if (((StaffEmployee) employees[i]).haveTravels()) {
                    temp[countStaffEmployee++] = (StaffEmployee) employees[i];
                }
            }
        }
        StaffEmployee[] businessTravellerArray = new StaffEmployee[countStaffEmployee];
        System.arraycopy(temp, 0, businessTravellerArray, 0, countStaffEmployee);
        return businessTravellerArray;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("name='").append(name).append('\'').append(", count=").append(getCount());
        for (Employee emp : employees) {
            buffer.append("<").append(emp).append(">");
        }
        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Department)) {
            return false;
        }
        Department that = (Department) o;
        return getCount() == that.getCount() &&
                Objects.equals(getName(), that.getName()) &&
                Arrays.equals(getSortedEmployeesBySalary(), that.getSortedEmployeesBySalary());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getCount());
        result = 31 * result + Arrays.hashCode(employees);
        return result;
    }
}
