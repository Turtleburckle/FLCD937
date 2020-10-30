package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class MyScanner {

        private ArrayList<String> tokens;
        private final File tokensFile;
        private File problemFile;
        private ST identifierST;
        private ST constantST;
        private PIF pif;

        public MyScanner(ST identifierST, ST constantST, PIF pif, String problem) throws FileNotFoundException {
                this.tokensFile = new File("C:\\Users\\zsoka\\IdeaProjects\\FLCD-Lab3\\src\\com\\company\\token.in");
                this.tokens = new ArrayList<>();
                this.identifierST = identifierST;
                this.constantST = constantST;
                this.pif = pif;
                this.readFromFile();
                if (problem.equals("p1"))
                {
                        this.problemFile = new File("C:\\Users\\zsoka\\IdeaProjects\\FLCD-Lab3\\src\\com\\company\\p1");
                        this.readProblem();
                }
        }

        public void readProblem () throws FileNotFoundException {
                Scanner myReader = new Scanner(this.problemFile);
                String input = "";
                while (myReader.hasNextLine()) {
                        input += myReader.nextLine() + " ";
                }
                myReader.close();
                this.separate(input);
        }

        public void readFromFile() throws FileNotFoundException {
                Scanner myReader = new Scanner(this.tokensFile);
                while (myReader.hasNextLine()) {
                        this.tokens.add(myReader.nextLine());
                }
                myReader.close();
        }

        public void separate(String input)
        {
                System.out.println(input);
                String[] separatedInput = input.split(" ");
                for (String word : separatedInput)
                {
                        //System.out.println(word);
                        if (!this.tokens.contains(word))
                        {
                                System.out.println(word + "->nonToken");
                                //TODO:: regex comparison for letters and numbers
                                String result = this.regexComparison(word);
                                if(result.equals("constant"))
                                {
                                        this.pif.addStToPIF(0,this.constantST.addToST(word));
                                }
                                else if (result.equals("identifier"))
                                {
                                        this.pif.addStToPIF(1,this.identifierST.addToST(word));
                                }
                                else
                                {//here it means that is an lexical error because it's a number followed by letters
                                        System.out.println(word + " this is an lexical error!\n");
                                }
                                //if number put in STconstant + pIF
                                //if letter put un STidentifier +PIF
                                //if letter followed by number is oke -> ST identifier
                                //if number followed by letter(s) is not ok -> lexical error
                        }
                        else
                        {//here it means that 'word' is an reserved word so it's automatically put in PIF
                                this.pif.addNotStToPIF(word);
                        }
                }
        }

        private String regexComparison (String lexicalTokens)
        {// kind of an regex comparison but ascii
                int asciiValue = 0;
                ArrayList<Integer> structure = new ArrayList<>(); //0 for number and 1 for letter
                for(int index=0; index<= lexicalTokens.length()-1; index++)
                {
                        asciiValue = lexicalTokens.charAt(index);
                        //System.out.println(asciiValue);
                        if (asciiValue >= 48 && asciiValue <= 57)
                        {
                                structure.add(0);
                        }
                        else if ((asciiValue >= 65 && asciiValue <= 90) || (asciiValue >= 97 && asciiValue <= 122))
                        {
                                structure.add(1);
                        }
                }
                //System.out.println(structure);
                int type = 3; // 1 - identifier | 0 - constant
                for (Integer number : structure)
                {
                        if (number == 0)
                        {
                                if (type == 3) { type = 0; }
                        }
                        else if (number == 1)
                        {
                                if (type == 3) {type = 1;}
                                else if (type == 0) {return "lexicalError";}
                        }
                }
                if (type == 1){return "identifier";}
                else if (type == 0){return "constant";}
                else {return "lexicalError";}
        }

        public void printAll()
        {
                System.out.println("CONSTANT ST");
                System.out.println(this.constantST.getSymbolTable());
                System.out.println("IDENTIFIER ST");
                System.out.println(this.identifierST.getSymbolTable());
                System.out.println("PIF");
                System.out.println(this.pif.getPIF());
        }




}
