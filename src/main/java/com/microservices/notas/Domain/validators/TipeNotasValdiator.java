package com.microservices.notas.Domain.validators;

import java.util.ArrayList;
import java.util.List;

public class TipeNotasValdiator {
    private static List<String> notasValidas= new ArrayList<String>(){
        {
            add("C");
            add("B");
            add("A");
            add("AD");
        }
    };

    public static Boolean validateNotas(String nota){
        for (String n:
             notasValidas) {
            if (n.equals(nota)){
                return true;
            }
        }
        return false;
    }
}
