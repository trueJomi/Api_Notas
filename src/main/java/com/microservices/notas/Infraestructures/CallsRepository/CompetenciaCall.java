package com.microservices.notas.Infraestructures.CallsRepository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microservices.notas.Application.exceptions.IncorrectResourceRequestException;
import com.microservices.notas.Application.utils.WrapperResponse;
import com.microservices.notas.Domain.repositoryContracts.CompetenciaRepository;
import com.microservices.notas.Infraestructures.utils.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class CompetenciaCall implements CompetenciaRepository {

    @Value("hola")
    String servicio;

    @Value("/propuesta")
    String part;

    private final Converter converter;

    public CompetenciaCall(Converter converter) {
        this.converter = converter;
    }

    public Boolean competanciaValidar(Integer id){
        String service = servicio + part + "/validar/" + id.toString();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Integer> data = new HttpEntity<Integer>(id);
        try {
            ResponseEntity<WrapperResponse<Boolean>> response = restTemplate
                    .exchange(
                            service,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<WrapperResponse<Boolean>>() {
                            });
            return Objects.requireNonNull(response.getBody()).getBody();
        } catch (HttpClientErrorException errorException) {
            WrapperResponse<Boolean> error = converter.ConvertirObjeto(
                    errorException.getResponseBodyAsString(),
                    new TypeReference<WrapperResponse<Boolean>>() {
                    });
            throw new IncorrectResourceRequestException(error.getMessage());
        } catch (NullPointerException nullPointerException) {
            throw new IncorrectResourceRequestException("No se pudo encontrar el servidor");
        }
    }
}
