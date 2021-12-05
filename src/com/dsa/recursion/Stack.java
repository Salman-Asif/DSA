package com.dsa.recursion;

import java.util.ArrayDeque;


class Stack<T> extends ArrayDeque<T> {

    public void push(T e) {
        addLast(e);
    }

    public T pop() {
        return removeLast();
    }

    public T peek() {
        return peekLast();
    }
}
