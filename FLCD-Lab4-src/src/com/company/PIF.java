package com.company;

import java.util.Hashtable;

public class PIF {
    private Hashtable<Integer,String> programIdentifierForm;

    public PIF()
    {
        this.programIdentifierForm = new Hashtable<Integer, String>();
    }

    public void addNotStToPIF(String token)
    {
        this.programIdentifierForm.put(0,token);
    }

    public void addStToPIF(int token, Integer positionInSt) //0 for constant and 1 for identifier
    {
        if (token == 0) {this.programIdentifierForm.put(positionInSt,"0");}
        else if (token == 1){this.programIdentifierForm.put(positionInSt,"1");}
    }

    public String getPIF()
    {
        return this.programIdentifierForm.toString();
    }
}
