package ec.edu.espe.arquitectura.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "estudiante")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estudiante {

    @Id
    private String id;

    private String nombre;

    private String correo;

    private String pais;

    private Date fechaNacimiento;

    private Date fechaCreacion;

    private String estado;

    private List<CursoEstudiante> cursos;

}
