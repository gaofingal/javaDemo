package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileDemo {
    public static void main(String[] agrs) throws FileNotFoundException
    {
        //在window和Unix系统中表示目录的字符
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);

        //
        PrintWriter pw = new PrintWriter("demo.txt");
        pw.write("我是奋斗青年");
        pw.close();;
    }
}
