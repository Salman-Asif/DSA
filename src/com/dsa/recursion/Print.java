package com.dsa.recursion;

public class Print {


    /*
    hypothesis :
      print(n) = 1 to n
      induction:
      print(n-1) = 1 to n-1

      combine :
      print(n) = print(n-1) + "n";

      base condition:
      print(1) = print(0) + "1" , smallest valid , therefore return here to avoid print(0)....
      print(0) = not valid -> n==0 should never occur , not valid.
      print(-1) = not valid -> should never occur not valid.

     */


    void print1ToN(int n) {

        if(n==1) {
            System.out.print(n+ " ");
            return;
        }


        print1ToN(n-1);
        System.out.print(n+ " ");
    }

    /*
    hypothesis:
    print(n) = n to 1
    Induction:
    print(n-1) = n-1 to 1

    combine:
    print(n) = n n-1 ....1
    print(n)  = "n" + print(n-1)

    base condition:
    print(1) = "1" + print(0) // smallest valid is print(1) , return here to avoid print(0)
     */


    void printNTo1(int n) {
        if(n==1) {
            System.out.print(n + " ");
            return;
        }

        System.out.print(n + " ");
        printNTo1(n-1);
    }


    public static void main(String args[]) {
        int n= 10;

        Print print = new Print();

        print.print1ToN(n);
        System.out.println();
        print.printNTo1(n);

    }
}
