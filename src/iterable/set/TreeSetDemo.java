package iterable.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args)
    {
        Set<StudentDemo> treeSet = new TreeSet();
        treeSet.add(new StudentDemo("gao",19,90));
        treeSet.add(new StudentDemo("gao",18,85));
        treeSet.add(new StudentDemo("gao",20,80));
        treeSet.add(new StudentDemo("gao",17,95));

        System.out.println(treeSet);
    }
}

class StudentDemo implements Comparable{
    private String name;
    private int age;
    private int score;

    StudentDemo(String name, int age, int score)
    {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int compareTo(Object obj) {
        StudentDemo other = (StudentDemo) obj;
        if(this.score > other.score)
            return 1;
        else if(this.score < other.score)
            return -1;
        else
        {
            if(this.age > other.age)
                return 1;
            else if(this.age < other.age)
                return -1;
            else
                return 0;
        }
    }
    public String toString() {
        return "StudentDemo [name=" + name + ",age=" + age + ",score=" + score + "]";
    }
}
