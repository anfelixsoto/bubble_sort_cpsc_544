package edu.fullerton.csu.cpsc544.bubble_sort.algorithm;
//EO: Init test with static array to show BubbleSort algo functionality. 
//Does not yet contain scanner functionality.
//import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Test {

    public static void main(String args[])
    {
        List<Integer>arr = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < 7; ++i)
            arr.add(random.nextInt(101));

        
        BubbleSort.ascending(arr);
        System.out.println("Ascending: ");
        
        PrintArray.printArray(arr);

        BubbleSort.descending(arr);

        System.out.println("Descending: ");
        PrintArray.printArray(arr);
    }

    

    
}