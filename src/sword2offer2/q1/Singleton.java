package sword2offer2.q1;

/**
 * @Author: 11655
 * @Date: 2020/11/22 20:08
 * @Description: 问题1：设计一个类，只能生成该类的一个实例。
 * 思路：懒汉模式+线程安全+双重判空+防止指令重排
 * 懒汉模式：饿汉模式是在类加载的时候就初始化；懒汉模式是在调用的时候再初始化
 * 双重判空：提高效率
 * volatile：
 * 1. 使变量在多个线程间可见（可见性）,强制线程每次从主内存中讲到变量，而不是从线程的私有内存中读取变量，从而保证了数据的可见性。
 * 2. 防止指令重排：非原子操作可能会被拆分成原子操作，在不影响最终结果的情况下，其拆分成的原子操作可能会被重新排列执行顺序。
 * 通过添加synchronized来同步部分代码块，并且通过volatile来防止指令重排
 */

public class Singleton {
    private static volatile Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getInetance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null)
                    singleton = new Singleton(); //new Singleton()是非原子操作，其顺序无法保证
            }
        }
        return singleton;
    }

}
