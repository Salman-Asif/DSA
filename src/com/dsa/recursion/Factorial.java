package com.dsa.recursion;

public class Factorial {

    /*
    hypothesis:
    factorial(n) = n * n-1 * n-2 ... * 1

    induction:
    factorial(n-1) = n-1 * n-2 * n-3 .... * 1

    combine:
    factorial(n) = n * n-1 * n-2 ... * 1
    factorial(n) = n * factorial(n-1)

    base condition:
    factorial(1) = 1 * factorial(0)
    factorial(0) = 0 * factorial(-1) // but factorial(0) = 1 and factorial(-1) not valid. return in factorial(1).

     */

    /*
    return type is int because computed result is used for computation in 1 level above
     */
    int factorial(int n) {
        if(n==1) {
            return 1;
        }

        return n * factorial(n-1);
    }



    public static void main(String args[]) {
        Factorial factorial = new Factorial();

        System.out.println(factorial.factorial(5));
    }
}
