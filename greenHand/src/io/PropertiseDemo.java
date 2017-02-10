package io;


import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Properties;

public class PropertiseDemo {
    public static void main(String[] args) throws FileNotFoundException
    {
        Properties p = new Properties();

        //设置属性
        p.setProperty("name","fingal");
        p.setProperty("sex","male");
        String username = p.getProperty("name");

        System.out.println(username);

        p.list(new PrintStream("list.txt"));

    }
}
