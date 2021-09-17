
/*
Copyright Emily Elzinga
CS 2263 HW 1
Created 9/16/21
 */
package edu.isu.cs2263.hw01;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import static java.lang.Integer.parseInt;

import java.io.IOException;
import java.util.*;


public class App {
//

    static void evalExpression(String evalString){
        //arraylist for separating the numbers out
        ArrayList<String> stringNums = new ArrayList<>();
        //evaluated expression
        double evaluated = 0;
        //each number string is eventually converted
        int num = 0;
        String sNum = "";
        Integer firstOperatorKey = 0;
        //Map to store operators
        Map<Integer, Character> operators= new LinkedHashMap<Integer, Character>();
        //get rid of spaces
        evalString = evalString.replaceAll("\\s+","");

        //put operators in map
        for (int i = 0; i < evalString.length() -1; i++) {
            if (evalString.charAt(i) == '+' || evalString.charAt(i) == '-'
                    || evalString.charAt(i) == '/' || evalString.charAt(i) == '*') {
                operators.put(i, evalString.charAt(i));
                if(operators.size() == 1) {
                    //where the first operator is in the string
                    firstOperatorKey = i;
                }
            }
        }

        int firstIndex = 0;
        //separate the numbers based on where the operators are, and add them to an array
        for (Map.Entry<Integer, Character> me : operators.entrySet()) {

            stringNums.add(evalString.substring(firstIndex, me.getKey()));
            firstIndex = me.getKey()+1;
        }
        //add last number after the last operator to array
        stringNums.add(evalString.substring(firstIndex));


        for (int j = 0; j < stringNums.size(); j++){
            //take each number out of array
            sNum = stringNums.get(j);
            num = parseInt(sNum);
            //if it's the first number, just add it to the evaluated val
            if (j == 0) evaluated += num;
            else {
                //preform operations
                switch (operators.get(firstOperatorKey)) {
                    case '+' -> evaluated += num;
                    case '-' -> evaluated -= num;
                    case '/' -> evaluated /= num;
                    case '*' -> evaluated *= num;
                }
                firstOperatorKey += sNum.length() + 1;
            }
        }
        System.out.println(evaluated);
    }

    static void cliDemo(String[] arguments) {
        Options options = new Options();
        options.addOption("b", "batch", false, "batch file containing expressions to evaluate");
        options.addOption("o", "output", false, "output file");
        options.addOption("h", "help", false, "print usage message");

        String header = "Evaluation of simple mathematical expressions";
        String footer = "Copyright (C) 2021 Emily Elzinga";

        //create a parser
        try{
            CommandLineParser parser = new DefaultParser();
            //parse the options passed as command line arguments
            CommandLine cmd = parser.parse(options, arguments);
            if (cmd.hasOption("b") || cmd.hasOption("batch")) {
                BatchReader expressionBatch = new BatchReader();
                String[] fileArray = expressionBatch.getUserInput(arguments[1]);

                for (int i = 0; i < fileArray.length; i++){
                    evalExpression(fileArray[i]);
                }

            } else if (cmd.hasOption("o") || cmd.hasOption("output")) {
                evalExpression(arguments[1]);
            }
            else if (cmd.hasOption("h") || cmd.hasOption("help")){
                //help option formatter
                HelpFormatter getHelp = new HelpFormatter();
                getHelp.printHelp("eval", header, options, footer, true);
            }
        }
        catch (ParseException | IOException exception){
            System.out.println("FAILED!!" );
            System.out.println(exception.getMessage());
        }
    }

    public static void main(String[] args) throws ParseException {
        cliDemo(args);
    }

}
