package leetcode.sort.easy;

import java.util.Arrays;

/**
 * @Author: 11655
 * @Date: 2020/12/9 13:59
 * @Description: https://leetcode.com/problems/shuffle-string/
 */
public class ShuffleString {
    public static String restoreString1(String s, int[] indices) {
        char[] temp = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            temp[indices[i]] = s.charAt(i);
        }
        return String.valueOf(temp);
    }


    public static String restoreString2(String s, int[] indices) {
        return String.valueOf(sort(s.toCharArray(), indices, 0, indices.length - 1));
    }

    private static char[] sort(char[] tempArray, int[] indices, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(tempArray, indices, start, end);
            sort(tempArray, indices, start, partitionIndex - 1);
            sort(tempArray, indices, partitionIndex + 1, end);
        }
        return tempArray;
    }

    private static int partition(char[] tempArray, int[] indices, int start, int end) {
        int pivot = start;
        int index = pivot + 1;
        for (int i = index; i <= end; i++) {
            if (indices[i] < indices[pivot]) {
                swap(tempArray, indices, i, index);
                index++;
            }
        }
        index--;
        swap(tempArray, indices, pivot, index);
        return index;
    }

    private static void swap(char[] tempArray, int[] indices, int start, int end) {
        char tempc = tempArray[start];
        tempArray[start] = tempArray[end];
        tempArray[end] = tempc;

        int temp = indices[start];
        indices[start] = indices[end];
        indices[end] = temp;
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(restoreString1(s, indices).toString());
        System.out.println(Arrays.toString(indices));
    }
}
