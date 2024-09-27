import java.util.Comparator;

/**
 *  ласс-компаратор дл€ сортировки сотрудников по дате рождени€
 */
public class EmployeeComparator implements Comparator<Employee> {
    /**
     *  омпаратор сравнени€ двух сотрудников по дате рождени€
     * @param employee1 первый сотрудник
     * @param employee2 второй сотрудник
     * @return
     */
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.compareTo(employee2);
    }
}
