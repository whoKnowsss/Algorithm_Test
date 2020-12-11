package common.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author: 11655
 * @Date: 2020/12/7 14:21
 * @Description: 排序算法之一，归并排序
 * 外部排序、稳定
 * 平均时间复杂度：O(nlogn)
 * 最好时间复杂度：O(nlogn)
 * 最坏时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 把数据分为两段，从两段中逐个选最小的元素移入新数据段的末尾。可从上到下或从下到上进行。
 **/
public class MergeSort {
    //归并排序，递归版
    //归并排序其实就分为两部分：分解，将序列每次折半划分；合并，将划分后的序列段凉凉合并后排序
    public static int[] mergeSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int[] tempArray = new int[array.length];  //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        mSort(array, tempArray, left, right);
        return array;
    }

    private static void mSort(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {
            //左边排序
            mSort(array, tempArray, left, (left + right) / 2);
            //右边排序
            mSort(array, tempArray, (left + right) / 2 + 1, right);
            //将两个有序子数组合并
            merge(array, tempArray, left, (left + right) / 2, right);
        }
    }

    private static void merge(int[] array, int[] tempArray, int left, int mid, int right) {
        int i, j, k;
        for (i = left, j = mid + 1, k = 0; i <= mid && j <= right; ) {
            if (array[i] < array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }
        while (i <= mid) {
            tempArray[k++] = array[i++];
        }
        while (j <= right) {
            tempArray[k++] = array[j++];
        }
        k = 0;
        while (left <= right) {
            array[left++] = tempArray[k++];
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(mergeSort(a)));

    }
}
