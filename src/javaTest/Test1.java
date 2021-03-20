package javaTest;

import sun.font.StrikeCache;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 11655
 * @Date: 2021/3/3 15:33
 * @Description:
 */
class OuterClass {
    static int x = 10;

    class InnerClass {
        public int myInnerMethod() {
            return x;
        }
    }
}

class I extends Test1 {
    int test() {
        return 1;
    }
}

public class Test1 {
    int a;

    int test() {

        System.out.println(a);
        char cc = 'a';
//        short d=cc;
//        int a=10;
//        long b=a;
        float aaaa = (float) 1.9;
//        int c= (int) b;
        char f[] = new char[5];
        int temp = 1;
        try {
            for (char a :
                    f) {
                System.out.println(a);
            }

            temp = 2;
            return temp;
        } catch (Exception e) {

        } finally {
//            temp = 2;
//            return temp;
            temp = 3;
            return -1;
        }

    }

    static int ap = 8;

    public static void main(String[] args) {
        OuterClass myOuter = new OuterClass();
        OuterClass.InnerClass myInner = myOuter.new InnerClass();
        System.out.println(myInner.myInnerMethod());
        char a = '工';
//        System.out.println(test());

        long start = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start));


        System.out.println(Calendar.getInstance());

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }


        TreeSet<Integer> tree = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 100));
            tree.add(list.get(i));
            map.put(list.get(i), list.get(i));
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        System.out.println(list);
        System.out.println(tree);
        System.out.println(map);
        for (Map.Entry aaa : map.entrySet()) {
            System.out.println(aaa.getKey());
        }
        Queue<String> queue = new LinkedList<>();

    }
}

