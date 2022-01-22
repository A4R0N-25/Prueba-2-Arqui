package ec.edu.espe.arquitectura.prueba.service;

import ec.edu.espe.arquitectura.prueba.dao.CursoRepository;
import ec.edu.espe.arquitectura.prueba.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> consultarCursos(String area, String nombre){

        List<Curso> cursos = this.cursoRepository.findByAreaAndNombreLike(area,nombre);

        return  cursos;
    }
}
