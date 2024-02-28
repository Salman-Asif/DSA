package com.dsa.array;

public class LongestSubArraySumK {
    public static void main(String[] args) {
        int[] a = {1,2,3,1,1,1,1};
        System.out.println(Solution.longestSubarrayWithSumK(a, 3));
    }

    static class Solution {
        public static int longestSubarrayWithSumK(int []a, long k) {
            // Write your code here
            int maxLength = 0, curSum=0, left=0, right=0;
            //loop and find sum
            while(left <= right && right < a.length) {

                curSum = curSum + a[right];

                while(curSum > k) {
                    curSum = curSum - a[left];
                    left++;
                }

                if(curSum == k) {
                    System.out.println("left "+left + " right "+right);
                    maxLength = Math.max(maxLength, right-left+1);
                }

                right++;
            }

            return maxLength;
        }
    }

}


