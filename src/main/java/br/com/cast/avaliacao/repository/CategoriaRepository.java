package br.com.cast.avaliacao.repository;

import br.com.cast.avaliacao.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findById(long id);

}
