package tingeso_mingeso.backendcuotasservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tingeso_mingeso.backendcuotasservice.entity.CuotasEntity;
import tingeso_mingeso.backendcuotasservice.model.EstudianteEntity;
import tingeso_mingeso.backendcuotasservice.service.CuotasService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cuotas")
public class CuotasController {
    @Autowired
    CuotasService cuotasService;

    @PostMapping()
    public ResponseEntity<CuotasEntity> save(@RequestBody CuotasEntity cuota) {
        CuotasEntity cuotaNew = cuotasService.saveInstallment(cuota);
        return ResponseEntity.ok(cuotaNew);
    }


    @GetMapping("/generar-contado/{rut}")
    public ResponseEntity<ArrayList<CuotasEntity>>  generarCuotasContado(@PathVariable("rut") String rut) {
        cuotasService.generarPagoContado(rut);
        ArrayList<CuotasEntity> cuotas = cuotasService.getAllByRut(rut);
        return ResponseEntity.ok(cuotas);//Redirect es para redirigir a otro controlador, return retorna la vista
    }

    @GetMapping("/generar-cuotas/{rut}/{limit}")
    public ResponseEntity<ArrayList<CuotasEntity>>  generarCuotas(@PathVariable("rut") String rut, @PathVariable("limit") int limit) {
        cuotasService.generarCuotas(rut,limit);
        ArrayList<CuotasEntity> cuotas = cuotasService.getAllByRut(rut);
        return ResponseEntity.ok(cuotas);//Redirect es para redirigir a otro controlador, return retorna la vista
    }


    @GetMapping("/bystudent/{rut}")
    public ResponseEntity<ArrayList<CuotasEntity>> getByStudentId(@PathVariable("rut") String rut) {
        ArrayList<CuotasEntity> cuotas = cuotasService.getAllByRut(rut);
        return ResponseEntity.ok(cuotas);
    }



    @GetMapping("/mark-paid/{id}")
    public ResponseEntity<Void> markPaid(@PathVariable("id") Long id) {
        cuotasService.markPaid(id);
        // Después de marcar el pago, puedes devolver un código de estado 204 (No Content)
        return ResponseEntity.noContent().build();
    }

}






