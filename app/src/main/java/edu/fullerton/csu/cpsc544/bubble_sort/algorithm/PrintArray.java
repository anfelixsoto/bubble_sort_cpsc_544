package edu.fullerton.csu.cpsc544.bubble_sort.algorithm;
//Contains function for printing array, array has to be passed in
import java.util.List;
public class PrintArray {

    public static void printArray(List<Integer>arr)
    {
        for(int i = 0; i < arr.size(); ++i)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }
    
}

