package edu.fullerton.csu.cpsc544.bubble_sort;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import edu.fullerton.csu.cpsc544.bubble_sort.algorithm.BubbleSort;

public class UnitTest {

    @Test
    public void CheckBubbleSortAscending()
    {
        List<Integer> answer = Arrays.asList(1, 2, 68, 71);
        List <Integer> list = Arrays.asList(71, 1, 68, 2);

        BubbleSort bs = new BubbleSort();
        BubbleSort.ascending(list);

        assertEquals(answer, BubbleSort.GetFinalResult());
    }

    @Test
    public void CheckBubbleSortDescending()
    {
        List<Integer> answer = Arrays.asList(71, 68, 2, 1);
        List <Integer> list = Arrays.asList(71, 1, 68, 2);

        BubbleSort bs = new BubbleSort();
        BubbleSort.descending(list);

        assertEquals(answer, BubbleSort.GetFinalResult());
    }

    @Test
    public void CheckResultSizeAscending()
    {
        List <Integer> list = Arrays.asList(71, 1, 68, 2);

        BubbleSort bs = new BubbleSort();
        BubbleSort.ascending(list);

        assertEquals(Optional.of(4), Optional.of(BubbleSort.GetResultSize()));
    }

    @Test
    public void CheckResultSizeDescending()
    {
        List <Integer> list = Arrays.asList(71, 1, 68, 2);

        BubbleSort bs = new BubbleSort();
        BubbleSort.descending(list);

        assertEquals(Optional.of(2), Optional.of(BubbleSort.GetResultSize()));
    }
}
