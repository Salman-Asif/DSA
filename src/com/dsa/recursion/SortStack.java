package com.dsa.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

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


    public Stack<Integer> sortStack(Stack<Integer> stack) {
        if(stack.size() == 1) {
            return stack;
        }

        int topMostElementOfPrev = stack.pop();

        Stack<Integer> sortedSubStack = sortStack(stack);
        return insertAtCorrectPos(sortedSubStack, topMostElementOfPrev);
    }


    private Stack<Integer> insertAtCorrectPos(Stack<Integer> sortedStack, int element) {
        if(sortedStack.isEmpty() || element >= sortedStack.peek()) {
            sortedStack.push(element);
            return sortedStack;
        }

        int topElementPrev = sortedStack.pop();
        Stack<Integer> currentSortedSubStack = insertAtCorrectPos(sortedStack, element);
        currentSortedSubStack.push(topElementPrev);

        return currentSortedSubStack;
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        stack.push(-1);
        stack.push(2);
        stack.push(0);

        SortStack sortStack = new SortStack();
        System.out.println(sortStack.sortStack(stack));


    }
}


class Stack<T> extends ArrayDeque<T> {


    public T pop() {
        return removeFirst();
    }

    public void push(T e) {
        addFirst(e);
    }

    public T peek() {
        return getFirst();
    }

}