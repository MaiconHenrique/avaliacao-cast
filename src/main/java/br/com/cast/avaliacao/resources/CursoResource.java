package br.com.cast.avaliacao.resources;

import br.com.cast.avaliacao.models.Curso;
import br.com.cast.avaliacao.repository.CursoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST CURSOS")
@CrossOrigin(origins = "*")
public class CursoResource {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping("/cursos")
    @ApiOperation(value = "RETORNA UMA LISTA DE CURSOS")
    public List<Curso> listCursos() {
        return  cursoRepository.findAll();
    }

    @GetMapping("/curso/{id}")
    @ApiOperation(value = "RETORNA UM UNICO CURSOS POR ID")
    public Curso curso(@PathVariable(value = "id") long id) {
        return  cursoRepository.findById(id);
    }

    @PostMapping("/curso")
    @ApiOperation(value = "SALVA UM CURSOS")
    public ResponseEntity salvarCurso(@RequestBody Curso curso) {
        try
        {
            boolean validate = this.validateData(curso);
            if(validate){
                cursoRepository.save(curso);
                return ResponseEntity.status(HttpStatus.OK).body(curso);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Periodo invalido");
            }

        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar um curso");
        }
    }

    @DeleteMapping("/curso/{id}")
    @ApiOperation(value = "DELETA UM CURSOS")
    public void deletaCurso(@PathVariable(value = "id") long id) {
        cursoRepository.deleteById(id);
    }

    @PutMapping("/curso")
    @ApiOperation(value = "ATUALIZA UM CURSOS")
    public ResponseEntity atualizaCurso(@RequestBody Curso curso) {
        try
        {
            cursoRepository.save(curso);
            return ResponseEntity.status(HttpStatus.OK).body(curso);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar um curso");
        }
    }

    public boolean validateData (Curso curso) {

        List<Curso> cursoPeriodo = cursoRepository.findByDateBetween(curso.getDatainicio(), curso.getDatatermino());
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        LocalDate date1 = LocalDate.parse(sqlDate.toString());
        Boolean validData = curso.getDatainicio().isAfter(date1);

        if(!validData){
            Boolean validDateAtual = curso.getDatainicio().equals(date1);
            if(validDateAtual && cursoPeriodo.size() <= 0) {
                return true;
            } else {
                return false;
            }
        } else if(cursoPeriodo.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
