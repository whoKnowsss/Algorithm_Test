package Test;

/**
 * @Author: 11655
 * @Date: 2021/3/18 15:42
 * @Description:
 */
class Father {

    public Father() {
        System.out.println("Father creats: null");
    }

    public Father(int a) {
        System.out.println("Father creats: " + a);
    }
}
class Son extends Father{

//    public Son() {
//        System.out.println("Son creats: null");
//    }

    public Son(int a) {
        super();
        System.out.println("Son creats: " + a);
    }
}
public class ExtendsTest {
    public static void main(String[] args) {
        Father father=new Son(5);
    }

}
