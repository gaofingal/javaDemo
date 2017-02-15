package junit;
public class EmployeeDAOTest {
    @MyBefore
    public void init(){
        System.out.println("初始化--");
    }
    @MyAfter
    public void destory(){
        System.out.println("销毁--");
    }
    @MyTest
    public void testSave(){
        System.out.println("测试保存--");
    }
    @MyTest
    public void testDelete()
    {
        System.out.println("测试删除--");
    }
}
