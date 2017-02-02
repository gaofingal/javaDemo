package StackDemo;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");


        Object element = stack.pop();

        System.out.println(element);
        System.out.println(stack);

    }
}
