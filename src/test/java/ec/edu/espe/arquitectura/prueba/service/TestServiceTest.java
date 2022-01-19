package ec.edu.espe.arquitectura.prueba.service;

import ec.edu.espe.arquitectura.prueba.dao.TestRepository;
import ec.edu.espe.arquitectura.prueba.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@AutoConfigureDataMongo
class TestServiceTest {


    @InjectMocks
    private TestService testService;

    @Mock
    private TestRepository testRepository;

    private ec.edu.espe.arquitectura.prueba.model.Test test;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        this.test = new ec.edu.espe.arquitectura.prueba.model.Test("61e8510f53458d4df423a3d6","juan");
    }

    @Test
    void guardarPalabra() {
        //TestService testService = mock(TestService.class);
        doNothing().when(testService).guardarPalabra("Juan");
        testService.guardarPalabra("Juan");
        verify(testService, times(1)).guardarPalabra("Juan");
    }

    @Test
    void buscarPalabra() {
        //when(testService.buscarPalabra("brandon")).thenReturn(test);
        ec.edu.espe.arquitectura.prueba.model.Test prueba = testService.buscarPalabra("brandon");
        assertEquals(test,prueba);
    }
}