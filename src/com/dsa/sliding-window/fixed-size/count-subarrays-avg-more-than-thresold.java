class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0,i=0, j=0;
        float avg = 0;
        int count = 0;

        while(j < arr.length) {
            sum = sum + arr[j];

            if(j-i+1 < k) {
                j++;
            } else {
                avg = (float)sum/(float)(j-i+1);
                if(avg >= (float)threshold) {
                    count++;
                }
                sum = sum - arr[i];

                i++;
                j++;
            }
        }
        return count;
    }
}
