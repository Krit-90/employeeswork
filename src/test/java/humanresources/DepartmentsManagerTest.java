package humanresources;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsManagerTest {
    Employee emp1 = new StaffEmployee("Джон", "Джонсон", JobTitlesEnum.DIRECTOR, 30000);
    Employee emp2 = new StaffEmployee("Стив", "Стивенсон", JobTitlesEnum.ENGINEER, 25000);
    Employee emp3 = new StaffEmployee("Роберт", "Робертсон", JobTitlesEnum.MANAGER, 20000);
    Employee emp4 = new StaffEmployee("Смит", "Смитсон", JobTitlesEnum.TECHNICIAN, 10000);
    Employee emp5 = new StaffEmployee("Девид", "Девидсон", JobTitlesEnum.TECHNICIAN, 10000);
    Department dep1 = new Department("Office");
    Department dep2 = new Department("Склад");
    DepartmentsManager departmentsManager = new DepartmentsManager("1");
    Department[] departmentsArray = new Department[2];

    @Test
    public void add() {
        dep1.addEmployee(emp1);
        dep1.addEmployee(emp2);
        dep2.addEmployee(emp5);
        dep2.addEmployee(emp3);
        dep2.addEmployee(emp4);
        departmentsManager.add(dep1);
        departmentsManager.add(dep2);
        assertEquals(dep1, departmentsManager.getGroup("Office"));
    }

    @Test
    public void remove() {
        departmentsManager.add(dep1);
        departmentsManager.add(dep2);
        departmentsManager.remove("Office");
        assertEquals(null, departmentsManager.getGroup("Office"));
    }

    @Test
    public void getGroup() {
        departmentsManager.add(dep1);
        departmentsManager.add(dep2);
        assertEquals(dep2, departmentsManager.getGroup("Склад"));
    }

    @Test
    public void getEmployeesCount() {
        dep1.addEmployee(emp1);
        dep1.addEmployee(emp2);
        dep2.addEmployee(emp5);
        dep2.addEmployee(emp3);
        dep2.addEmployee(emp4);
        departmentsManager.add(dep1);
        departmentsManager.add(dep2);
        assertEquals(5, departmentsManager.getEmployeesCount());
    }

    @Test
    public void toArray() {
        departmentsArray[0] = dep1;
        departmentsArray[1] = dep2;
        departmentsManager.add(dep1);
        departmentsManager.add(dep2);
        assertEquals(departmentsArray, departmentsManager.toArray());
    }

    @Test
    public void getEmployeesCountByJobTitle() {
        dep1.addEmployee(emp1);
        dep1.addEmployee(emp2);
        dep2.addEmployee(emp5);
        dep2.addEmployee(emp3);
        dep2.addEmployee(emp4);
        departmentsManager.add(dep1);
        departmentsManager.add(dep2);
        assertEquals(2, departmentsManager.getEmployeesCountByJobTitle(JobTitlesEnum.TECHNICIAN));
    }

    @Test
    public void maxSalary() {
        dep1.addEmployee(emp1);
        dep1.addEmployee(emp2);
        dep2.addEmployee(emp5);
        dep2.addEmployee(emp3);
        dep2.addEmployee(emp4);
        departmentsManager.add(dep1);
        departmentsManager.add(dep2);
        assertEquals(emp1, departmentsManager.maxSalary());
    }

    @Test
    public void getEmployeeGroup() {
        dep1.addEmployee(emp1);
        dep1.addEmployee(emp2);
        dep2.addEmployee(emp5);
        dep2.addEmployee(emp3);
        dep2.addEmployee(emp4);
        departmentsManager.add(dep1);
        departmentsManager.add(dep2);
        assertEquals(dep1, departmentsManager.getEmployeeGroup("Джон", "Джонсон"));
    }
}