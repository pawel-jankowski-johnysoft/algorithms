package com.johnysoft.quicksort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] nums = {34,4653,6457,456,8768,78,798,634,2,1,67,45,434453,4574,645,4,43};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length -1);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
         int pivot = partition(nums, low, high);
         quickSort(nums, 0, pivot-1);
         quickSort(nums, pivot+1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];

        int greaterThanPivotIndex = low;
        int temp;
        for(int i = low;i<high;i++) {
            if(nums[i] < pivot) {
                temp = nums[greaterThanPivotIndex];
                nums[greaterThanPivotIndex] = nums[i];
                nums[i] = temp;
                greaterThanPivotIndex++;
            }
        }
        nums[high] = nums[greaterThanPivotIndex];
        nums[greaterThanPivotIndex] = pivot;

        return greaterThanPivotIndex;
    }

}
