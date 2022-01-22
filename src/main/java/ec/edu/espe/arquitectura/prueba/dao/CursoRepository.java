package ec.edu.espe.arquitectura.prueba.dao;

import ec.edu.espe.arquitectura.prueba.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CursoRepository extends MongoRepository<Curso,String> {

    List<Curso> findByAreaAndNombreLike (String area, String nombre);
}
