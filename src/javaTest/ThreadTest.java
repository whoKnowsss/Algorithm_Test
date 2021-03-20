package javaTest;

import com.sun.org.apache.xalan.internal.utils.FeatureManager;

import java.util.concurrent.Callable;

/**
 * @Author: 11655
 * @Date: 2021/3/11 22:05
 * @Description:
 */
class RunnableDemo implements Runnable {
    private Thread thread;
    private String threadName;

    public RunnableDemo(String name) {
        this.threadName = name;
        System.out.println("实现Runnable接口的多线程方式： " + this.threadName + " 处于新建状态。");
    }

    @Override
    public void run() {
        System.out.println("实现Runnable接口的多线程方式： " + this.threadName + " 处于运行状态。");
        try {
            for (int i = 1; i <= 100; i++) {
                System.out.println("实现Runnable接口的多线程方式： " + this.threadName + " 打印： " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("实现Runnable接口的多线程方式： " + this.threadName + " 被中断！！");
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, this.threadName);
            thread.start();
            System.out.println("实现Runnable接口的多线程方式： " + this.threadName + " 处于就绪状态。");
        }
    }
}

class ThreadDemo extends Thread {
    private Thread thread;
    private String threadName;

    public ThreadDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("继承Thread类实现的多线程方式： " + this.threadName + " 处于新建状态。");
    }

    public void run() {
        System.out.println("继承Thread类实现的多线程方式： " + this.threadName + " 处于运行状态。");
        try {
            for (int i = 1; i <= 100; i++) {
                System.out.println("继承Thread类实现的多线程方式： " + this.threadName + " 打印： " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("继承Thread类实现的多线程方式： " + this.threadName + " 被中断！！");
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, this.threadName);
            thread.start();
            System.out.println("继承Thread类实现的多线程方式： " + this.threadName + " 处于就绪状态。");
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        RunnableDemo thread1 = new RunnableDemo("Thread1");
        ThreadDemo thread2 = new ThreadDemo("Thread2");
        thread1.start();
        thread2.start();


    }
}
