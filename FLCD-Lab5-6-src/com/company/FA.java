package com.company;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FA {
    // initial state, the set of states, the alphabet, all the transitions, the set of final states

    private final File file = new File("C:\\Users\\zsoka\\IdeaProjects\\FLCD-Lab4\\src\\com\\company\\elementsFA");
    private ArrayList<String> input;
    private ArrayList<String> setOfStates;
    private ArrayList<String> alphabet;
    private String initialState;
    private ArrayList<String> finalStates;
    private ArrayList<Transition> transitions;
    private ArrayList<Automaton> allAutomatons;

    public FA()
    {
        this.input = new ArrayList<>();
        this.setOfStates = new ArrayList<>();
        this.alphabet = new ArrayList<>();
        this.transitions = new ArrayList<>();
        this.finalStates = new ArrayList<>();
        this.allAutomatons = new ArrayList<>();
        this.readFile();
        this.createTheElementsOfTheFA();
        //this.printRandom();
    }

    private void readFile()
    {
        try {
            Scanner myReader = new Scanner(this.file);
            while (myReader.hasNextLine()) {
                this.input.add(myReader.nextLine());
            }
            myReader.close();
        }catch (Exception e){}
        this.separation();
    }

    private void separation()
    {
        for(String line : this.input)
        {
            String[] lineSeparated = line.split(",");
            Automaton automaton;
            if (lineSeparated[1].equals("null"))
            {
                automaton = new Automaton(lineSeparated[0], null, lineSeparated[2]);
            }
            else {
                automaton = new Automaton(lineSeparated[0], lineSeparated[1], lineSeparated[2]);
            }
            this.allAutomatons.add(automaton);

        }
    }

    private void createTheElementsOfTheFA()
    {
        this.initialState = this.allAutomatons.get(0).getStartPoint();
        for (Automaton automaton : this.allAutomatons)
        {
            //System.out.println(automaton.toString());
            if(!this.setOfStates.contains(automaton.getStartPoint())){this.setOfStates.add(automaton.getStartPoint());}
            if(!this.alphabet.contains(automaton.getTransition())){this.alphabet.add(automaton.getTransition());}
            if(automaton.getEndPoint() == null)
            {
                if (!this.finalStates.contains(automaton.getStartPoint()))
                {
                    this.finalStates.add(automaton.getStartPoint());
                }
            }
            if(automaton.getEndPoint() != null)
            {
                Transition newTransition = new Transition(automaton.getStartPoint(),automaton.getEndPoint(),automaton.getTransition());
                this.transitions.add(newTransition);
            }

        }
    }

    public String getInitialState(){return this.initialState;}
    public String getFinalStates()
    {
        String result = "[ ";
        for (String finalState : this.finalStates)
        {
            result += finalState + " ";
        }
        result += "]";
        return result;
    }
    public String getSetOfStates()
    {
        String result = "[";
        for(String state : this.setOfStates)
        {
            result += state + " ";
        }
        result += "]";
        return result;
    }
    public String getAlphabet()
    {
        String result = "[ ";
        for (String letter : this.alphabet)
        {
            result += letter + " " ;
        }
        result += "]";
        return result;
    }
    public String getTransitions()
    {
        String result = "";
        for(Transition transition : this.transitions)
        {
            result += transition.toString() + "\n";
        }
        return result;
    }

    public void dfa()
    {
        /*
            IS  -> p1   -> p2
                        -> p3
                -> p2   -> p4
                        -> p1
        */
        //TODO:: Change Transition so that to is an arrayList
        for(String nextPoint : this.hasNext(this.initialState))
        {
            //this.goesBack(nextPoint);
        }

    }

    private boolean goesBack(String point)
    {
        ArrayList<String> passed = new ArrayList<>();
        passed.add(point);
        ArrayList<String> nextPoints = this.hasNext(point);
        for(String nextPoint : nextPoints)
        {
            if (this.finalStates.contains(nextPoint))
            {
                return true;
            }
            else
            {
                System.out.println(passed.toString());
                passed.add(nextPoint);
                this.goesBack(nextPoint);
            }
        }
        System.out.println(passed.toString());
        return false;
    }

    private ArrayList<String> hasNext(String point)
    {
        ArrayList<String> nextPoints  = new ArrayList<>();
        for (Transition transition : this.transitions)
        {
            if (point.equals(transition.getFrom()))
            {
                nextPoints.add(transition.getTo());
            }
        }
        return nextPoints;
    }


}
