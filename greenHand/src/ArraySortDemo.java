import java.util.Arrays;

public class ArraySortDemo {
    public static void main(String args[])
    {
        int[] arr = {4,2,1,5,7,3,-4,-8,-1};
        System.out.println(Arrays.toString(arr));

//        bubbleSort(arr);
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序
    private static void bubbleSort(int[] arr)
    {
        int temp;
        for(int count = 1; count<arr.length; count++)
        {
            for(int i = 0; i < arr.length -1; i++)
            {
                if(arr[i] > arr[i+1])
                {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
    //选择排序
    private static void selectionSort(int[] arr)
    {
        int temp;
        for(int count = 1; count < arr.length; count++)
        {
            for (int index = count; index < arr.length; index++)
            {
                if(arr[count - 1] > arr[index])
                {
                    temp = arr[count - 1];
                    arr[count - 1] = arr[index];
                    arr[index] = temp;
                }
            }
        }
    }




}
