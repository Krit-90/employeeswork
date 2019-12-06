package humanresources;

import java.util.Optional;
import java.util.stream.Stream;

public class TestPartTimeEmployee {
    public static void main(String[] args) {
        PartTimeEmployee test = new PartTimeEmployee("Блин", "Блинский", JobTitlesEnum.ACCOUNTANT, 100);
        System.out.println(test);
        BusinessTravel bt = new BusinessTravel("Moscow", 10, 100, "Семинар");
        System.out.println(bt);
        PartTimeEmployee[] partTimeEmployees = new PartTimeEmployee[10];
        for (int i = 0; i < 10; i++) {
            partTimeEmployees[i] = new PartTimeEmployee("name" + i, "lastName" + i);
        }
        StaffEmployee staffEmployee = new StaffEmployee("Девид", "Девидсон");
        staffEmployee.addDescription(new BusinessTravel("Moscow", 3, 5000, "Seminar"));
        staffEmployee.addDescription(new BusinessTravel("Piter", 3, 5000, "Teaching"));
        System.out.println(staffEmployee);
        System.out.println();
        Optional<PartTimeEmployee> emp = Stream.of(partTimeEmployees)
                .filter(employee -> employee.getSalary() > 100000)
                .findFirst();
        Employee employee1 = new StaffEmployee("", "");
        emp.ifPresent(partTimeEmployee -> partTimeEmployee.setBonus(1000));
    }
}
