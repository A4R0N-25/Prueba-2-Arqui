package ec.edu.espe.arquitectura.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Document(collection = "curso")
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    private String id;

    private String codigo;

    private String area;

    private String nombre;

    private Integer horas;

    private Date fechaInicio;

    private BigDecimal costo;
}
