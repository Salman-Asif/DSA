package com.dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubSetSum {
    List<Integer> values;
    int sumRequired;

    boolean subSetSumSolution() {
        return subSetSum(values, sumRequired, values.size());
    }

    private boolean subSetSum(List<Integer> values, int currentSum, int n) {
        if(currentSum == 0) {
            return true;
        }
        if(n == 0) {
            return false;
        }

        if(values.get(n-1) <= currentSum) {
            return subSetSum(values, currentSum-values.get(n-1), n-1) || subSetSum(values, currentSum, n-1);
        } else {
            return subSetSum(values, currentSum, n-1);
        }
    }
}


public class SubsetSumMain {
    public static void main(String args[]) {
    SubSetSum subSetSum = new SubSetSum();
    List<Integer> values = new ArrayList<>(Arrays.asList(2, 3, 7, 8, 10));
    subSetSum.values = values;
    subSetSum.sumRequired = 10;
    System.out.println(subSetSum.subSetSumSolution());
}

}
