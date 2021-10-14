package com.example.testcalculator;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

public class MakeRequest {

    public static Collection<String> prepareLine(String inputLine){
        char[] charMas = inputLine.toCharArray();
        StringBuilder tempNumber = new StringBuilder();
        Collection<String> tempCollection = new ArrayList<String>();

        for(char ch : charMas){
            if((ch >= 48 && ch <= 57) | ch == 46){
                tempNumber.append(ch);
            }
            else{
                if(tempNumber.length() != 0) tempCollection.add(tempNumber.toString());
                tempCollection.add(Character.toString(ch));
                tempNumber.delete(0, tempNumber.length());
            }
        }
        if(tempNumber.length() != 0) tempCollection.add(tempNumber.toString());
        return  tempCollection;
    }
}
