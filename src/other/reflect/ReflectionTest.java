package other.reflect;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.*;
import java.lang.reflect.*;


public class ReflectionTest
{
   public static void main(String args[])
   {
       //read class name from command line args or user input
       String name;

       if(args.length > 0) name = args[0];
       else
       {
           Scanner in = new Scanner(System.in);
           System.out.println("Enter class name(e.g java.util.Date):");
           name = in.next();
       }

       try
       {
           //print class name and superclass name(if != Object)
           Class cl = Class.forName(name);      //子类
           Class supercl = cl.getSuperclass();  //超类
           String modifiers = Modifier.toString(cl.getModifiers());   //将cl类的静态方法的修饰符打印出来

           //如果超类存在并且不是Object类，打印出名字
           if(supercl != null && supercl != Object.class)
           {
               System.out.print("extends"+supercl.getName());
           }

           System.out.print("\n{\n");
           printConstructors(cl);
           System.out.println();
           printMethods(cl);
           System.out.println();
           printFields(cl);
           System.out.println("}");

       }
       catch (ClassNotFoundException e)
       {
           e.printStackTrace();
       }
       System.exit(0);
   }

    /**
     * 获取构造器
     * @param  cl 类名
     */
   private static void printConstructors(Class cl)
   {
       //get all constructors
       Constructor[] constructors = cl.getDeclaredConstructors();

       for(Constructor c : constructors)
       {
           //get constructor'name
           String name = c.getName();
           System.out.print("    ");
           //get constructor's modifier
           String modifiers = Modifier.toString(cl.getModifiers());
           if(modifiers.length() > 0)
           {
               System.out.print(modifiers + " ");
           }
           System.out.print(name + "(");

           //print parameter types
           Class[] paramTyeps = c.getParameterTypes();
           for(int j = 0; j< paramTyeps.length; j++)
           {
               if(j > 0) System.out.print("    ");
           }
           System.out.println(");");
       }
   }

    /**
     * 获取方法
     * @param cl 类名
     */
    private static void printMethods(Class cl)
   {
       //获取所有的方法
       Method[] methods = cl.getDeclaredMethods();
       //循环打印每个方法
       for(Method m : methods)
       {
           //方法的返回类型
           Class retType = m.getReturnType();
           //方法的名字
           String name = m.getName();
           System.out.print("    ");
           //print modifiers, return type and method name
           String modifiers = Modifier.toString(m.getModifiers());
           if(modifiers.length() > 0) System.out.print(modifiers + "  ");
           System.out.print(retType.getName() + " " + name +"(");

           //print parameter types
           Class[] paramTypes = m.getParameterTypes();
           for(int j = 0; j < paramTypes.length; j++)
           {
               if(j > 0) System.out.print(", ");
               System.out.print(paramTypes[j].getName());
           }
           System.out.println(");");
       }
   }

    /**
     * 打印域
     * @param cl 类名
     */
    private static void printFields(Class cl)
   {
       //获取所有的域
       Field[] fields = cl.getDeclaredFields();

       //循环打印每个域
       for(Field f : fields)
       {
           //域的类型（例如：int、float等）
           Class type = f.getType();
           //域的名字
           String name = f.getName();
           System.out.print("    ");
           //打印域的修饰符
           String modifiers = Modifier.toString(f.getModifiers());
           if(modifiers.length() > 0) System.out.print(modifiers + "  ");
           //完整的打印域
           System.out.println(type.getName() + " " + name + ";");
       }
   }
}

class ObjectAnalyzer
{
    private String toString(Object obj)
    {
        Class cl = obj.getClass();
        String r = cl.getName();
        //inspect the fields of this class and all superclasses
        do
        {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            //get the names and values of al fields
            for(Field f : fields)
            {
                if(!Modifier.isStatic(f.getModifiers()))
                {
                    if(!r.endsWith("[")) r+= ",";
                    r += f.getName() + "=";
                    try
                    {
                        Object val = f.get(obj);
                        r += toString(val);
                    }
                    catch (Exception e){e.printStackTrace();}
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }while (cl != null);
        return r;
    }
}