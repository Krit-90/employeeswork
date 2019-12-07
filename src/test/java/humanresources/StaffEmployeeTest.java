package humanresources;

import org.junit.After;
import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffEmployeeTest {
    private StaffEmployee employee;

    @Before
    public void setUp() throws Exception {
        employee = new StaffEmployee("firstName", "lastName");
    }

    @Test
    public void getName() {
        assertEquals(employee.getName(), "firstName");
        assertNotEquals(employee.getName(), "FirstName");
    }


    @Test
    public void setName() {
        String name = "firstname";
        employee.setName(name);
        assertEquals(employee.getName(), "firstname");
    }

    @Test
    public void getSurname() {
    }

    @Test
    public void setSurname() {
    }

    @Test
    public void getJobTitle() {
    }

    @Test
    public void setJobTitle() {
    }

    @Test
    public void getSalary() {
    }

    @Test
    public void setSalary() {
    }

    @Test
    public void toString1() {
    }

    @Test
    public void equals1() {
    }

    @Test
    public void hashCode1() {
    }

    @Test
    public void getCountBusinessTravel() {
    }

    @Test
    public void addDescription() {
    }

    @Test
    public void getBusinessTravels() {
    }

    @Test
    public void getBonus() {
    }

    @Test
    public void setBonus() {
    }

    @Test
    public void haveTravels() {
    }

    @Test
    public void toString2() {
    }

    @Test
    public void equals2() {
    }

    @Test
    public void hashCode2() {
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }
}