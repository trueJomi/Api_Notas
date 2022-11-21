package com.microservices.notas.Domain.validators;

import java.util.ArrayList;
import java.util.List;

public class TipeNotasValdiator {
    private static final List<String> notasValidas= new ArrayList<String>();



    public static Boolean validateNotas(String nota){
        notasValidas.add("C");
        notasValidas.add("B");
        notasValidas.add("A");
        notasValidas.add("AD");
        for (String n:
             notasValidas) {
            if (n.equals(nota)){
                return true;
            }
        }
        return false;
    }
}
