package labone;
// Почему нельзя lab1

public class Department {
    private String depName;
    private Employee[] workers;
    private int count;

    public Department(String depName) {
        this.depName = depName;
        this.workers = new Employee[8];
    }

    public Department(String depName, int countWorkers) {
        this.depName = depName;
        this.workers = new Employee[countWorkers];
    }

    public Department(String depName, Employee[] workers) {
        this.depName = depName;
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "humanresources.Department{" +
                "depName='" + depName + '\'' +
                ", count=" + getCount() +
                '}';
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void addEmployee(Employee emp) {

//        for(humanresources.Employee em : workers){ в этом случае НЕ ДОБАВЛЯЕТ, хмм
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] == null) {
                workers[i] = emp;

                break;
            }
            if (workers[workers.length - 1] == workers[i]) {
                Employee[] temp = new Employee[workers.length * 2];
                temp[workers.length] = emp;
                for (int j = 0; j < workers.length; j++) {
                    temp[j] = workers[j];
                }
                workers = temp;
            }
        }
    }

    public boolean deleteEmployee(String name, String surname) {
        boolean isDelete = false;
        Integer i;
        for (i = 0; i < workers.length; i++) {
            if (workers[i].getName() == name && workers[i].getSurname() == surname) {
                isDelete = true;
                for (int k = i; k < workers.length - 1; k++) {
                    workers[k] = workers[k + 1];
                }
                workers[workers.length - 1] = null;
                break;
            }
        }
        if (!isDelete) {
            System.out.println(" Работник не найден");
        }

        return isDelete;
    }

    public int getCount() {
        count = 0;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] != null) {
                count++;
            }
        }
        return count;
    }

    public Employee[] arrayWorkers() {
        Employee[] array = new Employee[getCount()];
        for (int i = 0; i < array.length; i++) {
            array[i] = workers[i];
        }
        return array;
    }

    public Employee[] jobTitleArray(String jobTitle) {
        int countJobTitle = 0;
        for (Employee emp : workers) {
            if (emp != null && jobTitle == emp.getJobTitle()) {
                countJobTitle++;
            }
        }
        Employee[] array = new Employee[countJobTitle];
        int j = 0;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] != null && jobTitle == workers[i].getJobTitle()) {
                array[j] = workers[i];
                j++;
            }
        }
        return array;
    }

    public Employee[] arraySortedSalary() { // По убыванию зарплаты
        Employee[] array = arrayWorkers();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i].getSalary() >= array[j].getSalary()) {
                    Employee x = array[i];
                    array[i] = array[j];
                    array[j] = x;
                }
            }
        }
        return array;

    }
}
