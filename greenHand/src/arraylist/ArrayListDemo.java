package arraylist;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args)
    {
        ArrayList<String> student = new ArrayList<>();
        student.add("R");
        student.add("T");
        student.add("U");
        student.add("A");
        student.add("B");

        //获取索引为3的元素
        Object element = student.get(3);
        System.out.println(element);

        //数组是否为空
        System.out.println(student.isEmpty());

        //获取值为3的索引值
        System.out.println(student.indexOf("U"));

        //移除3
        System.out.println(student.remove(2));

        //替换A为F
        System.out.println(student.set(2,"F"));


        System.out.println(student);
    }

}
