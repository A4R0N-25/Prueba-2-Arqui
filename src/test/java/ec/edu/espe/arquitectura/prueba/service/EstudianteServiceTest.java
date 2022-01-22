package ec.edu.espe.arquitectura.prueba.service;

import ec.edu.espe.arquitectura.prueba.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.prueba.dto.EstudianteRequest;
import ec.edu.espe.arquitectura.prueba.dto.InscripcionRequest;
import ec.edu.espe.arquitectura.prueba.dto.MatriculaResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EstudianteServiceTest {

    @Mock
    private EstudianteService estudianteService;

    @Mock
    private EstudianteRepository estudianteRepository;

    private EstudianteRequest estudianteRequest;

    private InscripcionRequest inscripcionRequest;

    private MatriculaResponse matriculaResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        estudianteRequest = new EstudianteRequest();
        estudianteRequest.setNombre("Brandon");
        estudianteRequest.setCorreo("baromero6@espe.edu.ec");
        estudianteRequest.setFechaNacimiento(new Date());

        inscripcionRequest = new InscripcionRequest();
        inscripcionRequest.setEstudianteId("61eb66cf1c36c5174eed3e8c");
        inscripcionRequest.setCursoId("61e8547b68d1bf7449b4fde7");

        matriculaResponse = MatriculaResponse.builder()
                .codigoCurso("100")
                .areaCurso("ECU")
                .nombreCurso("Programacion Orientada a Objetos")
                .nombreEstudiante("Brandon")
                .correoEstudiante("baromero6@espe.edu.ec")
                .paisEstudiante("ECU")
                .build();
    }

    @Test
    void crearEstudiante() {
        doNothing().when(estudianteService).crearEstudiante(estudianteRequest);
        estudianteService.crearEstudiante(estudianteRequest);
        verify(estudianteService, times(1)).crearEstudiante(estudianteRequest);
    }

    @Test
    void inscribirCurso() {
        assertEquals(estudianteService.inscribirCurso(inscripcionRequest),matriculaResponse);
    }
}