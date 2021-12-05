package com.dsa.recursion;

public class ReverseStackRecursion {

    /*
    Reverse
    hypothesis:
    reverse(stack) =  reversed stack

    induction:
    reverse(stack-1) = reverse stack-1

    combine:
    reverse(stack) = reverse(stack-1) + insertBottom(reversedStack-1, topMostPrevElement)

    base condition:
    reverse(1 ele stack) = return stack

    InsertBottom
    hypothesis:
    insertBottom(stack, element) = return stack along with element at bottom

    induction:
    insertBottom(stack-1, element) = return stack-1 along with element at bottom

    combine:
    insertBottom(stack, element) = insert(stack-1, element) +  push(topMostPrevElement)

    base condition:
    insertBottom(1 ele stack, element) = return 1 ele stack along with element at bottom
    insertBottom(empty stack, element) = return element as stack (Base condition !!)


     */

    public Stack<Integer> reverse(Stack<Integer> stack) {
        if(stack.size() == 1) {
            return stack;
        }

        int topMostPrevElement = stack.pop();
        Stack<Integer> currentReversedSubStack = reverse(stack);
        return insertBottom(currentReversedSubStack, topMostPrevElement);
    }

    private Stack<Integer> insertBottom(Stack<Integer> stack, int element) {
        if(stack.isEmpty()) {
            stack.push(element);
            return stack;
        }

        int topMostPrevElement = stack.pop();
        Stack<Integer> currentSubStackWithElementAtBottom = insertBottom(stack, element);

        currentSubStackWithElementAtBottom.push(topMostPrevElement);
        return currentSubStackWithElementAtBottom;
    }


    public static void main(String[] args) {
        ReverseStackRecursion reverseStack = new ReverseStackRecursion();
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(9);
        stack.push(8);
        stack.push(7);
        System.out.println(stack);
        System.out.println();
        System.out.println();
        System.out.println(reverseStack.reverse(stack));

    }

}



