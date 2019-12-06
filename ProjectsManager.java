package humanresources;

public class ProjectsManager extends LinkedList<EmployeeGroup> implements GroupsManager {

    public boolean remove(String name) {
        for (Node<EmployeeGroup> i = getFirst(); i != null; i = i.next) {
            if (name.equals(i.item.getName())) {
                deleteNode(i);
                return true;
            }
        }
        return false;
    }

    public EmployeeGroup getGroup(String name) {
        for (Node<EmployeeGroup> i = getFirst(); i != null; i = i.next) {
            if (name.equals(i.item.getName())) {
                return i.item;
            }
        }
        return null;
    }

    public int getEmployeesCount() {
        int count = 0;
        for (Node<EmployeeGroup> i = getFirst(); i != null; i = i.next) {
            count += i.item.getCount();
        }
        return count;
    }

    public int getEmployeesCountByJobTitle(JobTitlesEnum jobTitle) {
        int countJobTitle = 0;
        for (Node<EmployeeGroup> i = getFirst(); i != null; i = i.next) {
            for (int j = 0; j < i.item.getCount(); j++) {
                if (isJobTitlesMatch(jobTitle, i, j)) {
                    countJobTitle++;
                }
            }
        }
        return countJobTitle;
    }

    private boolean isJobTitlesMatch(JobTitlesEnum jobTitle, Node<EmployeeGroup> i, int j) {
        return jobTitle.equals(i.item.getEmployees()[j].getJobTitle());
    }

    public Employee maxSalary() {
        Employee richMan = getFirst().item.getEmployees()[0];
        for (Node<EmployeeGroup> i = getFirst(); i != null; i = i.next) {
            for (int j = 1; j < i.item.getCount(); j++) {
                if (compareSalary(richMan, i, j)) {
                    richMan = i.item.getEmployees()[j];
                }
            }
        }
        return richMan;
    }

    private boolean compareSalary(Employee richMan, Node<EmployeeGroup> i, int j) {
        return i.item.getEmployees()[j].getSalary() > richMan.getSalary();
    }

    public EmployeeGroup getEmployeeGroup(String name, String surname) {
        for (Node<EmployeeGroup> i = getFirst(); i != null; i = i.next) {
            if (i.item.getEmployee(name, surname) != null) {
                return i.item;
            }
        }
        return null;
    }
}
