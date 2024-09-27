import java.util.Random;

/**
 * Класс-сотрудник
 */
public class Employee implements Comparable<Employee> {
    private String lastName;
    private String firstName;
    private String secondName;

    private String position;
    private String telephone;

    private int age;
    private int year;
    private int month;
    private int day;

    private double salary;

    public Employee(String lastName, String firstName, String secondName, String position, String telephone, int age, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.position = position;
        this.telephone = telephone;
        this.age = age;
        this.salary = salary;
        year = 2024 - age;
        Random random = new Random();
        month = random.nextInt(8);
        day = random.nextInt(28);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPosition() {
        return position;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBirthDate() {
        return String.format("%d.%d.%d",year, month, day);
    }

    /**
     * Вывод полной информации о сотруднике
     */
    public void printInfo() {
        System.out.printf("%s:%n%s %s %s%nphone number: %s%nage: %d years%nsalary: %.2f RUR", position, lastName, firstName, secondName, telephone, age, salary);
    }

    /**
     * Повышение зарплаты по умолчанию
     * @param employee сотрудник
     */
    public static void pickUpSalary(Employee employee) {
        pickUpSalary(employee, 45, 5_000.0);
    }

    /**
     * Повышение зарплаты
     * @param employee сотрудник
     * @param minAge минимальный возраст
     * @param increaseSalary размер повышения зарплаты
     */
    public static void pickUpSalary(Employee employee, int minAge, double increaseSalary) {
        if (employee.getAge() > minAge) {
            if (!(employee instanceof Manager)) {
                employee.setSalary(employee.getSalary() + increaseSalary);
            }
            // Следующие строки для особого отношения к руководству. Поскольку, согласно заданию, зарплата руководителя не меняется, бесполезные строки закоментированы
//            else {
//                Manager.pickUpSalary((Manager) employee, minAge, 0);
//            }
        }
    }

    /**
     * Краткая информация о сотруднике
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s: %s, age: %d years, birth date %s, salary: %.2f RUR", position, lastName, age, getBirthDate(), salary);
    }

    /**
     * Сравнение сотрудников по дате рождения без условных операторов
     * @param otherEmployee объект для сравнения
     * @return
     */
    @Override
    public int compareTo(Employee otherEmployee) {
        return this.getBirthDate().compareTo(otherEmployee.getBirthDate());
    }
}
