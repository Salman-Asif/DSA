package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayRecursion {

    /*
    hypothesis:
    sort(array elements) = sorted array elements

    induction:
    sort(array-1 elements) =  sorted till array-1 elements
    sorted(array) = sort(array-1 elements) + insert(last element)

    base condition:
    sort(1 element) = return same element
    sort(o elements) = not valid;


     */

    public List<Integer> sort(List<Integer> numbers) {
        return sortArray(numbers);
    }

    private List<Integer> sortArray(List<Integer> numbers) {
        if(numbers.size() == 1) {
            return numbers;
        }

        int lastElement = numbers.remove(numbers.size()-1);

        List<Integer> sortedNumbers = sortArray(numbers);
        return  insertElementInSortedListRecursion(sortedNumbers, lastElement);
    }

    /*
    hypothesis:
    insert(sorted array, element) = insert at correct pos to sort array

    induction:
    insert(sorted array-1, element) = insert at correct post to sort array-1

    combine:
    insert(sorted array, element) = insert(sort array-1, element) + insert last array element

    intermediate/other condition:
    insert element in sorted array/sub array at right most pos only.

    base condition:
    insert(1st ele arr, element) = insert(empty array, element) + insert 1st arr ele
    insert(empty array, element) = insert(empty array - 1, element)[NOT VALID] + insert ele , return here
     */

    private List<Integer> insertElementInSortedListRecursion(List<Integer> sortedNumbers, int element) {

        if(sortedNumbers.isEmpty() || element >= sortedNumbers.get(sortedNumbers.size()-1)) {
            sortedNumbers.add(element);
            return sortedNumbers;
        }

        int lastElement = sortedNumbers.remove(sortedNumbers.size()-1);
        List<Integer> subArrayNumbers = insertElementInSortedListRecursion(
                sortedNumbers, element);

        subArrayNumbers.add(lastElement);

        return subArrayNumbers;
    }


    public static void main(String args[]) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 3,0, 10, -4));
        SortArrayRecursion sortArrayRecursion = new SortArrayRecursion();
        System.out.println(sortArrayRecursion.sort(numbers));
    }

}
