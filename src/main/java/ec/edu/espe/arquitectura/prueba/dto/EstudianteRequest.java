package ec.edu.espe.arquitectura.prueba.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EstudianteRequest {

    private String nombre;

    private String correo;

    private String pais;

    private Date fechaNacimiento;

}
