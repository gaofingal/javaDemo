package anno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@VIP(level="height",age=25,habby={"A","B"},gender=Gender.BOY)
class Person{
    @Deprecated
    public void doWork()
    {}
}

public class AnnotationDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("-------获取所有的注释-------");
        Class clz = Person.class;
        Annotation[] anos =  clz.getAnnotations();
        for (Annotation ano : anos) {
            System.out.println(ano);
        }
        System.out.println("------获取注释-------");
        Annotation vip = clz.getAnnotation(VIP.class);
        System.out.println(vip);
        System.out.println("-------获取方法的注释--------");
        Class cla = Person.class;
        Method method = cla.getMethod("doWork");
        Deprecated deprecated = method.getAnnotation(Deprecated.class);
        System.out.println(deprecated);
    }
}
