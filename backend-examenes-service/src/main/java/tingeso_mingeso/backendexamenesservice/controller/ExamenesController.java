package tingeso_mingeso.backendexamenesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingeso_mingeso.backendexamenesservice.entity.ExamenesEntity;

import tingeso_mingeso.backendexamenesservice.service.ExamenesService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/examen")
public class ExamenesController {
    @Autowired
    ExamenesService examenesService;


    @GetMapping("/byrut/{rut}")
    public ResponseEntity<ArrayList<ExamenesEntity>> getByRut(@PathVariable("rut") String rut) {
        ArrayList<ExamenesEntity> examenes = examenesService.byRut(rut);
        return ResponseEntity.ok(examenes);
    }

}
