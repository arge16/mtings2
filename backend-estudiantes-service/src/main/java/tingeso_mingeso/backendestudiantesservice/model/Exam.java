package tingeso_mingeso.backendestudiantesservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {

    private String rut;
    private int score;
    private String date_of_exam;
    private int studentId;
}