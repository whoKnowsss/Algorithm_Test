package Test;

/**
 * @Author: 11655
 * @Date: 2020/12/4
 * @Description:
 */
/* 拷贝构造方法实现浅拷贝 */
public class CopyConstructor {

    public static void main(String[] args) {
        Age a = new Age(20);
        Person p1 = new Person(a, "摇头耶稣", 15);
        Person p2 = new Person(p1);
        System.out.println("p1是" + p1);
        System.out.println("p2是" + p2);
        //修改p1的各属性值，观察p2的各属性值是否跟随变化
        p1.setName("小傻瓜");
        a.setAge(99);
        p1.setHeight(22);
        System.out.println("修改后的p1是" + p1);
        System.out.println("修改后的p2是" + p2);
    }
}

//深拷贝(循环clone)
class PersonDeep implements Cloneable {
    //两个属性值：分别代表值传递和引用传递
    private AgeDeep age;
    private String name;
    private int height;

    public PersonDeep(AgeDeep age, String name, int height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    //拷贝构造方法
    public PersonDeep(PersonDeep p) {
        this.name = p.name;
        this.age = p.age;
        this.height = p.height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AgeDeep getAge() {
        return age;
    }

    public void setAge(AgeDeep age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "PersonDeep{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

    @Override
    protected Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        PersonDeep personDeep = (PersonDeep) obj;
        personDeep.setAge((AgeDeep) personDeep.getAge().clone());
        return obj;
    }
}

class AgeDeep implements Cloneable {
    private int age;

    public AgeDeep(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return getAge() + "";
    }

    @Override
    protected Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}


class Person implements Cloneable {
    //两个属性值：分别代表值传递和引用传递
    private Age age;
    private String name;
    private int height;

    public Person(Age age, String name, int height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    //拷贝构造方法
    public Person(Person p) {
        this.name = p.name;
        this.age = p.age;
        this.height = p.height;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}

class Age {
    private int age;

    public Age(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return getAge() + "";
    }
}