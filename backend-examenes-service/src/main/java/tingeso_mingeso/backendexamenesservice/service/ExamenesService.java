package tingeso_mingeso.backendexamenesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingeso_mingeso.backendexamenesservice.entity.ExamenesEntity;

import tingeso_mingeso.backendexamenesservice.repository.ExamenesRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ExamenesService {
    @Autowired
    ExamenesRepository examenesRepository;


    @Autowired
    RestTemplate restTemplate;


    public ArrayList<ExamenesEntity> byRut(String rut) {
        return examenesRepository.findByRut(rut);
    }
}
