
//EO: Init test with static array to show BubbleSort algo functionality. 
//Does not yet contain scanner or Arraylist functionality.

//import java.util.ArrayList;
//import java.util.Scanner;

public class Test {

    public static void main(String args[])
    {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        BubbleSort.asc_bubbleSort(arr);
        System.out.println("Ascending: ");
        
        PrintArray.printArray(arr, n);

        BubbleSort.desc_bubbleSort(arr);

        System.out.println("Descending: ");
        PrintArray.printArray(arr, n);
    }

    

    
}