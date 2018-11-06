package com.lyyexample.util;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by liuyangyang on 2018/11/6.
 */
public class DateUtil {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = "";
            if(!(input = scanner.nextLine()).isEmpty()){
                System.out.println("输入为："+input);
                TreeSet<Integer> treeSet = new TreeSet<Integer>();
                for (int i=0;i<input.length();i++){
                    treeSet.add(Integer.valueOf(""+input.charAt(i)));
                }
                StringBuffer stringBuffer = new StringBuffer();
                Integer[] integers = new Integer[treeSet.size()];
                treeSet.toArray(integers);
                for(int i=integers.length-1;i>=0;i--){
                    stringBuffer.append(integers[i].intValue());
                }
                System.out.println("结果为："+stringBuffer.toString());
//                for(Integer item : treeSet){
//                    System.out.println("输出顺序："+item.intValue());
//                    stringBuffer.append(item.intValue());
//                }

            }
        }
    }

    private static void Sort(Integer[] a, int left, int right) {
        if(left>=right)
            return;

        int mid = (left + right) / 2;
        //二路归并排序里面有两个Sort，多路归并排序里面写多个Sort就可以了
        Sort(a, left, mid);
        Sort(a, mid + 1, right);
        merge(a, left, mid, right);

    }


    private static void merge(Integer[] a, int left, int mid, int right) {

        int[] tmp = new int[a.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex=left;
        // 逐个归并
        while(left <=mid && r1 <= right) {
            if (a[left] <= a[r1])
                tmp[tIndex++] = a[left++];
            else
                tmp[tIndex++] = a[r1++];
        }
        // 将左边剩余的归并
        while (left <=mid) {
            tmp[tIndex++] = a[left++];
        }
        // 将右边剩余的归并
        while ( r1 <= right ) {
            tmp[tIndex++] = a[r1++];
        }

        //从临时数组拷贝到原数组
        while(cIndex<=right){
            a[cIndex]=tmp[cIndex];
            //输出中间归并排序结果
            System.out.print(a[cIndex]+"\t");
            cIndex++;
        }
    }

    public static void bubbleSort(Integer[] a){
        int tmp ;
        for (int i = 0;i<a.length;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
}
