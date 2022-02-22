package com.dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class KnapSack {
    List<Integer> weights;
    List<Integer> values;
    int maxBagWeight;
    int[][] knapSackArray;


    int knapSackRecursion() {
        return knapSackRecursion(weights, values, maxBagWeight, weights.size());
    }

    private int knapSackRecursion(List<Integer> weights, List<Integer> values, int currentBagWeight, int n) {
        if(n == 0 || currentBagWeight == 0) {
            return 0;
        }

        if(weights.get(n-1) <= currentBagWeight) {
            return Math.max(
                   values.get(n-1) + knapSackRecursion(weights, values, currentBagWeight-weights.get(n-1), n-1),
                    knapSackRecursion(weights, values, currentBagWeight, n-1)
            );
        } else {
            return knapSackRecursion(weights, values, currentBagWeight, n-1);
        }

    }

    int knapSackMemoization() {
        return knapSackMemoization(weights, values, maxBagWeight, weights.size());
    }

    private int knapSackMemoization(List<Integer> weights, List<Integer> values, int currentBagWeight, int n) {
        if (n == 0 || currentBagWeight == 0) {
            return 0;
        }

        if (knapSackArray[n][currentBagWeight] != -1) {
            return knapSackArray[n][currentBagWeight];
        }

        if (weights.get(n - 1) <= currentBagWeight) {
            int maxValue = Math.max(
                    values.get(n - 1) + knapSackMemoization(weights, values, currentBagWeight - weights.get(n - 1), n - 1),
                    knapSackMemoization(weights, values, currentBagWeight, n - 1)
            );

            knapSackArray[n][currentBagWeight] = maxValue;

            return maxValue;
        } else {
            int maxValue = knapSackMemoization(weights, values, currentBagWeight, n - 1);
            knapSackArray[n][currentBagWeight] = maxValue;
            return maxValue;
        }
    }

        int knapSackTopDown() {
            return knapSackTopDown(weights, values, maxBagWeight, weights.size());
        }

        private int knapSackTopDown(List<Integer> weights, List<Integer> values, int currentBagWeight, int n) {
            int [][] knapSackTD = new int[n+1][currentBagWeight+1];

            for(int i=0 ;i <= n ; i++) {
                for(int j=0; j <= currentBagWeight ;j++) {
                    if(i==0 || j==0 ) {
                        knapSackTD[i][j] =0;
                    }
                    else if(weights.get(i-1) <= j) {
                        knapSackTD[i][j] = Math.max(knapSackTD[i-1][j-weights.get(i-1)] + values.get(i-1), knapSackTD[i-1][j]);
                    } else {
                        knapSackTD[i][j] = knapSackTD[i-1][j];
                    }
                }
            }

            return knapSackTD[n][currentBagWeight];
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
        knapSack.knapSackArray = new int[weights.size()+1][maxBagWeight+1];
        Arrays.stream(knapSack.knapSackArray).forEach(a -> Arrays.fill(a, -1));

        System.out.println(knapSack.knapSackTopDown());

    }
}