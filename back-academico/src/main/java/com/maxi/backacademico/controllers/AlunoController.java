package com.maxi.backacademico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.backacademico.entities.Aluno;
import com.maxi.backacademico.services.AlunoService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping("/")
    public List<Aluno> listarAlunos(){
        return service.listarAlunos();
    }

    @GetMapping("/aluno/{id}")
    public ResponseEntity<?> listarAlunoPorId(@PathVariable Long id){
        return service.getAlunoPorId(id);
    }
    
    @PostMapping("/novo")
    public ResponseEntity<?> cadastrarAlunno(@RequestBody Aluno aluno){
        //Aluno novo = service.saveAluno(aluno);
        //sreturn new ResponseEntity<Aluno>(novo, HttpStatus.CREATED);
        return service.saveAluno(aluno);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarAluno(@RequestBody Aluno aluno){
        return service.updateAluno(aluno, aluno.getId());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deleteAluno(@PathVariable Long id){
        return service.deleteAluno(id);
    }

    /*
     * @PutMapping("/editar")
	public ResponseEntity<?> alterar(@RequestBody Categoria categoria){
		return cs.editar(categoria);
	}

	@GetMapping("/ordenar-none")
	public List<Categoria> listarCategoriasOrdenadaByNome(){
		return cs.listarCategoriaOrdenadaPorNome();
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<ExceptionEntity> remover(@PathVariable Long id){
		return cs.deletar(id);
	}
     */
}
