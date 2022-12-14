package com.maxi.backacademico.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.backacademico.entities.Aluno;

//@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {


    List<Aluno> buscarAlunoPorNome(String nome);
    Set<Aluno> listarAlunoCursoByMatricula(String matricula);
    
}
