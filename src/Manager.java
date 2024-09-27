/**
 * �����-������������
 */
public class Manager extends Employee{
     public Manager(String lastName, String firstName, String secondName, String position, String telephone, int age, double salary) {
        super(lastName, firstName, secondName, position, telephone, age, salary);
    }

    /**
     * ��������� �������� �� ���������
     * @param employee ���������
     */
    //@Override
    public static void pickUpSalary(Manager employee) {
        pickUpSalary(employee, 45, 5_000.0);
    }

    /**
     * ��������� ��������
     * @param employee ���������
     * @param minAge ����������� �������
     * @param increaseSalary ������ ��������� ��������
     */
    //@Override
    public static void pickUpSalary(Manager employee, int minAge, double increaseSalary) {
        if (employee.getAge() > minAge) {
            employee.setSalary(employee.getSalary() + increaseSalary);
        }
    }
}
