package humanresources;

public class DepartmentsManager implements GroupsManager {
    private static final int DEFAULT_COUNT = 0;
    private String title;
    private EmployeeGroup[] departments;
    private int count;

    public DepartmentsManager(String title) {
        this.title = title;
        this.count = DEFAULT_COUNT;
        this.departments = new Department[1];
        // Необхоидимо было проинициалицировать, хотя бы минимальным массивом с размером 1, иначе ensureCapacity()
        //не сработает
    }

    public DepartmentsManager(String title, EmployeeGroup[] departments) {
        this.title = title;
        this.departments = departments;
        this.count = departments.length;
    }

    public void add(EmployeeGroup department) {
        if (ensureCapacity()) {
            departments[count++] = department;
        } else {
            EmployeeGroup[] temp = new Department[departments.length * 2];
            System.arraycopy(departments, 0, temp, 0, count);
            departments = temp;
            departments[count++] = department;
        }
    }

    private boolean ensureCapacity() {
        return count < departments.length;
    }

    public boolean remove(String name) {
        for (int i = 0; i < count; i++) {
            if (departments[i].getName() == name) {
                shift(i);
                count--;
                return true;
            }
        }
        return false;
    }

    public int removeCounted(EmployeeGroup department) {
        int k = 0;
        for (int i = 0; i < count; i++) {
            Department j = (Department) departments[i];
            if (j.equals(department)) {
                shift(i);
                count--;
                k++;
            }
        }
        return k;
    }

    //=)
    private void shift(int i) {
        System.arraycopy(departments, i + 1, departments, i, count - i - 1);
        departments[count - 1] = null;
    }

    public EmployeeGroup getGroup(String name) {
        for (int i = 0; i < count; i++) {
            if (departments[i].getName() == name) {
                return departments[i];
            }
        }
        return null;
    }

    public int getEmployeesCount() {
        int count = 0;
        for (EmployeeGroup d : departments) {
            if (d != null) {
                Department i = (Department) d;
                count += i.getCount();
            }
        }
        return count;
    }


    public int getCount() {
        return count;
    }

    public Department[] toArray() {
        Department[] arrayDepartments = new Department[count];
        System.arraycopy(departments, 0, arrayDepartments, 0, count);
        return arrayDepartments;
    }

    public int getEmployeesCountByJobTitle(JobTitlesEnum jobTitle) {
        int countJobTitle = 0;
        for (EmployeeGroup d : departments) {
            if (d != null) {
                Department i = (Department) d;
                countJobTitle += i.getEmployeesByJobTitle(jobTitle).length;
            }
        }
        return countJobTitle;
    }

    public Employee maxSalary() {
        Employee richMan = departments[0].maxSalary();
        for (int i = 1; i < count; i++) {
            if (departments[i].maxSalary().getSalary() > richMan.getSalary()) {
                richMan = departments[i].maxSalary();
            }
        }
        return richMan;
    }

    public EmployeeGroup getEmployeeGroup(String name, String surname) {
        for (int i = 0; i < count; i++) {
            Department j = (Department) departments[i];
            if (j.hasEmployee(name, surname)) {
                return departments[i];
            }
        }
 /*           for (int k = 0; k < departments[k].getCount(); k++) {
                if (departments[k].getEmployees()[k].getName() == name
                && departments[k].getEmployees()[k].getSurname() == surname) {
                    searchDep = departments[k];
                    break;
                } else {
                    System.out.println(" Работник не найден");
                }
            }
        }
        return searchDep;*/
        return null;
    }


    @Override
    public String toString() {
        return "DepartmentsManager{" +
                "title='" + title + '\'' +
                '}';
    }
}
