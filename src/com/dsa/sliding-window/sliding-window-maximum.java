/*
Hint: Use sliding window and Monotonic queue (store elements in deque in decreasing order)
*/


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i=0, j=0, max = Integer.MIN_VALUE;
        int[] result = new int[nums.length-k+1];
        if(k == 1) return nums;
        if(k == nums.length) {
            for(int ele: nums) {
                max = Math.max(max, ele);
            }
            result[0] = max;
            return result;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int length = nums.length;
        int pointer = 0;

        while(j < length) {
                while(!queue.isEmpty() && nums[j] > queue.peekLast()) {
                    queue.pollLast();
                }
                queue.add(nums[j]);

            if(j-i+1 < k) {
                j++;
            } else {
                result[pointer++] = queue.peekFirst();
                if(nums[i] == queue.peekFirst()) queue.pollFirst();
                i++;
                j++;
            }
        }
        return result;
    }
}
