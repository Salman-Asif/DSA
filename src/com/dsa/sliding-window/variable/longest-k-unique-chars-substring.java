/*
https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
*/

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        int ans = -1;
        int i=0, j=0;
        Map<Character, Integer> map = new HashMap<>();
        
        while(j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            
            if(map.size() > k) {
                while(map.size() > k) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            
            if(map.size() == k) {
                ans = Math.max(ans , j-i+1);
            }
            
            j++;
        }
        return ans;
    }
}
