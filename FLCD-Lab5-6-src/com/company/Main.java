package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	FA fa = new FA();
	int command = -1;
	while (command != 0)
    {
        System.out.println("0 -> Exit");
        System.out.println("1 -> The Initial State");
        System.out.println("2 -> The Final State(s)");
        System.out.println("3 -> The Set Of States");
        System.out.println("4 -> The Alphabet");
        System.out.println("5 -> All of the Transitions");

        Scanner scanner = new Scanner(System.in);
        command = scanner.nextInt();
        if (command > 6 || command < 0)
        {
            System.out.println("Wait that's illegal.");
        }
        else
        {
            if (command == 1){System.out.println(fa.getInitialState());}
            if (command == 2){System.out.println(fa.getFinalStates());}
            if (command == 3){System.out.println(fa.getSetOfStates());}
            if (command == 4){System.out.println(fa.getAlphabet());}
            if (command == 5){System.out.println(fa.getTransitions());}
            if (command == 6){fa.dfa();}

        }
    }
    }
}
