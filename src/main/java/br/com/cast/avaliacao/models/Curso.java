package br.com.cast.avaliacao.models;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="TB_CURSO")
public class Curso {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name="codigo")
    private Categoria categoria;

    @NotNull
    private String assunto;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate datainicio;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate datatermino;

    @NotNull
    private Integer qtdalunos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public LocalDate getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(LocalDate datainicio) {
        this.datainicio = datainicio;
    }

    public LocalDate getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(LocalDate datatermino) {
        this.datatermino = datatermino;
    }

    public Integer getQtdalunos() {
        return qtdalunos;
    }

    public void setQtdalunos(Integer qtdalunos) {
        this.qtdalunos = qtdalunos;
    }
}
