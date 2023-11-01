package tingeso_mingeso.backendestudiantesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingeso_mingeso.backendestudiantesservice.entity.EstudianteEntity;
import tingeso_mingeso.backendestudiantesservice.entity.TipoColegioEntity;
import tingeso_mingeso.backendestudiantesservice.repository.EstudianteRepository;
import tingeso_mingeso.backendestudiantesservice.model.CuotasEntity;
import org.springframework.http.HttpEntity;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    TipoColegioService tipoColegioService;

    @Autowired
    RestTemplate restTemplate;


    //public List<EstudianteEntity> findAll(){return estudianteRepository.findAll();}

    public int findIdByTipo(String tipo){
       TipoColegioEntity tipoColegioEntity = tipoColegioService.findByTipo(tipo);
       return tipoColegioEntity.getId();
    }

    //public EstudianteEntity findByRut(String rut){ return estudianteRepository.findByRut(rut); }

    public List<EstudianteEntity> getStudents() {
        return (List<EstudianteEntity>) estudianteRepository.findAll();
    }

    public EstudianteEntity saveStudent(EstudianteEntity student) {
        return estudianteRepository.save(student);
    }

    public EstudianteEntity getByRut(String rut) {
        return estudianteRepository.findByRut(rut);
    }

    public EstudianteEntity setPaymentType(String rut, String payment_type) {
        EstudianteEntity student = estudianteRepository.findByRut(rut);
        student.setPaymentType(payment_type);
        return estudianteRepository.save(student);
    }


    public EstudianteEntity getStudentByRut(String rut) {
        return estudianteRepository.findByRut(rut);
    }

    public ArrayList<CuotasEntity> getCuotas(String rut) {
        ArrayList<CuotasEntity> cuotas = restTemplate.getForObject("http://backend-cuotas-service/cuotas/bystudent/" + rut, ArrayList.class);
        return cuotas;
    }


    /*
    public void saveStudentData(String rut, String name, String lastname, String birthdate, int graduation_year, String school, String school_type) {
        EstudianteEntity student = new EstudianteEntity();
        student.setRut(rut);
        student.setName(name);
        student.setLastname(lastname);
        student.setBirthdate(birthdate);
        student.setGraduation_year(graduation_year);
        student.setSchool(school);
        student.setSchool_type(school_type);
        estudianteRepository.save(student);
    }
        */
}
