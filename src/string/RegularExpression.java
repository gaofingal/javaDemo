package string;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;


//正则表达式的练习使用
public class RegularExpression {
    @Test
    //正则表达式中的split
    public void testSplit(){
        String input = "This , is unusual , user of , exclamation points";
        String[] matcher = Pattern.compile(",").split(input);
        System.out.println(Arrays.toString(matcher));
    }

    @Test
    //通过正则从日志中获取信息
    public void testThreatAnalyzer()
    {
        String threatData = "58.27.82.161@02/10/2005\n"+
                            "58.27.82.161@02/10/2005\n"+
                            "58.27.82.161@02/10/2005\n"+
                            "58.27.82.161@02/10/2005\n"+
                            "58.27.82.161@02/10/2005\n";
        Scanner scanner = new Scanner(threatData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@(\\d{2}/\\d{2}/\\d{4})";
        while (scanner.hasNext(pattern))
        {
            scanner.next(pattern);
            MatchResult matchResult = scanner.match();
            String ip = matchResult.group(1);
            String date = matchResult.group(2);
            System.out.printf("Threat on %s from %s \n",ip,date);
        }
    }
}
