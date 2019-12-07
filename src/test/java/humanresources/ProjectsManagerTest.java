package humanresources;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectsManagerTest {
    Employee emp1 = new StaffEmployee("Джон", "Джонсон", JobTitlesEnum.DIRECTOR, 30000);
    Employee emp2 = new StaffEmployee("Стив", "Стивенсон", JobTitlesEnum.ENGINEER, 25000);
    Employee emp3 = new StaffEmployee("Роберт", "Робертсон", JobTitlesEnum.MANAGER, 20000);
    Employee emp4 = new StaffEmployee("Смит", "Смитсон", JobTitlesEnum.TECHNICIAN, 10000);
    Employee emp5 = new StaffEmployee("Девид", "Девидсон", JobTitlesEnum.TECHNICIAN, 10000);
    Department dep1 = new Department("Office");
    Department dep2 = new Department("Склад");
    ProjectsManager projectsManager = new ProjectsManager();
    Department[] departmentsArray = new Department[2];

    @Test
    public void add() {
        dep1.addEmployee(emp1);
        dep1.addEmployee(emp2);
        dep2.addEmployee(emp5);
        dep2.addEmployee(emp3);
        dep2.addEmployee(emp4);
        projectsManager.add(dep1);
        projectsManager.addFirst(dep2);
        assertEquals(dep1, projectsManager.getGroup("Office"));
    }

    @Test
    public void remove() {
        projectsManager.add(dep1);
        projectsManager.add(dep2);
        projectsManager.remove("Office");
        assertEquals(null, projectsManager.getGroup("Office"));
    }

    @Test
    public void toArray() {
    }

    @Test
    public void getGroup() {
    }

    @Test
    public void maxSalary() {
    }

    @Test
    public void getEmployeeGroup() {
    }
}