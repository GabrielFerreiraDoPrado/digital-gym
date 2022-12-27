package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private MatriculaRepository repository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public Matricula create(MatriculaForm form) {
		Matricula matricula = new Matricula();
		matricula.setAluno(alunoRepository.findById(form.getAlunoId()).get());
		
		return repository.save(matricula);
	}

	@Override
	public Matricula get(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Matricula> getAll() {
		return repository.findAll();
	}

	@Override
	public void delete(Long id) {
		Matricula matricula = repository.findById(id).get();
		Aluno aluno = new Aluno();
		
		matricula.setAluno(aluno);
		
		repository.delete(matricula);		
	}
}
