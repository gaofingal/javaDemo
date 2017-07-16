package iterable.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetComparator {
    public static void main(String[] args)
    {
        //创建Comparator对象
        Comparator com = new NameComparator();
        //创建TreeSet对象
        Set<Student> treeSet = new TreeSet(com);
        treeSet.add(new Student("Gao"));
        treeSet.add(new Student("Faoo"));
        treeSet.add(new Student("Caoooo"));
        treeSet.add(new Student("Taooo"));

        System.out.println(treeSet);
    }
}
//排序方法
class NameComparator implements Comparator{
    public int compare(Object obj1, Object obj2) {
        //转换类型
        Student student1 = (Student) obj1;
        Student student2 = (Student) obj2;

        //获取名称
        String name1 = student1.getName();
        String name2 = student2.getName();

        //进行比较
        if(name1.length() > name2.length())
        {
            return -1;
        }
        else if(name1.length() < name2.length()) {
            return 1;
        }
        else{
            return 0;
        }
    }
}

//学生类
class Student{
    private String name;

    //构造器
    Student(String name)
    {
        this.name = name;
    }
    //get name
    String getName() {
        return name;
    }
    public String toString() {
        return "Student [name=" + name + "]";
    }
}
