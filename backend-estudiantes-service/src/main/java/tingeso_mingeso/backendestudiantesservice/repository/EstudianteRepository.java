package tingeso_mingeso.backendestudiantesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tingeso_mingeso.backendestudiantesservice.entity.EstudianteEntity;

import java.util.ArrayList;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long> {
    //@Query("select e from EstudianteEntity e where e.rut = :rut")
    //EstudianteEntity findByRut(@Param("rut") String rut);

    public EstudianteEntity findByRut(String rut);

}
