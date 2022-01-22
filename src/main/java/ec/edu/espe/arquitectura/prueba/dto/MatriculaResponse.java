package ec.edu.espe.arquitectura.prueba.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatriculaResponse {

    private String codigoCurso;

    private String areaCurso;

    private String nombreCurso;

    private String nombreEstudiante;

    private String correoEstudiante;

    private String paisEstudiante;
}
