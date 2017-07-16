package anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

enum Gender{
    BOY,GIRL,OTHER
}

// 该注释表示此注释类适用于哪些（类TYPE、方法METHOD、属性FIELD）
@Target(ElementType.TYPE)
//表示注释的生存时间（RUNTIME-JVM、SOURCE-源文件、CLASS-字节码）
@Retention(RetentionPolicy.RUNTIME)
public @interface VIP {
    //注释是特殊的接口，方法称为属性，为抽象
    String level();
    int age() default 20;//设置默认值的方式
    String[] habby();
    Gender gender() default Gender.BOY;

}
