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
 *       从无序区透过交换找出最大元素放到有序去前端
 **/
public class BubbleSort {

    //从小到大冒泡排序
    public static void bubbleSort(int[] list) {
        int temp = 0;
        for (int i = 0; i < list.length-1; i++) {
            for (int j = 0; j < list.length-1-i; j++) {
                if (list[j] < list[i]) {
                    temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                }
            }
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
