import java.util.Arrays;

/**
 * 接口的使用方法-实例类排序需要实现camparable接口
 */
public class EmployeeSortTest {
    public static void main(String args[])
    {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);

        Arrays.sort(staff);

        //print out information about all employee objects
        for(Employee e : staff)
            System.out.println("name="+ e.getName() + ", salary=" + e.getSalary());
    }
}

