package map;

import java.util.*;

public class MapDemo {
    public static void main(String[] args)
    {
        Map map = new HashMap();
        map.put("name","fingal");
        map.put("sex","male");
        map.put("hobby","basketball");
        map.put("girlfriend","huhu");

        System.out.println(map);
        //返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
        System.out.println(map.get("girlfriend"));
        //如果此映射包含指定键的映射关系，则返回 true。
        System.out.println(map.containsKey("girlfriend"));
        //如果此映射将一个或多个键映射到指定值，则返回 true
        System.out.println(map.containsValue("huhu"));
        //返回此映射中的键-值映射关系数。
        System.out.println(map.size());
        // 如果此映射未包含键-值映射关系，则返回 true。
        System.out.println(map.isEmpty());

        System.out.println("==========");
        //返回此映射中包含的键的 Set 视图。
        Set mapSet = map.keySet();
        for (Object element : mapSet)
        {
            System.out.println(element + "=" + map.get(element));
        }
        System.out.println("==========");
        //返回此映射中包含的值的 Collection 视图。
        Collection mapValue = map.values();
        for (Object valueEle : mapValue)
        {
            System.out.println(valueEle);
        }
        System.out.println("==========");
        //返回此映射中包含的映射关系的 Set 视图
        Set mapEntry = map.entrySet();
        for (Object obj : mapEntry)
        {
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
