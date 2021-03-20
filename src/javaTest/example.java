package javaTest;

/**
 * @Author: 11655
 * @Date: 2021/3/11 22:08
 * @Description:
 */
public class example {
    public static void main(String[] args){
        MyThread myThread=new MyThread();
        Thread thread=new Thread(myThread);
        thread.start();
        while(true)
        {
            System.out.println("Main方法在运行");
        }
    }
}

class MyThread implements Runnable{
    public void run(){
        while(true){
            System.out.println("MyThread类的run()方法在运行");
        }
    }
}
