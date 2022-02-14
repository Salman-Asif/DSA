package com.dsa.recursion.ipop;

public class PrintSubsets {

    public void printSubsets(StringBuilder input, StringBuilder output) {
        if(input.length() == 0) {
            System.out.println(output); return;
        }

        StringBuilder currentOutputNoSelection = new StringBuilder(output);
        StringBuilder currentOutputWithSelection = new StringBuilder(output);
        currentOutputWithSelection.append(input.charAt(0));
        input.deleteCharAt(0);

        printSubsets(new StringBuilder(input), currentOutputNoSelection);
        printSubsets(new StringBuilder(input), currentOutputWithSelection);
    }


    public static void main(String[] args) {
        StringBuilder input = new StringBuilder("aaa");

        StringBuilder output = new StringBuilder("");

        PrintSubsets printSubsets = new PrintSubsets();
        printSubsets.printSubsets(input, output);

    }

}
