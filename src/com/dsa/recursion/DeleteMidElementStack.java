package com.dsa.recursion;



public class DeleteMidElementStack {


    /*
    hypothesis:
    deleteMidElement(stack) = stack with mid ele deleted

    induction:
    deleteMidElement(stack-1) = stack with mid ele deleted

    combine:
    deleteMidElement(stack) = deleteMidElement(stack-1) + ??? (Not very intuitive)

    Modified
    Hypothesis:
    deleteElement(stack, midElementIndex) = stack with midElementIndex ele deleted

    induction:
    deleteElement(stack-1, midElementIndex) = stack-1 with midElementIndex ele deleted

    deleteElement(stack, midElementIndex) = deleteElement(stack-1, midElementIndex) + push(topElement of prev stack)

    intermediate:
    deleteElement(stack-m, midElementIndex) = if stack-m.size()-1 == midElementIndex

    base condition:
    deleteElement(1 ele stack, midElementIndex) = return empty Stack
    deleteMidElement(empty stack, midElementIndex) = not valid, so return at 1 element

     */
    public Stack<Integer> deleteMidElement(Stack<Integer> stack) {
        int index = stack.size()/2;
        return deleteMidIndexElement(stack, index);
    }

    private Stack<Integer> deleteMidIndexElement(Stack<Integer> stack, int midElementIndex) {
        if(stack.size() == 1 || stack.size()-1 == midElementIndex) {
            stack.pop();
            return stack;
        }

        Integer topElementPrevStack = stack.pop();
        Stack<Integer> currentSubStack = deleteMidIndexElement(stack, midElementIndex);
        currentSubStack.push(topElementPrevStack);

        return currentSubStack;
    }




    public static void main(String args[]) {
        DeleteMidElementStack deleteMidElementStack = new DeleteMidElementStack();
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(4);
        stack.push(-1);
        stack.push(0);
        stack.push(10);
        stack.push(10);

        System.out.println(deleteMidElementStack.deleteMidElement(stack));

    }

}

