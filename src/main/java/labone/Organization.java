package labone;

public class Organization {
    private String title;
    private Department[] departments;

    public Organization(String title) {
        this.title = title;
    }

    public Organization(String title, Department[] departments) {
        this.title = title;
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "humanresources.Organization{" +
                "title='" + title + '\'' +
                '}';
    }

    public void addDep(Department k) {
        //       for (humanresources.Department de : departments) {
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] == null) {
                departments[i] = k;
                break;
            }
            if (departments[departments.length - 1] == departments[i]) {
                Department[] temp = new Department[departments.length * 2];
                temp[departments.length] = k;
                for (int j = 0; j < departments.length; j++) {
                    temp[j] = departments[j];
                }
                departments = temp;
            }
        }
    }

    public boolean deleteDepartment(String name) {
        boolean isDelete = false;
        Integer i;
        for (i = 0; i < departments.length; i++) {
            if (departments[i].getDepName() == name) {
                isDelete = true;
                break;
            } else {
                i = null;
                System.out.println("Отдел не найден");
            }
        }
        if (i != null) {
            for (int k = i; k < departments.length - 1; k++) {
                departments[k] = departments[k + 1];
            }
            departments[departments.length - 1] = null;
        }
        return isDelete;
    }

    public Department getDep(String depName) {
        // Если ТОЛЬКО в цикле переменная department инициализируется, то notCompile
        Department department = null;
        Integer i;
        for (i = 0; i < departments.length; i++) {
            if (departments[i].getDepName() == depName) {
                department = departments[i];
                break;
            } else {
                department = null;
                System.out.println("Отдел не найден");
            }
        }
        return department;
    }

    public int getCount() {
        Integer count = 0;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null) {
                count++;
            }
        }
        return count;
    }

    public Department[] arrayDeps() {
        Department[] arrayDeps = new Department[getCount()];
        for (int i = 0; i < arrayDeps.length; i++) {
            arrayDeps[i] = departments[i];
        }
        return arrayDeps;
    }

    public int countJobTitle(String jobTitle) {
        int countJobTitle = 0;
        for (Department d : departments) {
            if (d != null) {
                countJobTitle += d.jobTitleArray(jobTitle).length;
            }
        }
        return countJobTitle;
    }

    public Employee maxSalary() {
        Employee richMan = null;

        for (int i = 0; i < departments.length; i++) {
            for (int j = 0; j < departments.length; j++) {
                if (compareSalary(i, j)) {
                    richMan = departments[i].arraySortedSalary()[0];
                }
            }
        }
        return richMan;
    }

    private boolean compareSalary(int i, int j) {
        return departments[i] != null && departments[j] != null
                && departments[i].arraySortedSalary()[0].getSalary()
                >= departments[j].arraySortedSalary()[0].getSalary();
    }

    public Department depEmployeeJobTitle(String name, String surname) {
        Department searchDep = null;
        for (int i = 0; i < departments.length; i++) {
            for (int k = 0; k < departments[k].arrayWorkers().length; k++) {
                if (departments[k].arrayWorkers()[k].getName().equals(name)
                        && departments[k].arrayWorkers()[k].getSurname().equals(surname)) {
                    searchDep = departments[k];
                    break;
                } else {
                    System.out.println(" Работник не найден");
                }
            }
        }
        return searchDep;

    }

}
