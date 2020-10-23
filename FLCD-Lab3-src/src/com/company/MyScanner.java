package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyScanner {

        private ArrayList<String> tokens;
        private final File myFile;
        private ST identifierST;
        private ST constantST;

        public MyScanner(ST identifierST, ST constantST) throws FileNotFoundException {
                this.myFile = new File("C:\\Users\\zsoka\\IdeaProjects\\FLCD-Lab3\\src\\com\\company\\token.in");
                this.tokens = new ArrayList<>();
                this.identifierST = identifierST;
                this.constantST = constantST;
                this.readFromFile();
        }

        public void readFromFile() throws FileNotFoundException {
                Scanner myReader = new Scanner(this.myFile);
                while (myReader.hasNextLine()) {
                        this.tokens.add(myReader.nextLine());
                }
                myReader.close();
        }

        public void separate(String input)
        {
                String space = " ";
                String[] separatedInput = input.split(space);
                for (String word : separatedInput)
                {
                        if (!this.tokens.contains(word))
                        {
                                //TODO:: regex comparison for letters and numbers
                                String result = this.regexComparison(word);
                                if(result.equals("constant"))
                                {
                                        this.constantST.addToST(word);
                                }
                                else if (result.equals("identifier"))
                                {
                                        this.identifierST.addToST(word);
                                }
                                else
                                {
                                        //TODO:: think of how to add this somewhere.... *nvm it doesn't go in PIF or ST bc it's lexical error* but what do I do with it
                                }
                                //if number put in STconstant + pIF
                                //if letter put un STidentifier +PIF
                                //if letter followed by number is oke -> ST identifier
                                //if number followed by letter(s) is not ok -> lexical error
                        }
                        else
                        {
                                //TODO:: reserved word
                        }
                }
        }

        private String regexComparison (String lexicalTokens)
        {
                //TODO:: regex comparison
                //will return constant | identifier | lexicalError
                return "";
        }




}
