package com.study.test;

import com.study.test.utils.ArrayUtils;

/**
 * 快速排序
 * 平均复杂度O(nlogn),最大O(n^2),最小O(n)
 */
public class QuikeSort {



    public static void sort(int[] array,int start,int end){
        if(array==null||start>=end)return;

        sort(array,start,getFlag(array,start,end)-1);
        sort(array,getFlag(array,start,end)+1,end);

    }


    public static int getFlag(int[] a, int start, int end) {
        int left = start;
        int right = end;
        //选取第一个为目标数字。
        int num = a[start];
        int flag = start;

        while (left < right) {
            //从左找到第一个比目标数字大的。
            while (left < end && a[left] <= num){left++;
            }
            //从右找到第一个比目标数字小的。
            while (right > start&& a[right] >= num){right--;
            }
            //如果begin小于end且值大于，则交互两个数字。

            if(left < right
                   // &&a[left] > a[right]
                    ) {
                swap(a, left, right);
            }else{
                //当left与right碰头后,不再交换
                System.out.println(left);
                System.out.println(right);;
                System.out.println("not swap");
            }
        }
        System.out.println("finish");
        //交换目标数字与上面循环完的数字的位置。
        swap(a, right, flag);
        return right;
    }

    public static void swap(int[] array,int a,int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;

    }




    public static void main(String[] args) {
        int [] array=new int[]{6,3,8,5,2,9,4,7};

        QuikeSort quikeSort=new QuikeSort();
        ArrayUtils.show(array);
        quikeSort.sort(array,0,array.length-1);
        ArrayUtils.show(array);
    }

}
