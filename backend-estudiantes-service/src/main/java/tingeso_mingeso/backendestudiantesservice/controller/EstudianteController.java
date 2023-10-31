package tingeso_mingeso.backendestudiantesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tingeso_mingeso.backendestudiantesservice.entity.EstudianteEntity;
import tingeso_mingeso.backendestudiantesservice.service.EstudianteService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    @GetMapping()
    public ResponseEntity<List<EstudianteEntity>> list() {
        List<EstudianteEntity> students = estudianteService.getStudents();
        if(students.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(students);
    }

    //O   @PostMapping("/new-student")
    @PostMapping()
    public ResponseEntity<EstudianteEntity> save(@RequestBody EstudianteEntity student) {
        EstudianteEntity studentNew = estudianteService.saveStudent(student);
        return ResponseEntity.ok(studentNew);
    }

}







