package io;


import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws Exception
    {
        String path = "abc.txt";
//        write(path);
        read(path);
    }

    private static void write(String path) throws Exception
    {
        RandomAccessFile raf = new RandomAccessFile(path,"rw");
        raf.write("zhangsan".getBytes());
        raf.writeInt(16);

        raf.write("lisi".getBytes());
        raf.writeInt(15);

        raf.write("wanger".getBytes());
        raf.writeInt(18);

        raf.close();
    }

    private static void read(String path) throws Exception
    {
        RandomAccessFile raf = new RandomAccessFile(path, "r");
        raf.seek(12);

        StringBuilder sb = new StringBuilder();

        for (int i=0 ; i<4; i++)
        {
            byte b = raf.readByte();
            sb.append((char)b);
        }
        System.out.println(sb);
        raf.close();
    }
}
