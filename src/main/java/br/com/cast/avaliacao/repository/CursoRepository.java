package br.com.cast.avaliacao.repository;

import br.com.cast.avaliacao.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findById(long id);

    @Query(value = "SELECT * FROM tb_curso c " +
            " WHERE c.datainicio >= :inicio and c.datatermino <= :fim", nativeQuery = true)
    List<Curso> findByDateBetween(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);

}