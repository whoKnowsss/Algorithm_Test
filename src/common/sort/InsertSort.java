package common.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: 11655
 * @Date: 2020/12/7 14:21
 * @Description: 排序算法之一，插入排序
 * 内部排序、稳定
 * 平均时间复杂度：O(n^2)
 * 最好时间复杂度：O(n)
 * 最坏时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 思想：(有序区，无序区)
 * 把无序区的第一个元素插入到有序区的合适的位置。对数组∶比较得少，换得多。
 **/
public class InsertSort {

    //普通插入排序
    public static void insertSort(int[] array) {
        int temp, j = 0;
        for (int i = 1; i < array.length; i++) {    //默认第一个已经有序
            if (array[i] < array[i - 1]) {
                temp = array[i];
                for (j = i; j > 0 && array[j - 1] > temp; j--) {
                    array[j] = array[j - 1];
                }
                array[j] = temp;
            }
        }
    }

//    //折半插入排序
//    public static void binaryInsertSort(int[] array) {
//        int temp, j = 0;
//        for (int i = 1; i < array.length; i++) {    //默认第一个已经有序
//            if (array[i] < array[i - 1]) {
//                temp = array[i];
//                for (j = i; j > 0 && array[j - 1] > temp; j--) {
//                    array[j] = array[j - 1];
//                }
//                array[j] = temp;
//            }
//        }
//    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(a));
        insertSort(a);
        System.out.println(Arrays.toString(a));

    }
}
