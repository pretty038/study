package com.study.leetcode;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。

 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。

 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。

 注意:

 给定 0 和 1 的数量都不会超过 100。
 给定字符串数组的长度不会超过 600。
 示例 1:

 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 输出: 4

 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 示例 2:

 输入: Array = {"10", "0", "1"}, m = 1, n = 1
 输出: 2

 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution474 {

    public static int findMaxForm(String[] strs, int m, int n) {
        if(m<0 || n<0)return -1;
        if(m==0&&n==0)return 0;
        if(strs==null || strs.length==0)return 0;

        int result=0;
        for(int i=0;i<strs.length;i++){
            int m1=m-count0(strs[i]);
            int n1=n-count1(strs[i]);
            String[] newstrs=new String[strs.length-1];
            int f=0;
            for(int a=0;a<strs.length;a++){
                if(a!=i){
                    newstrs[f]=strs[a];
                    f++;
                }
            }
            int subResult=1+findMaxForm(newstrs,m1,n1);
            if(subResult>result)result=subResult;
        }
        return result;
    }


    public static int count0(String s){
        char[] cc=s.toCharArray();
        int cnt0=0;
        for(char c:cc){
            if(c=='0')cnt0++;
        }
        return cnt0;
    }

    public static int count1(String s){
        char[] cc=s.toCharArray();
        int cnt1=0;
        for(char c:cc){
            if(c=='1')cnt1++;
        }
        return cnt1;
    }


    public static int findMaxForm1(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }


    public static int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }

    public static void main(String[] args) {
        String[] strs=new String[]{"0","1101","01","00111","1","10010","0","0","00","1","11","0011"};
        //int result=findMaxForm(strs,63,36);
       //System.out.println(result);
        System.out.println(findMaxForm1(strs,63,36));


    }

}
