package com.zxin.java.algorithm.sort;

import java.util.List;

/**
 * 冒泡排序
 * @author zxin
 */
public class BubbleSort {

    @Deprecated
    public static int[] sort(int[] array){
        int n = array.length;
        for(int i = 1; i <= n - 1; i++){            //排第几个元素 头为1  1 -> n-1
            for(int j = 1; j <= n - i; j++){        //共对比几次（从尾往头）(i-1)为已排序  1 -> n - i
                int a = n - j;
                if(array[a] < array[a - 1]){
                    int tmp = array[a -1];
                    array[a -1] = array[a];
                    array[a] = tmp;
                }
            }
        }
        return array;
    }




    public static void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public void merge(int[] a1, int[] a2){
        int l1 = a1.length;
        int l2 = a2.length;
        int[] a = new int[l1 + l2];
        for (int i = 0, j1=0, j2=0; i < a.length; i++) {
            if(j1 >= l1) a[i] = a2[j2++];
            if(j2 >= l2) a[i] = a1[j1++];
            if(a1[j1] <= a2[j2]){
                a[i] = a1[j1++];
            }else{
                a[i] = a2[j2++];
            }
        }
    }

}
