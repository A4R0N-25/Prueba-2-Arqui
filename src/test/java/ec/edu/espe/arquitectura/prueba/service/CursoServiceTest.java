package ec.edu.espe.arquitectura.prueba.service;

import ec.edu.espe.arquitectura.prueba.dao.CursoRepository;
import ec.edu.espe.arquitectura.prueba.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.prueba.model.Curso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CursoServiceTest {

    private

    @InjectMocks
    private CursoService cursoService;

    @Mock
    private CursoRepository cursoRepository;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void consultarCursos() {
        when(cursoService.consultarCursos("ECU", "Progra")).thenReturn(List.of(Curso.class));
    }
}