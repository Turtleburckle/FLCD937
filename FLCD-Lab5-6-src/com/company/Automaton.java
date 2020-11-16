package com.company;

public class Automaton {
    private String point1;
    private String point2;
    private String transition;

    public Automaton (String startPoint, String endPoint, String transition)
    {
        this.point1 = startPoint;
        this.point2 =endPoint;
        this.transition = transition;
    }

    public String getStartPoint() {
        return point1;
    }

    public String getEndPoint() {
        return point2;
    }

    public String getTransition() {
        return transition;
    }
}
