package com.study.test;

import com.study.test.utils.ArrayUtils;

import java.util.ArrayList;

/**
 * 冒泡排序,复杂度O(n^2)
 */
public class BubbleSort {

    public static void sort(int[] array){
        if(array==null)return;
        for(int j=array.length-1;j>0;j--){
            for(int i=0;i<j;i++){
                if(array[i]>array[i+1]){
                    int temp=array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] array=new int[]{6,3,8,5,2,9,4,7};
        ArrayUtils.show(array);
        sort(array);
        ArrayUtils.show(array);

    }


}
