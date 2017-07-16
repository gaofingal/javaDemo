package simpleFrame;

import java.util.Scanner;

public class Demo {
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size="+size);
        System.out.println("abbreviation="+size.getAbbrevitaion());
        if(size == Size.EXTRA_LANRGE)
        {
            System.out.println("Good job--you paid attention to the _._");
        }

    }
}

enum Size
{
    SMALL("S"),MEDIUM("M"),LARGE("l"),EXTRA_LANRGE("XL");

    Size(String abbreviation){this.abbreviation = abbreviation;}
    public String getAbbrevitaion(){return abbreviation;}

    private String abbreviation;
}
