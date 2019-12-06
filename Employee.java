package humanresources;

import java.util.Objects;

public abstract class Employee {
    private static final int DEFAULT_SALARY = 0;
    private static final JobTitlesEnum DEFAULT_JOB_TITLE = JobTitlesEnum.NONE;
    private String name;
    private String surname;
    private JobTitlesEnum jobTitle;
    private int salary;


    protected Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.jobTitle = DEFAULT_JOB_TITLE;
        this.salary = DEFAULT_SALARY;
    }

    protected Employee(String name, String surname, JobTitlesEnum jobTitle, int salary) {
        this.name = name;
        this.surname = surname;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getSurname() {
        return surname;
    }

    protected void setSurname(String surname) {
        this.surname = surname;
    }

    protected JobTitlesEnum getJobTitle() {
        return jobTitle;
    }

    protected void setJobTitle(JobTitlesEnum jobTitle) {
        this.jobTitle = jobTitle;
    }

    protected int getSalary() {
        return salary;
    }

    protected void setSalary(int salary) {
        this.salary = salary;
    }

    abstract int getBonus();

    abstract void setBonus(int bonus);

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("Employee{");
        if (name != null) {
            buffer.append("name='").append(name).append('\'');
        }
        if (surname != null) {
            buffer.append(", surname='").append(surname).append('\'');
        }
        if (jobTitle != JobTitlesEnum.NONE) {
            buffer.append(", jobTitle='").append(jobTitle).append('\'');
        }
        if (salary != 0) {
            buffer.append(", salary=").append(salary).append('}');
        }
        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return getSalary() == employee.getSalary() &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(getSurname(), employee.getSurname()) &&
                getJobTitle() == employee.getJobTitle();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getJobTitle(), getSalary());
    }
}
