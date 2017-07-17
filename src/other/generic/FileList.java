package other.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 泛型使用的用例，在向Class引用添加泛型语法的时候，
 * 仅仅是为了提供编译期类型检查，因此如果你操作有误的话，
 * 在编译时，就会立刻报错发现这一点。使用普通的Class引用，
 * 如果你犯错了，那么知道运行时，你才能发现
 */

class CountInteger
{
    private static Long counter;
    private final Long id = counter++;
    public String toString()
    {
        return Long.toString(id);
    }

}

public class FileList<T>{
    private Class<T> type;
    public FileList(Class<T> type)
    {
        this.type = type;
    }

    public List<T> create(int nELement)
    {
        List<T> result = new ArrayList<T>();
        try{
            for (int i = 0; i < nELement; i++) {
                result.add(type.newInstance());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        FileList<CountInteger> fileList = new FileList<>(CountInteger.class);
        System.out.println(fileList.create(15));
    }
}
