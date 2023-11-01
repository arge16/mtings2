package tingeso_mingeso.backendcuotasservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExamenesEntity {

    private String rut;
    private int score;
    private String date_of_exam;
}
