package com.dsa.array;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SecondLargestSecondSmallest {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4};

        Solution.getSecondOrderElements(arr.length, arr);
    }


    class Solution {
        public static int[] getSecondOrderElements(int n, int []a) {
            // Write your code here.

            int secondLargestEle = Integer.MIN_VALUE;
            int largestEle = Integer.MIN_VALUE;

            int[] ans = {findSecondLargest(a), findSecondSmallest(a)};
            return ans;
        }

        private static int findSecondSmallest(int[] a) {
            int smallestEle = Integer.MAX_VALUE;
            int secondSmallestEle = Integer.MAX_VALUE;

            for(int i=0; i< a.length;i++) {
                if(a[i] < smallestEle) {
                    secondSmallestEle = smallestEle;
                    smallestEle = a[i];
                } else if(a[i] < secondSmallestEle && a[i] != secondSmallestEle) {
                    secondSmallestEle = a[i];
                }
            }
            return secondSmallestEle;
        }

        private static int findSecondLargest(int[] a) {
            int largestEle = Integer.MIN_VALUE;
            int secondLargestEle = Integer.MIN_VALUE;

            for(int i=0; i< a.length; i++) {
                if(a[i] > largestEle) {
                    secondLargestEle = largestEle;
                    largestEle = a[i];
                } else if(a[i] > secondLargestEle && a[i] != secondLargestEle) {
                    secondLargestEle = a[i];
                }
            }

            Predicate<Integer> predicate = ele -> ele == 0;

            IntStream.range(0, a.length)
                    .filter(i -> predicate.test(a[i]))
                    .findFirst().orElse(a.length);

            return secondLargestEle;
        }
    }


}


