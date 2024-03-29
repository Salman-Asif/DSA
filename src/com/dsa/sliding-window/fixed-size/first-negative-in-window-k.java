package com.dsa.sliding-window;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	public static int[] firstNegative(int[] arr, int n, int k) {
        // Write your code here.
		Queue<Integer> queue = new ArrayDeque<>();

		int i=0, j=0, firstNegative = 0, pointer=0;
		int[] result = new int[arr.length-k+1]; 

		while(j < arr.length) {
			if(arr[j] < 0) {
				queue.add(arr[j]);
			} 

			if(j-i+1 < k) {
				j++;
			} else {
				if(queue.isEmpty()) {
					result[pointer++] = 0;
				} else {
					firstNegative = queue.peek();
					result[pointer++] = firstNegative;

					if(arr[i] == firstNegative) {
						queue.poll();
					}
				}

				i++;
				j++;
			}
		}
		return result;
	}
}
