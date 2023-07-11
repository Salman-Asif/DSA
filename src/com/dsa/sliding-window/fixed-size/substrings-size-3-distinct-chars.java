class Solution {
    public int countGoodSubstrings(String s) {
        int i=0, j=0, count = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);

            if(j-i+1 < 3) {
                j++;
            } else {
                if(map.size() == 3) {
                    count++;
                }

                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }

                i++;
                j++;
            }
            
        }

        return count;
    }
}
