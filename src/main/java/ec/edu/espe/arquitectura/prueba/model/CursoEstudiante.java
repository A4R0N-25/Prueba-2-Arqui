package ec.edu.espe.arquitectura.prueba.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursoEstudiante {

    private String cursoId;
    private String estado;

}
