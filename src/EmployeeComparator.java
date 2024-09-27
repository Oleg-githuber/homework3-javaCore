import java.util.Comparator;

/**
 * �����-���������� ��� ���������� ����������� �� ���� ��������
 */
public class EmployeeComparator implements Comparator<Employee> {
    /**
     * ���������� ��������� ���� ����������� �� ���� ��������
     * @param employee1 ������ ���������
     * @param employee2 ������ ���������
     * @return
     */
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.compareTo(employee2);
    }
}
