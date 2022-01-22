package ec.edu.espe.arquitectura.prueba.controller;

import ec.edu.espe.arquitectura.prueba.model.Curso;
import ec.edu.espe.arquitectura.prueba.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/{area}/{nombre}")
    public ResponseEntity buscarCurso(@PathVariable String area, @PathVariable String nombre){
        try {
            List<Curso> cursos = this.cursoService.consultarCursos(area,nombre);
            return ResponseEntity.ok(cursos);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
