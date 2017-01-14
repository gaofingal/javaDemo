public class BinarySearchDemo {
    public static void main(String args[])
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int searchValue = 8;
        //从arr中查找8的位置
        int index = binarySearch(arr, searchValue);
        System.out.println(index);
    }

    /**
     * 二分法
     * @param arr   查找的数组
     * @param index 需要查找的数据
     * @return      数据在数组的位置
     */
    private static int binarySearch(int[] arr, int index)
    {
        int lowIndex = 0;                   //最小边界
        int heightIndex = arr.length - 1;   //最大边界

        while (lowIndex <= heightIndex)
        {
            int mid = (lowIndex + heightIndex) >>> 1; //中间索引
            int midValue = arr[mid];

            if(index > midValue)
            {
                lowIndex = mid; //往右查找
            }
            else if (index < midValue)
            {
                heightIndex = mid; //往左查找
            }
            else
            {
                return mid;
            }
        }


        return -1;
    }
}
