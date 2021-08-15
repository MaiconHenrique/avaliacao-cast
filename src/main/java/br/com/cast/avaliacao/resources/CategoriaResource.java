package br.com.cast.avaliacao.resources;

import br.com.cast.avaliacao.models.Categoria;
import br.com.cast.avaliacao.repository.CategoriaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST CURSOS")
@CrossOrigin(origins = "*")
public class CategoriaResource {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    @ApiOperation(value = "RETORNA UMA LISTA DE CATEGORIAS")
    public List<Categoria> listCursos() {
        return  categoriaRepository.findAll();
    }

    @GetMapping("/categoria/{id}")
    @ApiOperation(value = "RETORNA UMA UNICA CATEGORIA POR ID")
    public Categoria categoria(@PathVariable(value = "id") long id) {
        return  categoriaRepository.findById(id);
    }
}
