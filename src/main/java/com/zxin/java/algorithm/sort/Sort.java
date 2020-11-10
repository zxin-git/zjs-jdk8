package com.zxin.java.algorithm.sort;

import java.util.Arrays;

/**
 * 标准排序方式
 * 参见严蔚敏《数据结构与算法》
 * @author zxin
 */
public class Sort {

    /**
     * less than 小于
     */
    public static boolean less(int a, int b){
        return a < b;
    }

    /**
     * 交换
     */
    public static void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    /**
     * 冒泡排序
     * @param a
     */
    public static void bubbleSort(int[] a, int n){
        for(int i = 0; i < n-1; i++){       //冒第i个，共n-1次趟
            boolean flag = false;
            for (int j = n-1; j > i; j--) {     // 从最后，已冒泡i-1，共n-i次比较
                if(a[j] < a[j-1]){
                    swap(a, j, j-1);
                    flag = true;
                }
            }
            if (flag == false)
                return ;    // 本趟冒泡无任何交换，说明已有序
        }
    }

    /**
     * 快速排序
     * @param a
     */
    public static void quickSort(int[] a, int low, int high){
        if(low < high){
            int pivotPos = partition(a, low, high);
            quickSort(a, low, pivotPos-1);
            quickSort(a, pivotPos+1, high);
        }
    }

    /**
     * 分区方法
     * @return 枢纽基准值pivot的位置
     */
    static int partition(int[] a, int low, int high){
        int pivot = a[low]; //low位置空了出来
        while(low < high){
            while (low < high && a[high] >= pivot) high--; // 从高位，找下一个小的，置于low位置，high空置了
            a[low] = a[high];
            while (low < high && a[low] <= pivot) low++; // 从低位，找下一个大的，置于high位置，low空置了
            a[high] = a[low];
        }
        a[low] = pivot; //最终low == high
        return low;
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] a, int n){
        for (int i = 1; i < n; i++) {
            if(a[i] < a[i-1]){  //比前驱大，则不用变化
                int tmp = a[i];
                int j;
                for (j = i-1; j >= 0 && tmp < a[j]; j--) { //依次比对后移
                    a[j+1] = a[j];
                }
                a[j+1] = tmp;
            }
        }
    }

    /**
     * 选择排序
     */
    public static void selectSort(int[] a, int n){
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (a[j] < a[min])
                    min = j;
                if(min != i)
                    swap(a, i, min);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 9, 7, 6, 5, 0, 2, 1, 8, 4};
//        quickSort(a, 0, a.length - 1);
//        insertSort(a, a.length);
//        bubbleSort(a, a.length);
        selectSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
