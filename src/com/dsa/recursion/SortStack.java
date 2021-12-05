package com.dsa.recursion;

import java.util.ArrayDeque;

public class SortStack {


    /*
    Recursion for sort stack
    hypothesis:
    sortStack(stack) =  sorted stack

    induction:
    sort(stack - 1 elements) = sorted stack-1 elements

    combine:
    sort(stack) = sort(stack-1 elements) + insert(topMostElement of prev stack) at correct pos in stack-1

    base condition:
    sort(1 ele stack) = sort(empty stack) + insert(topMostElement of prev stack)  at correct pos
    sort(empty stack) = not valid !!
    therefore return at
    sort(1 ele stack) = return topMostElement of prev stack


    Recursion for insert
    hypothesis:
    insert(sortedStack , element) = sortedStack including element

    induction:
    insert(sortedStack-1, element) = sortedStack-1 elements including element

    combine:
    insert(sortedStack, element) = insert(sortedStack-1, element) + insert topElement of prev stack

    intermedieate:
    if topMostElement is >= sortedStack top most element , push(topMostElement)

    base condition:
    add(1 ele stack , topMostElement) = sorted stack of 2 elements;
    add(empty stack, topMostElement) = push(topMostElement)

     */


    public Stack<Integer> sortStack(Stack<Integer> stackLocal) {
        if(stackLocal.size() == 1) {
            return stackLocal;
        }

        int topMostElementOfPrev = stackLocal.pop();

        Stack<Integer> sortedSubStackLocal = sortStack(stackLocal);
        return insertAtCorrectPos(sortedSubStackLocal, topMostElementOfPrev);
    }


    private Stack<Integer> insertAtCorrectPos(Stack<Integer> sortedStackLocal, int element) {
        if(sortedStackLocal.isEmpty() || element >= sortedStackLocal.peek()) {
            sortedStackLocal.push(element);
            return sortedStackLocal;
        }

        int topElementPrev = sortedStackLocal.pop();
        Stack<Integer> currentSortedSubStackLocal = insertAtCorrectPos(sortedStackLocal, element);
        currentSortedSubStackLocal.push(topElementPrev);

        return currentSortedSubStackLocal;
    }


    public static void main(String args[]) {
        Stack<Integer> stackLocal = new Stack<>();
        stackLocal.push(5);
        stackLocal.push(10);
        stackLocal.push(-1);
        stackLocal.push(2);
        stackLocal.push(0);
        stackLocal.push(1);

        SortStack sortStack = new SortStack();
        System.out.println(sortStack.sortStack(stackLocal));


    }
}
