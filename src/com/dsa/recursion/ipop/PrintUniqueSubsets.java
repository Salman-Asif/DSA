package com.dsa.recursion.ipop;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class PrintUniqueSubsets {

    public void printUniqueSubsets(String output, String input, Set<String> set) {
        if((input == null || input.length() == 0)) {

            set.add(output);
            return;
        }

        String currentOutputNoSelection = output;
        String currentOutputWithSelection = output + input.charAt(0);
        String nextLevelInput = input.substring(1);

        printUniqueSubsets(currentOutputNoSelection, nextLevelInput, set);
        printUniqueSubsets(currentOutputWithSelection, nextLevelInput, set);

    }


    public static void  main(String[] args) {
        String input = "aac";
        String output = "";

        PrintUniqueSubsets printUniqueSubsets = new PrintUniqueSubsets();
        Set<String> set = new HashSet<>();
   
        printUniqueSubsets.printUniqueSubsets(output, input, set);

        System.out.println(set);
    }


}
