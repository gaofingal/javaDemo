public class ThreadDemo {
    public static void main(String arg[])
    {
        System.out.println("begin!!!!!!!!!");
        //创建线程
        GameDemo gameDemo = new GameDemo();
        //启动线程
        gameDemo.start();
        for(int i = 0; i < 200; i++)
        {
            System.out.println("fate.......");
        }
    }

}
class GameDemo extends java.lang.Thread
{
    //线程方法
    public void run()
    {
        //线程体
        for(int i = 0; i < 200; i++)
        {
            System.out.println("钢炼.......");
        }
    }
}
