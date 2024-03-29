package com.dsa.sliding-window;

import java.io.*;
import java.util.*;

public class Solution{
     long maximumSumSubarray(int k, ArrayList<Integer> arr,int N){
        
        int i =0, j=0;
        long sum = 0, max = Integer.MIN_VALUE;
        
        while(j < N) {
            sum = sum + arr.get(j);
            if(j-i+1 < k) {
                j++;
            } else {
                max = Math.max(max, sum);
                sum = sum - arr.get(i);
                i++;
                j++;
            }
        }
        return max;
    }
}
