import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Comparable<Employee>,Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

     Employee(String n, double s) {
        name = n;
        salary = s;
        hireDay = new Date();
    }

    public Employee clone() throws CloneNotSupportedException
    {
        //call object.clone()
        Employee cloned = (Employee) super.clone();

        //clone mutable fields
        cloned.hireDay = (Date)hireDay.clone();

        return cloned;
    }

    /**
     * Set the hire day to a given date
     * @param year  the year of the hire day
     * @param month the month of the hire day
     * @param day   the day of the hire day
     */
    public void setHireDay(int year, int month, int day)
    {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        //Example of instance field mutation
        hireDay.setTime(newHireDay.getTime());
    }

    /**
     * get the name
     * @return  name
     */
    String getName() {
        return name;
    }

    /**
     * get the salary
     * @return  salary
     */
    double getSalary() {
        return salary;
    }

    /**
     * raise the salary
     * @param byPercent raise by percent
     */
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * to String
     * @return  string of class
     */
    public String toString()
    {
        return "Employee [name=" + name+ ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }


    /**
     * Compares employee by salary
     *
     * @param other other another Employee object
     * @return a negative value if this employee has lower salary than otherObject;
     * return 0 :the salaries are the same, a positive value otherwise
     */
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }
}