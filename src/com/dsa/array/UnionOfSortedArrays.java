package com.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class UnionOfSortedArrays {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {3, 3, 4, 5, 6, 7, 8, 9, 9, 9};
        int[] b = {2,4,10,10};
        List<Integer> integers = Solution.sortedArray(a, b);


        integers.forEach(ele -> System.out.print(ele+" "));

    }

    static class Solution {
        public static List< Integer > sortedArray(int []a, int []b) {
            // Write your code here
            List<Integer> resultList = new ArrayList<>();

            int aIndex = 0, bIndex = 0;
            while(aIndex < a.length && bIndex < b.length) {
                if(a[aIndex] <= b[bIndex]) {
                    if(resultList.isEmpty() || resultList.get(resultList.size()-1) != a[aIndex])
                        resultList.add(a[aIndex]);

                    aIndex++;
                } else {
                    if(resultList.isEmpty() || resultList.get(resultList.size()-1) != b[bIndex])
                        resultList.add(b[bIndex]);
                    bIndex++;
                }
            }

            while(aIndex < a.length) {
                if(resultList.isEmpty() || resultList.get(resultList.size()-1) != a[aIndex])
                    resultList.add(a[aIndex]);
                aIndex++;
            }

            while(bIndex < b.length) {
                if(resultList.isEmpty() || resultList.get(resultList.size()-1) != b[bIndex])
                    resultList.add(b[bIndex]);
                bIndex++;
            }

            // resultList.forEach(System.out::println);
            return resultList;
        }

        private static int incrementUntilDifferent(int[] arr, int index, int temp) {
            while(index < arr.length && arr[index] == temp) index++;
            return index;
        }
    }
}


