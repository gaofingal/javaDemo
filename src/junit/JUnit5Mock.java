package junit;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JUnit5Mock {
    /**
     * 1.先获取字节码对象
     * 2.获取EmployeeDAOTest类中所有方法的对象
     * 3.把方法归类，按照MyTest、MyBefore、MyAfter分类
     *      beforeList: 所有被@MyBefore标注的
     *      afterList:  所有被@MyAfter标注的
     *      testList:   所有被@MyTest标注的
     * 4.迭代出每一个方法：
     *      运行所有beforeList中的方法
     *      testList中的方法
     *      运行所有afterLIst中的方法
     */
    public static void main(String[] args) throws Exception {
        //1.先获取字节码对象
        Class employeeClass = EmployeeDAOTest.class;
        //2.获取EmployeeDAOTest类中所有方法的对象
        Method[] employeeMethods = employeeClass.getMethods();

        //定义三种ArrayList类型
        List<Method> myBeforeList = new ArrayList<>();
        List<Method> myAfterList = new ArrayList<>();
        List<Method> myTestList = new ArrayList<>();

        //3.把方法归类，按照MyTest、MyBefore、MyAfter分类
        for (Method employeeMethod : employeeMethods) {
            if (employeeMethod.isAnnotationPresent(MyTest.class)) {
                myTestList.add(employeeMethod);
            }else if(employeeMethod.isAnnotationPresent(MyAfter.class))
            {
                myAfterList.add(employeeMethod);
            }else if(employeeMethod.isAnnotationPresent(MyBefore.class))
            {
                myBeforeList.add(employeeMethod);
            }
        }

        //4.迭代出每一个方法
        Object object = employeeClass.newInstance();
        for (Method method : myTestList) {
            for (Method method1 : myBeforeList) {
                method1.invoke(object);
            }
            method.invoke(object);
            for (Method method2 : myAfterList) {
                method2.invoke(object);
            }
        }


    }


}
