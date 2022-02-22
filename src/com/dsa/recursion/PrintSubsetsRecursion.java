package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsetsRecursion {


    /*

    hypothesis:
    printSubsets(string) = return all subsets of string

    induction:
    printSubsets(string-1) = return all subsets of string-1

    combine:
    printSubsets(string) = printSubsets(string-1) + generateSubset(last char)
     */

    public List<StringBuilder> printSubsets(StringBuilder input) {
        if(input.length() == 1) {
            List<StringBuilder> set = new ArrayList<>();
            set.add(new StringBuilder(""));
            set.add(input);
            return set;
        }

        List<StringBuilder> prevSubsets = printSubsets(new StringBuilder(input.substring(0, input.length()-1)));
        return generateSubset(prevSubsets, input.charAt(input.length()-1));
    }

    /*
    hypothesis:
    generateSubset(prevSubset, lastChar) = return newSubset

    induction:
    generateSubset(prevSubset-1, lastChar) = return newSubset-1

     */
    private List<StringBuilder> generateSubset(List<StringBuilder> prevSubset, char lastChar) {
        List<StringBuilder> newSubsets = new ArrayList<>();
        for (StringBuilder s : prevSubset) {
            newSubsets.add(new StringBuilder(lastChar + s.toString()));
        }
        newSubsets.addAll(prevSubset);
        return  newSubsets;
    }




    public static void main(String[] args) {
        PrintSubsetsRecursion printSubsetsRecursion = new PrintSubsetsRecursion();
        StringBuilder input = new StringBuilder();
        input.append(new char[]{'a','b','c'});

        System.out.println(input);
        //printSubsets.printSubsets(input);

        System.out.println(printSubsetsRecursion.printSubsets(input));
    }

}
