package humanresources;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {
    StaffEmployee staff1 = new StaffEmployee("Dwayne", "Johnson");
    StaffEmployee staff2 = new StaffEmployee("Leon", "Johnson");
    BusinessTravel businessTravel1 = new BusinessTravel("Moscow", 3, 5000, "Seminar");
    BusinessTravel businessTravel2 = new BusinessTravel("New-York", 7, 20000, "Work");
    Employee[] staffEmployees = new StaffEmployee[2];
    Department department = new Department("Office");

    @Test
    public void getBusinessTravelerArray() {
        department.addEmployee(staff1);
        department.addEmployee(staff2);
        staff1.addDescription(businessTravel1);
        staff1.addDescription(businessTravel2);
        staff2.addDescription(businessTravel1);
        staffEmployees[0] = staff1;
        staffEmployees[1] = staff2;
        assertArrayEquals(staffEmployees, department.getBusinessTravelerArray());
    }
}