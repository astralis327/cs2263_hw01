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


public class App {
//

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
                System.out.println("Batch Value: " + arguments[1]);
            } else if (cmd.hasOption("o") || cmd.hasOption("output")) {
                System.out.println("Output value: " + arguments[1]);
            }
            else if (cmd.hasOption("h") || cmd.hasOption("help")){
                //help option formatter
                HelpFormatter getHelp = new HelpFormatter();
                getHelp.printHelp("eval", header, options, footer, true);
            }
        }
        catch (ParseException exception){
            System.out.println("FAILED!!" );
            System.out.println(exception.getMessage());
        }
    }

    public static void main(String[] args) throws ParseException {

        cliDemo(args);
    }

}
