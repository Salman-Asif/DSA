package com.dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class KnapSack {
    List<Integer> weights;
    List<Integer> values;
    int maxBagWeight;


    int knapSackSolution() {
        return knapSack(weights, values, maxBagWeight, weights.size());
    }

    private int knapSack(List<Integer> weights, List<Integer> values, int currentBagWeight, int n) {
        if(n == 0 || currentBagWeight == 0) {
            return 0;
        }

        if(weights.get(n-1) <= currentBagWeight) {
            return Math.max(
                   values.get(n-1) + knapSack(weights, values, currentBagWeight-weights.get(n-1), n-1),
                    knapSack(weights, values, currentBagWeight, n-1)
            );
        } else {
            return knapSack(weights, values, currentBagWeight, n-1);
        }

    }

}


public class KnapSackMain {
    public static void main(String[] args) {
        KnapSack knapSack = new KnapSack();
        List<Integer> weights = new ArrayList<>(Arrays.asList(1,3,4,5));
        List<Integer> values = new ArrayList<>(Arrays.asList(1,4,5,7));
        int maxBagWeight = 7;
        knapSack.weights = weights;
        knapSack.values = values;
        knapSack.maxBagWeight = maxBagWeight;

        System.out.println(knapSack.knapSackSolution());

    }
}