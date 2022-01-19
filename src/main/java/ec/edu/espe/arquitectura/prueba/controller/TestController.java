package ec.edu.espe.arquitectura.prueba.controller;

import ec.edu.espe.arquitectura.prueba.dto.PalabraRequest;
import ec.edu.espe.arquitectura.prueba.exception.NotFoundException;
import ec.edu.espe.arquitectura.prueba.model.Test;
import ec.edu.espe.arquitectura.prueba.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping
    public ResponseEntity guardarPalabra(@RequestBody PalabraRequest palabraRequest){
        try {
            this.testService.guardarPalabra(palabraRequest.getPalabra());
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{palabra}")
    public ResponseEntity getPalabra(@PathVariable String palabra){
        try{
            Test test = this.testService.buscarPalabra(palabra);
            return ResponseEntity.ok(test);
        } catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
