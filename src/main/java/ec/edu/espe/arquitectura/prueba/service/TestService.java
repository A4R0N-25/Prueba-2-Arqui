package ec.edu.espe.arquitectura.prueba.service;

import ec.edu.espe.arquitectura.prueba.dao.TestRepository;
import ec.edu.espe.arquitectura.prueba.exception.NotFoundException;
import ec.edu.espe.arquitectura.prueba.model.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public void guardarPalabra(String palabra){
        Test test = new Test();
        test.setPalabra(palabra);
        this.testRepository.save(test);
    }

    public Test buscarPalabra(String palabra){
        Optional<Test> optionalTest = this.testRepository.findByPalabra(palabra);
        log.info("PALABRA: {}",palabra);
        log.info("TODO: {}", this.testRepository.findAll());
        if(optionalTest.isEmpty()){
            return new Test();
            //throw new NotFoundException("No encotrado");
        }
        return optionalTest.get();
    }

}
