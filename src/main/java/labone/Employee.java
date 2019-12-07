package labone;

public class Employee {
    private static final String DEFAULT_JOB_TITLE = "";
    private static final int DEFAULT_SALARY = 0;
    private String name;
    private String surname;
    private String jobTitle;
    private int salary;
    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.jobTitle = DEFAULT_JOB_TITLE;
        this.salary = DEFAULT_SALARY;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", jobTitle='").append(jobTitle).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
