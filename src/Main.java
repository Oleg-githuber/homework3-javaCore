/**
 * ������� 1
 * ������: ������� ����� ���������� � ������: ���, ���������, �������,
 * ��������, �������;
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        // ������������� �����������
        Employee[] workers = {
                new Employee("Ivanov", "Ivan", "Ivanovich", "Worker", "111-111", 35, 30_000.0),
                new Employee("Petrov", "Petr", "Petrovich", "Worker", "222-222", 18, 30_000.0),
                new Employee("Sidorov", "Sidor", "Sidorovich", "Senior worker", "333-333", 55, 35_323.18),
                new Employee("Kirkorov", "Philipp", "Bedrosovich", "Singer", "444-444", 57, 1_000_000.0),
                new Employee("Biden", "Joseph", "Josephovich", "President", "666-666", 81, 999_999.99),
                new Manager("Nechibylo", "Oleg", "Vasilievich", "Manager", "777-777", 54, 100_000)
        };

        // ��������� �������� �����������
        System.out.println("��������� �������� �����������:");
        System.out.println("Before:");
        for (Employee worker : workers) {
            System.out.println(worker);
        }
        //pickUpSalary(workers);    // ����� ��������� �������� ���� ��� ���������� �����������. ��������������, �.�. ����� � ����� ������������ ������ �����
        System.out.println("After:");
        for (Employee worker : workers) {
            Employee.pickUpSalary(worker);  // ��������� �������� �����������, ����� �������������
            System.out.println(worker);
        }

        // ���������� ������� �������������� ��������
        System.out.printf("%n������� ������� �����������: %d%n������� ��������: %.2f%n", calculateAverageAge(workers), calculateAverageSalary(workers));

        // ���������� ��� ������������ �����������
        System.out.println("\n���������� �� ���� ��������\n\n�� ����������:");
        for (Employee worker : workers) {
            System.out.println(worker);
        }
        // ��� ���������� ����������� ArrayList
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(workers));
        employeeList.sort(new EmployeeComparator());
        workers = employeeList.toArray(new Employee[5]);
        System.out.println("\n����� ����������:");
        for (Employee worker : workers) {
            System.out.println(worker);
        }
    }

    /**
     * ��������� �������� �� ���������
     * @param workers ������ �����������
     */
    public static void pickUpSalary(Employee[] workers) {
        pickUpSalary(workers, 45, 5_000.0);
    }

    /**
     * ��������� ��������
     * @param workers ������ �����������
     * @param minAge ����������� �������
     * @param increaseSalary �������� � ��������
     */
    public static void pickUpSalary(Employee[] workers, int minAge, double increaseSalary) {
        for (Employee worker : workers) {
            if (worker.getAge() > minAge) {
                worker.setSalary(worker.getSalary() + increaseSalary);
            }
        }
    }

    /**
     * ���������� �������� ��������������� �������� ������� �����������
     * @param workers ������ �����������
     * @return
     */
    public static int calculateAverageAge(Employee[] workers) {
        int sumAge = 0;
        for (Employee worker : workers) {
            sumAge += worker.getAge();
        }
        return sumAge / workers.length;
    }

    /**
     * ���������� ������� �������������� �������� ������� �����������
     * @param workers ������ �����������
     * @return
     */
    public static double calculateAverageSalary(Employee[] workers) {
        double sumSalary = 0;
        for (Employee worker : workers) {
            sumSalary += worker.getSalary();
        }
        return sumSalary / workers.length;
    }
}