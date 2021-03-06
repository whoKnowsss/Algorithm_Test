package common.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: 11655
 * @Date: 2020/12/4
 * @Description: 排序算法之一，选择排序
 * 内部排序、不稳定
 * 平均时间复杂度：O(n^2)
 * 最好时间复杂度：O(n^2)
 * 最坏时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 思想：(有序区，无序区)
 * 在无序区里找一个最小的元素跟在有序区的后面。对数组:比较得多，换得少。
 **/
public class SelectionSort {
    public static void selectionSort(int[] array) {
        int minIndex, temp = 0;
        for (int i = 0; i < array.length; i++) {   //n个数只需要遍历n-1趟
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex])  // 寻找最小的数
                    minIndex = j;                 // 将最小数的索引保存
            }
            if (minIndex != i) {                 // 交换
                temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
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
        selectionSort(a);
        System.out.println(Arrays.toString(a));

    }
}
