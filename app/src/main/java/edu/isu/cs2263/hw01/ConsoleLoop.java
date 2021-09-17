package edu.isu.cs2263.hw01;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleLoop {

    public ConsoleLoop(){}

    public String getUserInput(String argument) {

//        if(argument)
        if (argument.contains("txt")) {
            System.out.println("Please enter the correct filename: ");
            Scanner scanner = new Scanner(System.in);
            return scanner.next();
        } else {
            System.out.println("Please input a mathematical expression: ");
            Scanner scanner = new Scanner(System.in);
            boolean valid = false;
            String evalString = scanner.nextLine();
//            for (int i=0; )
            if (evalString.indexOf('-') != -1 || evalString.indexOf('+') != -1 ||
                    evalString.indexOf('/') != -1 || evalString.indexOf('*') != -1) {
                valid = true;
            }
            while (!valid) {
                System.out.println("yOU hAVE eNTERED aN iNVALID vALUE fOR yOUR eXPRESSION. TRY AGAIN!!");

                evalString = scanner.next();
                if (evalString.indexOf('-') != -1 || evalString.indexOf('+') != -1 ||
                        evalString.indexOf('/') != -1 || evalString.indexOf('*') != -1) {
                    valid = true;
                }
            }
            if (argument == null) {
                evalString = scanner.next();
            }
            return evalString;
        }
    }


}

