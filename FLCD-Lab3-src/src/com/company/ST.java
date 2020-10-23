package com.company;

import java.util.Hashtable;

public class ST {
    private Hashtable<Integer,String> symbolTable;

    public ST(){this.symbolTable = new Hashtable<Integer, String>();}

    public Integer getPosition(String token)
    {
        for (int index = 1 ; index <= this.symbolTable.size(); index++)
        {
            if (this.symbolTable.get(index) == token )
            {
                return index;
            }
        }
        return 0;
    }

    public static int getASCII(String token)
    {
        int asciiValue = 0;
        for(int index=0; index<= token.length()-1; index++)
        {
            asciiValue += token.charAt(index);
        }
        return asciiValue;
    }

    public boolean existsInST(String token)
    {
        for (int index=1; index <= this.symbolTable.size(); index++)
        {
            if (this.symbolTable.get(index) == token){return true;}
        }
        return false;
    }

    public int addToST (String token)
    {
        if (!this.existsInST(token))
        {
            this.symbolTable.put(this.symbolTable.size() + 1, token);
            if (this.symbolTable.size() != 1) {
                hashTheTable(getASCII(token), token);
            }
            return this.getPosition(token);
        }
        else {return this.getPosition(token);}
    }

    public void hashTheTable(int asciiToken, String token)
    {
        //System.out.println(this.getSymbolTable());
        int currentPosition = this.symbolTable.size();
        for (int index = this.symbolTable.size(); index > 0; index--)
        {
            int currentASCII = getASCII(this.symbolTable.get(index));
            if (currentASCII > asciiToken)
            {
                String oldToken = this.symbolTable.get(index);
                this.symbolTable.replace(index,oldToken,token);
                this.symbolTable.replace(currentPosition,token,oldToken);
                currentPosition = index;
            }
        }
    }

    public String getSymbolTable()
    {
        return this.symbolTable.toString();
    }


}
