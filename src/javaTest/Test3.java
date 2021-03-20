package javaTest;

/**
 * @Author: 11655
 * @Date: 2021/3/11 12:38
 * @Description:
 */


class Subject implements Cloneable {
    String name;    //String引用类型
    int classNum;   //基本数据类型

    public Subject(String name, int classNum) {
        this.name = name;
        this.classNum = classNum;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", classNum=" + classNum +
                '}';
    }
}

// 由于 Object 本身没有实现 Cloneable 接口，所以不重写 clone 方法并且进行调用的话会发生 CloneNotSupportedException 异常。
class School implements Cloneable {
    int age;                       //基本数据类型
    String name;              //String引用类型
    Subject subject;         //类的对象，引用类型



    //深拷贝，循环写clone
    @Override
    protected Object clone() {
        School deepSchool = null;
        try {
            deepSchool = (School) super.clone();
            deepSchool.subject = (Subject) deepSchool.subject.clone();

        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return deepSchool;
    }

    @Override
    public String toString() {
        return "School{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                '}';
    }
}


public class Test3 {
    public static void main(String[] args) {
        School A = new School();
        A.age = 1;
        A.subject = new Subject("Java", 1024);
        A.name = "One";
        System.out.println("原先的A：" + A);

        School B = (School) A.clone();     //clone 浅拷贝
        System.out.println("原先的B：" + B);

        B.age = 2;                                     //改变clone后的age
        B.name = "Two";                              //改变clone后的name
        B.subject.name = "New";              //改变clone后的subject对象的age
        System.out.println("修改后的A：" + A);
        System.out.println("修改后的B：" + B);
    }
}
