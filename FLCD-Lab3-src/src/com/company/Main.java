package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    ST identifierST = new ST();
	    ST constantST = new ST();
	    MyScanner scanner = new MyScanner(identifierST,constantST);
    	//ST myTable = new ST();
	    //System.out.println(myTable.addToST("B") + " B");
		//System.out.println(myTable.addToST("C") + " C");
		//System.out.println(myTable.getSymbolTable());
		//System.out.println(myTable.addToST("AA") + " AA");
		//System.out.println(myTable.getSymbolTable());
		//System.out.println(myTable.addToST("A") + " A");
		//System.out.println(myTable.getSymbolTable());
    }
}
