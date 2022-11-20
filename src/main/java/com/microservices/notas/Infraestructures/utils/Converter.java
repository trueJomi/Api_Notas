package com.microservices.notas.Infraestructures.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    private final ObjectMapper mapper= new ObjectMapper();

    public<T> T ConvertirObjeto(String json, TypeReference<T> reference){
        try {
            return mapper.readValue(json,reference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
