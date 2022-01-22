package ec.edu.espe.arquitectura.prueba.dao;

import ec.edu.espe.arquitectura.prueba.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

    Optional<Estudiante> findByCorreo (String correo);
}
