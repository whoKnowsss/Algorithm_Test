package common.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: 11655
 * @Date: 2020/12/8 11:205
 * @Description: 排序算法之一，快速排序
 * 内部排序、不稳定
 * 平均时间复杂度：O(nlogn)
 * 最好时间复杂度：O(nlogn)
 * 最坏时间复杂度：O(n2)
 * 空间复杂度：O(logn)
 * （小数，基准元素，大数)
 * 在区间中随机挑选一个元素作基准，将小于基准的元素放在基准之前，大于基准的元素放在基准之后，再分别对小数区与大数区进行排序。
 * <p>
 * 快速排序的最坏运行情况是 O(n²)，比如说顺序数列的快排。但它的平摊期望时间是 O(nlogn)，
 * 且 O(nlogn) 记号中隐含的常数因子很小，比复杂度稳定等于 O(nlogn) 的归并排序要小很多。
 * 所以，对绝大多数顺序性较弱的随机数列而言，快速排序总是优于归并排序。
 **/
public class QuickSort {
    public static int[] quickSort(int[] array) {
        int[] temp = Arrays.copyOf(array, array.length);  //不改变原数组
        return sort(temp, 0, temp.length - 1);
    }

    private static int[] sort(int[] array, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(array, start, end);
            sort(array, start, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
        return array;
    }

    private static void swap(int[] array, int one, int two) {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }

    //快速排序的核心部分：确定关键值在数组中的位置，以此将数组划分成左右两区间，关键值游离在外。（返回关键值应在数组中的下标）
    private static int partition(int[] array, int start, int end) {
        int pivot = start;  //设定基准值
        int index = pivot + 1;
        for (int i = index; i <= end; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, index);
                index++;
            }
        }
        index--;
        swap(array, index, pivot);
        return index;
    }




    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = random.nextInt(100);
        }


        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(quickSort(a)));

    }
}
