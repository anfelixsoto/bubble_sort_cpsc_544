package edu.fullerton.csu.cpsc544.bubble_sort.algorithm;
// Bubble Sort class contains 2 methods: Bubble Sort Ascending and Bubble Sort Descending

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort
{
    static List <Swap> results;

    public BubbleSort() { results = new ArrayList<>(); }

    public static void ascending(List<Integer> arr)
    {
        for(int i = 0; i < arr.size() - 1; i++)
        {
            for(int j = 0; j < arr.size() - 1; j++)
            {
                if(arr.get(j) > arr.get(j + 1))
                {
                    List<Integer> prev = new ArrayList<>(arr);
                    int tmp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, tmp);
                    List <Integer> result = new ArrayList<>(arr);
                    AddToResult(prev, arr.get(j + 1), arr.get(j), result);
                }
            }
        }
    }

    public static void descending(List<Integer> arr)
    {
        for(int i = 0; i < arr.size() - 1; i++)
        {
            for(int j = 0; j < arr.size() - 1; j++)
            {
                if(arr.get(j) < arr.get(j + 1))
                {
                    List<Integer> prev = new ArrayList<>(arr);
                    int tmp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, tmp);
                    List <Integer> result = new ArrayList<>(arr);
                    AddToResult(prev, arr.get(j + 1), arr.get(j), result);
                }
            }
        }
    }

    public static void AddToResult(List<Integer> prev, int first, int second, List<Integer> res)
    {
        Swap swap = new Swap();
        swap.AddToPrevious(prev);
        swap.ValuesSwapped(first, second);
        swap.AddResult(res);
        results.add(swap);
    }

    @NonNull
    public String toString()
    {
        StringBuilder sb = new StringBuilder(results.isEmpty() ? "Numbers are already sorted! Yippee!\n" : "");
        int i = 1;

        for(Swap swap : results)
        {
            sb.append("Step ").append(i).append(":\n")
                    .append("Numbers Swapped: ").append(swap.GetFirst()).append( " | ").append(swap.GetSecond()).append("\n")
                    .append("Before Swap: ").append(ListToString(swap.GetPrevious())).append("\n")
                    .append("After Swap: ").append(ListToString(swap.GetResult())).append("\n\n\n");
            i++;
        }
        return sb.toString();
    }

    public static String ListToString(List<Integer> nums)
    {
        StringBuilder sb = new StringBuilder();
        for(Integer num : nums)
            sb.append(num).append(" ");

        return sb.toString();
    }

    public static List<Integer> GetFinalResult()
    {
        Swap sp = new Swap();
        sp = results.get(results.size() - 1);
        return sp.GetResult();
    }

    public static Integer GetResultSize()
    {
        return results.size();
    }
}