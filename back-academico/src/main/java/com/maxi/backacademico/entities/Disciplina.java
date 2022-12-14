package com.maxi.backacademico.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="disciplinas")
public class Disciplina {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer semestre;
    private String professor;

    @ManyToMany
    @JoinTable(name="disciplina_alunos",
                joinColumns = @JoinColumn(name="disciplina_fk"),
                inverseJoinColumns = @JoinColumn(name="aluno_fk"))
    private Set<Aluno> alunos;

    /*https://www.youtube.com/watch?v=GjznpjcNDlA */
    public Disciplina() {
    }


    public Disciplina(String nome, Integer semestre, String professor) {
        this.nome = nome;
        this.semestre = semestre;
        this.professor = professor;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Disciplina other = (Disciplina) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public Integer getSemestre() {
        return semestre;
    }


    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }


    public String getProfessor() {
        return professor;
    }


    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    
    
    
    
}
