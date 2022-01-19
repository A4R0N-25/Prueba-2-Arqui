package ec.edu.espe.arquitectura.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "test")
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    @Id
    private String id;
    private String palabra;
}
