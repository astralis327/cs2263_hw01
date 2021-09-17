package edu.isu.cs2263.hw01;


import java.io.*;

public class PrintToFile implements OutputResults {
    private String outputFile;


    PrintToFile(String file ){
        outputFile = file;
    }
    @Override
    public void output(String expr, String result) throws IOException {
        if (outputFile == null || outputFile.isBlank())
            outputFile = "output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
            writer.append("Expression to be evaluated: ").append(expr).append("\n").append("Answer: ").append(result);
            writer.newLine();
        }
    }
}
