package ec.edu.espe.arquitectura.prueba.service;

import ec.edu.espe.arquitectura.prueba.dao.CursoRepository;
import ec.edu.espe.arquitectura.prueba.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.prueba.dto.EstudianteRequest;
import ec.edu.espe.arquitectura.prueba.dto.InscripcionRequest;
import ec.edu.espe.arquitectura.prueba.dto.MatriculaResponse;
import ec.edu.espe.arquitectura.prueba.exception.ExistException;
import ec.edu.espe.arquitectura.prueba.exception.NotFoundException;
import ec.edu.espe.arquitectura.prueba.model.Curso;
import ec.edu.espe.arquitectura.prueba.model.CursoEstudiante;
import ec.edu.espe.arquitectura.prueba.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public void crearEstudiante(EstudianteRequest estudianteRequest) {

        Optional<Estudiante> estudianteOptional = this.estudianteRepository.findByCorreo(estudianteRequest.getCorreo());

        if (estudianteOptional.isPresent()) {
            throw new RuntimeException("Estudiante ya registrado");
        }

        Estudiante estudiante = Estudiante.builder()
                .nombre(estudianteRequest.getNombre())
                .correo(estudianteRequest.getCorreo())
                .pais(estudianteRequest.getPais())
                .fechaNacimiento(estudianteRequest.getFechaNacimiento())
                .fechaCreacion(new Date())
                .estado("ACT")
                .build();

        this.estudianteRepository.save(estudiante);
    }


    public MatriculaResponse inscribirCurso(InscripcionRequest inscripcionRequest) {

        Optional<Estudiante> estudianteOptional = this.estudianteRepository.findById(inscripcionRequest.getEstudianteId());

        if (estudianteOptional.isEmpty()) {
            throw new NotFoundException("Estudiante no encontrado");
        }

        Optional<Curso> cursoOptional = this.cursoRepository.findById(inscripcionRequest.getCursoId());

        if (cursoOptional.isEmpty()) {
            throw new NotFoundException("Curso no encontrado");
        }

        Estudiante estudiante = estudianteOptional.get();

        List<CursoEstudiante> cursos = estudiante.getCursos();

        for (CursoEstudiante curso : cursos) {

            if (curso.getEstado() == "ACT") {
                throw new ExistException("Actualmente ya esta tomando un curso");
            }
        }
        CursoEstudiante cursoEstudiante = CursoEstudiante.builder()
                .cursoId(cursoOptional.get().getId())
                .estado("ACT")
                .build();

        cursos.add(cursoEstudiante);
        estudiante.setCursos(cursos);
        this.estudianteRepository.save(estudiante);

        return matriculaInfo(estudiante, cursoOptional.get());

    }


    private MatriculaResponse matriculaInfo(Estudiante estudiante, Curso curso){

        MatriculaResponse matriculaResponse = MatriculaResponse.builder()
                .codigoCurso(curso.getCodigo())
                .areaCurso(curso.getArea())
                .nombreCurso(curso.getNombre())
                .nombreEstudiante(estudiante.getNombre())
                .correoEstudiante(estudiante.getCorreo())
                .paisEstudiante(estudiante.getPais())
                .build();

        return matriculaResponse;
    }
}
