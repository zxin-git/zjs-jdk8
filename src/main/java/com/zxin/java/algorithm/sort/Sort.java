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
    static boolean less(int a, int b){
        return a < b;
    }

    /**
     * 交换
     */
    static void swap(int[] a, int i, int j){
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

    /**
     * 归并排序
     * 递归，二分左右，归并
     */
    public static void mergeSort(int[] a, int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            mergeSort(a, low, mid);
            mergeSort(a,mid+1, high);
            merge(a, low, mid, high);
        }
    }

    /**
     * 左右表归并
     */
    static void merge(int[] a, int low, int mid, int high){
        int[] b = new int[a.length];
        for (int k = low; k <= high; k++) {     //拷贝数组
            b[k] = a[k];
        }

        int i = low;
        int j = mid+1;  //左表和右表的索引初始点
        int k = i;
        while (i <= mid && j <= high)  a[k++] = b[i] < b[j] ? b[i++] : b[j++]; //左右最小的依次填充
        while (i <= mid) a[k++] = b[i++];   //左表未检测完，剩下全复制
        while (j <= high) a[k++] = b[j++];  //右表未检测完，剩下全复制，与左表只会有一个没检测完
    }


    /**
     * 堆排序
     * 左子节点：2*k + 1
     * 右子节点：2*k + 2
     * 父节点：(i-1)/2 整除
     * 例如 n = 7,  父：1，左子：3，右子：4
     */
    public static void heapSort(int[] a, int n){
        buildMaxHeap(a, n);     //构建初始堆
        for (int i = n-1; i > 0; i--) {     //依次选择根，放置最后
            swap(a, i, 0);
            adjustDown(a, 0, i);
        }
    }

    static void buildMaxHeap(int[] a, int n){
        for (int i = n/2 - 1; i >= 0 ; i--) { //n/2 - 1是n-1父节点，倒数第二层最后一个父节点
            adjustDown(a, i , n);
        }
    }

    /**
     * 向下调整堆
     * @param a
     * @param k 父节点
     * @param n 数组长度
     */
    static void adjustDown(int[] a, int k, int n){
        int tmp = a[k];
        for (int i = 2*k+1; i < n; i = 2*i+1) {     // i为左子节点下标
            if(i < n-1 && a[i] < a[i+1]) i++;   //对比左右子节点，i为最大子节点下标
            if(a[i] > tmp){     // 子大则交换
                a[k] = a[i];
                k = i;
            }else{
                break;
            }
        }
        a[k] = tmp;
    }


    public static void main(String[] args) {
        int[] a = {3, 9, 7, 6, 5, 0, 2, 1, 8,4};
        quickSort(a, 0, a.length - 1);
//        insertSort(a, a.length);
//        bubbleSort(a, a.length);
//        selectSort(a, a.length);
//        mergeSort(a, 0, a.length - 1);
//        heapSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
