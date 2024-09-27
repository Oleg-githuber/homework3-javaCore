/**
 * Задание 1
 * Задача: Создать класс ”Сотрудник” с полями: ФИО, должность, телефон,
 * зарплата, возраст;
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        // Инициализация сотрудников
        Employee[] workers = {
                new Employee("Ivanov", "Ivan", "Ivanovich", "Worker", "111-111", 35, 30_000.0),
                new Employee("Petrov", "Petr", "Petrovich", "Worker", "222-222", 18, 30_000.0),
                new Employee("Sidorov", "Sidor", "Sidorovich", "Senior worker", "333-333", 55, 35_323.18),
                new Employee("Kirkorov", "Philipp", "Bedrosovich", "Singer", "444-444", 57, 1_000_000.0),
                new Employee("Biden", "Joseph", "Josephovich", "President", "666-666", 81, 999_999.99),
                new Manager("Nechibylo", "Oleg", "Vasilievich", "Manager", "777-777", 54, 100_000)
        };

        // Повышение зарплаты сотрудникам
        System.out.println("Повышение зарплаты сотрудникам:");
        System.out.println("Before:");
        for (Employee worker : workers) {
            System.out.println(worker);
        }
        //pickUpSalary(workers);    // Метод повышения зарплаты всем без исключения сотрудникам. Закоментирован, т.к. далее в цикле используется другой метод
        System.out.println("After:");
        for (Employee worker : workers) {
            Employee.pickUpSalary(worker);  // Повышение зарплаты сотрудников, кроме руководителей
            System.out.println(worker);
        }

        // Вычисление средних арифметических значений
        System.out.printf("%nСредний возраст сотрудников: %d%nСредняя зарплата: %.2f%n", calculateAverageAge(workers), calculateAverageSalary(workers));

        // Сортировка для демонстрации компаратора
        System.out.println("\nСортировка по дате рождения\n\nДо сортировки:");
        for (Employee worker : workers) {
            System.out.println(worker);
        }
        // Для сортировки использовал ArrayList
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(workers));
        employeeList.sort(new EmployeeComparator());
        workers = employeeList.toArray(new Employee[5]);
        System.out.println("\nПосле сортировки:");
        for (Employee worker : workers) {
            System.out.println(worker);
        }
    }

    /**
     * Повышение зарплаты по умолчанию
     * @param workers массив сотрудников
     */
    public static void pickUpSalary(Employee[] workers) {
        pickUpSalary(workers, 45, 5_000.0);
    }

    /**
     * Повышение зарплаты
     * @param workers массив сотрудников
     * @param minAge минимальный возраст
     * @param increaseSalary прибавка к зарплате
     */
    public static void pickUpSalary(Employee[] workers, int minAge, double increaseSalary) {
        for (Employee worker : workers) {
            if (worker.getAge() > minAge) {
                worker.setSalary(worker.getSalary() + increaseSalary);
            }
        }
    }

    /**
     * Вычисление среднего арифметического возраста массива сотрудников
     * @param workers массив сотрудников
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
     * Вычисление средней арифметической зарплаты массива сотрудников
     * @param workers массив сотрудников
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