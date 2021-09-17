package edu.isu.cs2263.hw01;

public class PrintToConsole implements OutputResults {
    @Override
    public void output(String expr, String result) {
        System.out.println("Expression to be evaluated: " + expr + "\n" +
                            "Answer: " + result);
    }
}
