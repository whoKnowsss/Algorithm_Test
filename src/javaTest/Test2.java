package javaTest;

/**
 * @Author: 11655
 * @Date: 2021/3/10 16:49
 * @Description:
 */

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import util.TreeNode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        TreeSet<String> tree = new TreeSet<>();
        for (long i = 1; i <= n; i++) tree.add(i + "");

        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher match = pattern.matcher("[1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 3, 4, 5, 6, 7, 8, 9]");
        Pattern.matches("\\d", "[1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 3, 4, 5, 6, 7, 8, 9]");
        match.group(0);
        System.out.println(tree);
    }



}
