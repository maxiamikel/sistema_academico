package com.maxi.backacademico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maxi.backacademico.entities.Aluno;
import com.maxi.backacademico.entities.exceptions.EntityException;
import com.maxi.backacademico.repositories.AlunoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AlunoService {

    @Autowired
    private AlunoRepository repo;

    @Autowired
    private EntityException exception;

    public List<Aluno> listarAlunos(){
      return repo.findAll();
    }

    public ResponseEntity<?> getAlunoPorId(Long id){
        if(!repo.findById(id).isPresent()){
            exception.setMessagem("O ID "+id+"  informado não existe");
            return new ResponseEntity<EntityException>(exception,HttpStatus.NOT_FOUND);
        }
        else{
            Aluno oAluno = repo.findById(id).get();
            return new ResponseEntity<Aluno>(oAluno,HttpStatus.OK);
        }
    }

    public ResponseEntity<?> saveAluno(Aluno novoAluno){
        if(novoAluno.getCpf().equals("")){
            exception.setMessagem("O CPF do Aluno é obligatorio");
            return new ResponseEntity<EntityException>(exception, HttpStatus.BAD_REQUEST);
        }else if(novoAluno.getNome().equals("")){
            exception.setMessagem("O Nome do aluno é obligatorio");
            return new ResponseEntity<EntityException>(exception, HttpStatus.BAD_REQUEST);
        }else{
            Aluno aluno = repo.save(novoAluno);
            return new ResponseEntity<Aluno>(aluno, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> updateAluno(Aluno aluno,Long id){
        if(!repo.findById(id).isPresent()){
            exception.setMessagem("O ID" +id+" informado é inválido");
            return new ResponseEntity<EntityException>(exception, HttpStatus.BAD_REQUEST);
        }else{
            Aluno alunoAtualizado = repo.findById(id).get();
            alunoAtualizado.setCpf(aluno.getCpf());
            alunoAtualizado.setMatricula(aluno.getMatricula());
            alunoAtualizado.setNome(aluno.getNome());
            alunoAtualizado.setNascimento(aluno.getNascimento());
            alunoAtualizado.setNacionalidade(aluno.getNacionalidade());
            alunoAtualizado.setDataInscricao(aluno.getDataInscricao());
            alunoAtualizado.setCurso(aluno.getCurso());
            alunoAtualizado.setGenero(aluno.getGenero());
            repo.saveAndFlush(alunoAtualizado);
            return new ResponseEntity<Aluno>(alunoAtualizado, HttpStatus.OK);
        }
    }


    public ResponseEntity<?> deleteAluno(Long id){
        Optional<Aluno> aluno = repo.findById(id);
        if(!aluno.isPresent()){
            exception.setMessagem("O ID ["+id+"] informado não existe. Não é possivel efetuar sua petição");
            return new ResponseEntity<EntityException>(exception, HttpStatus.BAD_REQUEST);
        }else{
            repo.deleteById(id);
            exception.setMessagem("O aluno com ID ["+id+"] foi eliminado com sucesso!");
            return  new ResponseEntity<EntityException>(exception, HttpStatus.OK);
        }
    }


   
    
}
