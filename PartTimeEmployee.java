package humanresources;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, String surname) {
        super(name, surname);
    }

    public PartTimeEmployee(String name, String surname, JobTitlesEnum jobTitle, int salary) {
        super(name, surname, jobTitle, salary);
    }

    @Override
    int getBonus() {
        return 0;
    }

    @Override
    void setBonus(int bonus) {

    }

    @Override
    public String toString() {
/*        setJobTitle(humanresources.JobTitlesEnum.humanresources.PartTimeEmployee);
        return super.toString();*/
        StringBuilder buffer = new StringBuilder();

        buffer.append("humanresources.Employee{");
        if (getName() != null) {
            buffer.append("name='").append(getName()).append('\'');
        }
        if (getSurname() != null) {
            buffer.append(", surname='").append(getSurname()).append('\'');
        }
        if (getJobTitle() != JobTitlesEnum.NONE) {
            buffer.append(", jobTitle='").append(getJobTitle()).append("<PartTimeEmployee>").append('\'');
        }
        if (getSalary() != 0) {
            buffer.append(", salary=").append(getSalary()).append('}');
        }
        return buffer.toString();
    }
}
