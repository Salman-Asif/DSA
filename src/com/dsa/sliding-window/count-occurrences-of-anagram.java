/*
put all chars in map(wordMap) , the size of map is number of distinct chars to match (yetToMatchChars)
whenever char in big string is present in wordMap, decrement it, if that char map value becomes 0, decrement yetToMatchChars
whenever char is moving outside the window and present in map , it would have been decrement in previous window so we put it back
by incrementing yetToMatchChars.
*/


class Solution {

    int search(String pat, String txt) {
        // code here
        
        Map<Character, Integer> wordMap = new HashMap<>();
        
        for(char ch: pat.toCharArray()) {
            wordMap.put(ch, wordMap.getOrDefault(ch,0)+1);
        }
        
       // printMap(wordMap);
        
        int i=0,j=0, k = pat.length(), count=0, yetToMatchChars = wordMap.size();
        int length = txt.length();
        char currChar = txt.charAt(0);
        
        while(j < length) {
            currChar = txt.charAt(j);

            //currChar is present in wordMap so its a match and decrease its value, if not present ignore
            //if the value in wordMap becomes 0  , then that char is fully matched so yetToMatchChars decrease by 1
            if(wordMap.containsKey(currChar)) {
                wordMap.put(currChar, wordMap.get(currChar)-1);
                if(wordMap.get(currChar) == 0) {
                    yetToMatchChars--;
                }
            }
            
                if(j-i+1 < k) {
                    j++;
                } else {
                    if(yetToMatchChars == 0) {
                        count++;
                    }

                  //window start is sliding, so if window start char is present in wordMap , 
                  //increase by 1 because that char is outside the window now and it would have matched previous window and
                  //should be undone.
                    if(wordMap.containsKey(txt.charAt(i))) {
                        if(wordMap.get(txt.charAt(i)) == 0) {
                            yetToMatchChars++;
                        }
                        wordMap.put(txt.charAt(i), wordMap.get(txt.charAt(i)) + 1);  
                    }
                    
                    j++;
                    i++;
                }
        }
        
        return count;
        
    }
    
    private void printMap(Map<Character, Integer> map) {
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
