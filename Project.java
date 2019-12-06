package humanresources;

import java.util.Arrays;
import java.util.Objects;

public class Project extends LinkedList<Employee> implements EmployeeGroup {
    private String name;

    public Project(String name) {
        super();
        this.name = name;
    }

    public Project(String name, Employee[] employees) {
        super(employees);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee(String name, String surname) {
        for (Node<Employee> i = getFirst(); i != null; i = i.next) {
            if (name.equals(i.item.getName()) && surname.equals(i.item.getSurname())) {
                return i.item;
            }
        }
        return null;
    }

    public void remove(String name, String surname) {
        for (Node<Employee> i = getFirst(); i != null; i = i.next) {
            if (name.equals(i.item.getName()) && surname.equals(i.item.getSurname())) {
                deleteNode(i);
            }
        }
    }

    public Employee maxSalary() {
        Node<Employee> richMan = getFirst();
        for (Node<Employee> i = getFirst().next; i != null; i = i.next) {
            if (i.item.getSalary() > richMan.item.getSalary()) {
                richMan = i;
            }
        }
        return richMan.item;
    }

    public Employee[] getSortedEmployeesBySalary() {
        Employee[] employees = toArray();
        for (int i = 0; i < this.getCount(); i++) {
            for (int j = 0; j < this.getCount(); j++) {
                if (employees[i].getSalary() >= employees[j].getSalary()) {
                    Employee x = employees[i];
                    employees[i] = employees[j];
                    employees[j] = x;
                }
            }
        }
        return employees;
    }

    public Employee[] getEmployees() {
        return toArray();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return Objects.equals(getName(), project.getName()) &&
                Arrays.equals(getSortedEmployeesBySalary(), project.getSortedEmployeesBySalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
