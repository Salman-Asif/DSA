class Solution {
    public int numberOfSubstrings(String s) {
        int i=0, j=0, count=0;
        Map<Character, Integer> charMap = new HashMap<>();

        while(j < s.length()) {
            charMap.put(s.charAt(j), charMap.getOrDefault(s.charAt(j), 0)+1);

                while(charMap.size() == 3 && j-i >= 2) {
                    count = count + s.length()-j;
                    charMap.put(s.charAt(i), charMap.get(s.charAt(i))-1);
                    if(charMap.get(s.charAt(i)) == 0) {
                        charMap.remove(s.charAt(i));
                    }
                    i++;
                }
            

            j++;
        }
        return count;
    }
}
