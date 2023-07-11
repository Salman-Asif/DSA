class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i=0,j=0;
        Set<Integer> set = new HashSet<>();

        while(j< nums.length) {
            if(set.contains(nums[j])) return true;

            set.add(nums[j]);

           if(j-i == k) {
               set.remove(nums[i]);
               i++;
           }

           j++;
        }

        return false;
    }
}
