package ec.edu.espe.arquitectura.prueba.dao;

import ec.edu.espe.arquitectura.prueba.model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TestRepository extends MongoRepository<Test, String> {

    Optional<Test> findByPalabra (String palabra);
}
