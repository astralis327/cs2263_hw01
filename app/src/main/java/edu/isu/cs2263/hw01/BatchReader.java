package edu.isu.cs2263.hw01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BatchReader{
    public BatchReader() throws IOException {
    }

    public String[] getUserInput(String argument) throws IOException {

        String fileName;
        String[] stringArr = new String[0];
        try{

            File f = new File(argument);

            BufferedReader in = new BufferedReader(new FileReader(argument));
            String str;

            List<String> list = new ArrayList<String>();
            while ((str = in.readLine()) != null) {
                list.add(str);
            }

            stringArr = list.toArray(new String[0]);
        }
        catch (FileNotFoundException e) {
            System.out.println("Sorry, that file does not exist. Please try again. ");
            ConsoleLoop newBatch = new ConsoleLoop();
            fileName = newBatch.getUserInput(argument);
            stringArr =  getUserInput(fileName);
        }
        return stringArr;
    }
}


