package iterable;

import java.util.*;

public class IterableDemo {
    public static void main(String[] args)
    {
        //把实现类赋值给接口类
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        //使用for循环取出每个元素
        for (int i = 0; i < list.size(); i++)
        {
            Object element = list.get(i);
            System.out.println(element);
        }

        System.out.println("============");

        //使用迭代器循环每个元素的值
        Iterator it = list.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        //使用Enumeration取出所有的元素
        System.out.println("===============");
        Vector ve = new Vector();
        ve.add("1");
        ve.add("2");
        ve.add("3");
        ve.add("4");
        Enumeration element = ve.elements();
        while (element.hasMoreElements())
        {
            System.out.println(element.nextElement());
        }

        //使用for循环每个元素
        System.out.println("===========");
        for (Object ele : list)
        {
            System.out.println(ele+"-");
        }
    }
}
