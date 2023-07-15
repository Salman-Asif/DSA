/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        if(s.length() == 0 || s.length() == 1) return s.length();

        char ch = s.charAt(j);
        char startCh = s.charAt(i);

        //start sliding window
        while( j < s.length()) {
            ch = s.charAt(j);
            //put in map
            map.put(ch, map.getOrDefault(ch, 0)+1);
           
            //if map size < window size 
            if(map.size() < j-i+1) {
                // keep reducing chars from window start until map size == window size ,
                while(map.size() < j-i+1) {
                    startCh = s.charAt(i);
                    map.put(startCh, map.getOrDefault(startCh, 0)-1);

                    //if char is 0 remove from map
                    if(map.get(startCh) == 0) {
                        map.remove(startCh);
                    }
                    i++;
                }
            }

             //if  map size == window size 
                if(map.size() == j-i+1) {
                    // update max string length
                    max = Math.max(max, j-i+1);
                }

          // window size increase
          j++;

        }
        return max;
    }
}
