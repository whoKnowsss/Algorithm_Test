package Test;

import java.util.Stack;

/**
 * @Author: 11655
 * @Date: 2021/3/18 16:09
 * @Description:
 */
abstract class AA {
      static void AA(){}
}

abstract class BB {

}

class DD extends AA {

}

interface A {
    void a();
}

class B implements A {
    void b() {

    }

    @Override
    public void a() {
        String a = "";
    }
}

interface C {
    void C();
}

interface D extends C {

}

public class AbstractTest {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        System.out.println(g.equals(a+h));
    }
}
