package edu.fullerton.csu.cpsc544.bubble_sort.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Swap {
    int first, second;
    List<Integer> previous;
    List<Integer> result;

    public Swap() {
        this.previous = new ArrayList<>();
        this.result = new ArrayList<>();
    }

    public void ValuesSwapped(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public Integer GetFirst() { return this.first; }
    public Integer GetSecond() { return this.second; }
    public List <Integer> GetPrevious() {return this.previous; }
    public List <Integer> GetResult() {return this.result; }

    public void AddToPrevious(List<Integer> nums) { previous = nums; }
    public void AddResult(List<Integer> nums) { result = nums; }

}
