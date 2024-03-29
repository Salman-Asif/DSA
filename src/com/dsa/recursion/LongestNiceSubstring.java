package com.dsa.recursion;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {
    public static void main(String[] args) {

    }
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c: arr) set.add(c);

      
        for(int i=0; i< arr.length; i++) {
            char ch = arr[i];
            if(set.contains(Character.toUpperCase(ch)) && set.contains(Character.toLowerCase(ch))) continue;
              String s1 = longestNiceSubstring(s.substring(0, i));
              String s2 = longestNiceSubstring(s.substring(i+1));
              return s1.length() >= s2.length() ? s1:s2;  
        }

         return s;
        
    }
}
