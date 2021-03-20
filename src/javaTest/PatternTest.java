package javaTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 11655
 * @Date: 2021/3/10 3:34
 * @Description:
 */
public class PatternTest {
    public static void main(String[] args) {
        String line = "This order was placed for QT3000! OK?";
        String patternRule = "(\\D*)(\\d+)(.*)";

        Pattern pattern = Pattern.compile(patternRule);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            System.out.println("");
        }

        String REGEX = "^cat";
        String INPUT = "cat cat cat cattie cat";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;

        while (m.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
        }
    }
}
