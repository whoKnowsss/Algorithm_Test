package common.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: 11655
 * @Date: 2020/12/4
 * @Description: 排序算法之一，冒泡排序
 * 内部排序、稳定
 * 平均时间复杂度：O(n^2)
 * 最好时间复杂度：O(n)
 * 最坏时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 思想：(无序区，有序区)
 * 从无序区透过交换找出最大元素放到有序去前端
 **/
public class BubbleSort {

    //从小到大冒泡排序
    public static void bubbleSort(int[] array) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {    //遍历 array.length - 1 躺就够了
            flag = false;
            for (int j = 1; j < array.length - i; j++) {  //前面的是无序区，后面的已经有序，不用遍历
                if (array[j] < array[j - 1]) {          //冒泡，大的移到末尾
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;  //一次都没交换 说明已经顺序，最好时间复杂度
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(a));
        bubbleSort(a);
        System.out.println(Arrays.toString(a));

    }
}
