package edu.fullerton.csu.cpsc544.bubble_sort.algorithm;
// Bubble Sort class contains 2 methods: Bubble Sort Ascending and Bubble Sort Descending

public class BubbleSort 
{
    public BubbleSort() {}

    public static void ascending(int arr[])
    {
        for(int i = 0; i < arr.length-1; ++i)
        {
            boolean swapped = false;

            for(int j = 0; j < arr.length - i - 1; ++j)
            {
                if(arr[j] > arr[j + 1]) //ascending order
                {
                    //swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            //if no 2 elements were swapped by inner loop, then break
            if(!swapped)
                break;
        }
    }

    public static void descending(int arr[])
    {
        
        for(int i = 0; i < arr.length-1; ++i)
        {
            boolean swapped = false;

            for(int j = 0; j < arr.length - i - 1; ++j)
            {
                if(arr[j] < arr[j + 1]) //descending order
                {
                    //swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if(!swapped)
                break;
        }
    }

}