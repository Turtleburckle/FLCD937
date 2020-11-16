package com.company;

public class Transition {
    private String from;
    private String to;
    private String transition;

    public Transition(String from,String to, String transition)
    {
        this.from = from;
        this.to = to;
        this.transition = transition;
    }

    public String getFrom(){return this.from;}
    public String getTo(){return this.to;}
    public String getTransition(){return this.transition;}

    @Override
    public String toString(){return "From " + this.from + " to " + this.to+ " with transition " + this.transition;}
}
