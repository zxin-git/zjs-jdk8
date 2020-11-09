package com.zxin.java.algorithm.sort;

import java.util.List;

/**
 * @author zxin
 */
public class BubbleSort {

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

}
