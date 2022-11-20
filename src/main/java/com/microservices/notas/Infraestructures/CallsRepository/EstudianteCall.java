package com.microservices.notas.Infraestructures.CallsRepository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microservices.notas.Application.exceptions.IncorrectResourceRequestException;
import com.microservices.notas.Application.utils.WrapperResponse;
import com.microservices.notas.Domain.repositoryContracts.EstudianteRepository;
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

public class EstudianteCall implements EstudianteRepository {
    @Value("hola")
    String servicio;

    @Value("/propuesta")
    String part;

    private final Converter converter;

    public EstudianteCall(Converter converter) {
        this.converter = converter;
    }

    public Boolean estudianteValido(Integer id){
        String service=servicio+part+"/validar/"+id.toString();
        RestTemplate restTemplate= new RestTemplate();

        try {
            ResponseEntity<WrapperResponse<Boolean>> response= restTemplate
                    .exchange(
                            service,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<WrapperResponse<Boolean>>(){});
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

//    public WrapperResponse<PropuestaExtendDto> ObtenerPorId(Integer id) throws InterruptedException{
//        String service=servicio+part+"/"+id;
//        RestTemplate restTemplate= new RestTemplate();
//        try{
//            ResponseEntity<WrapperResponse<PropuestaExtendDto>> response= restTemplate
//                    .exchange(
//                            service,
//                            HttpMethod.GET,
//                            null,
//                            new ParameterizedTypeReference<WrapperResponse<PropuestaExtendDto>>(){});
//            return response.getBody();
//        }catch (HttpClientErrorException errorException){
//            WrapperResponse<Void> error =converter.ConvertirObjeto(
//                    errorException.getResponseBodyAsString(),
//                    new TypeReference<WrapperResponse<Void>>(){});
//            throw new InterruptedException(error.getMessage());
//        }
//    }
}
