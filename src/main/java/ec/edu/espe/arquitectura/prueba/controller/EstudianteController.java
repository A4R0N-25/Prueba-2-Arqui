package ec.edu.espe.arquitectura.prueba.controller;

import ec.edu.espe.arquitectura.prueba.dto.EstudianteRequest;
import ec.edu.espe.arquitectura.prueba.dto.InscripcionRequest;
import ec.edu.espe.arquitectura.prueba.dto.MatriculaResponse;
import ec.edu.espe.arquitectura.prueba.exception.ExistException;
import ec.edu.espe.arquitectura.prueba.exception.NotFoundException;
import ec.edu.espe.arquitectura.prueba.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity registrarEstudiante(@RequestBody EstudianteRequest estudianteRequest){
        try {
            this.estudianteService.crearEstudiante(estudianteRequest);
            return ResponseEntity.ok().build();
        }catch (ExistException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/inscribirse")
    public ResponseEntity inscribirseCurso(@RequestBody InscripcionRequest inscripcionRequest){
        try{
            MatriculaResponse matricula = this.estudianteService.inscribirCurso(inscripcionRequest);
            return ResponseEntity.ok(matricula);
        }catch (ExistException | NotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
