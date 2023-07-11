class Solution {
    public int maxVowels(String s, int k) {
        int i=0, j=0, count = 0, max = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('o');
        set.add('i');
        set.add('u');


        while(j < s.length()) {
            if(set.contains(s.charAt(j))) {
                count++;
            }

            if(j-i+1 < k) {
                j++;
            } else {
                max = Math.max(count, max);
                if(set.contains(s.charAt(i))) {
                    count--;
                }
                i++;
                j++;
            }
        }
        return max;
    }
}
