package edu.fullerton.csu.cpsc544.bubble_sort.algorithm;
// Bubble Sort class contains 2 methods: Bubble Sort Ascending and Bubble Sort Descending

import java.util.List;

public class BubbleSort 
{

    
    public static void ascending(List<Integer>arr)

    {
        for(int i = 0; i < arr.size()-1; ++i)
        {
            boolean swapped = false;

            for(int j = 0; j < arr.size() - i - 1; ++j)
            {
                if(arr.get(i) > arr.get(j + 1)) //ascending order
                {
                    //swap 
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swapped = true;
                }
            }
            //if no 2 elements were swapped by inner loop, then break
            if(!swapped)
                break;
        }
    }

    public static void descending(List<Integer>arr)
    {
        
        for(int i = 0; i < arr.size()-1; ++i)
        {
            boolean swapped = false;

            for(int j = 0; j < arr.size() - i - 1; ++j)
            {
                if(arr.get(i) < arr.get(j + 1)) //descending
                {
                    //swap 
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swapped = true;
                }
            }
            
            if(!swapped)
                break;
        }
    }

}