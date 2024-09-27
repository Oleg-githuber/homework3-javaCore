import java.util.Random;

/**
 * �����-���������
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
     * ����� ������ ���������� � ����������
     */
    public void printInfo() {
        System.out.printf("%s:%n%s %s %s%nphone number: %s%nage: %d years%nsalary: %.2f RUR", position, lastName, firstName, secondName, telephone, age, salary);
    }

    /**
     * ��������� �������� �� ���������
     * @param employee ���������
     */
    public static void pickUpSalary(Employee employee) {
        pickUpSalary(employee, 45, 5_000.0);
    }

    /**
     * ��������� ��������
     * @param employee ���������
     * @param minAge ����������� �������
     * @param increaseSalary ������ ��������� ��������
     */
    public static void pickUpSalary(Employee employee, int minAge, double increaseSalary) {
        if (employee.getAge() > minAge) {
            if (!(employee instanceof Manager)) {
                employee.setSalary(employee.getSalary() + increaseSalary);
            }
            // ��������� ������ ��� ������� ��������� � �����������. ���������, �������� �������, �������� ������������ �� ��������, ����������� ������ ���������������
//            else {
//                Manager.pickUpSalary((Manager) employee, minAge, 0);
//            }
        }
    }

    /**
     * ������� ���������� � ����������
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s: %s, age: %d years, birth date %s, salary: %.2f RUR", position, lastName, age, getBirthDate(), salary);
    }

    /**
     * ��������� ����������� �� ���� �������� ��� �������� ����������
     * @param otherEmployee ������ ��� ���������
     * @return
     */
    @Override
    public int compareTo(Employee otherEmployee) {
        return this.getBirthDate().compareTo(otherEmployee.getBirthDate());
    }
}
