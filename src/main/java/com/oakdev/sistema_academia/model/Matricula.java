package com.oakdev.sistema_academia.model;

import com.oakdev.sistema_academia.enums.StatusMatriculaEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_matricula")
    private LocalDate dataMatricula;

    @Column(name = "data_vencimento")
    private Integer dataVencimento;

    @Column(name = "data_encerramento")
    private Integer dataEncerramento;

    @Enumerated(EnumType.STRING)
    private StatusMatriculaEnum status = StatusMatriculaEnum.ATIVA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @PrePersist
    public void prePersist(){
        if (dataMatricula == null) {

            dataMatricula = LocalDate.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Integer getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Integer dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Integer getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Integer dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public StatusMatriculaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusMatriculaEnum status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
