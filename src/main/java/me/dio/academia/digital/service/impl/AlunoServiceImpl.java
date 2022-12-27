package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService{

	@Autowired
	private AlunoRepository repository;
	
	@Override
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataDeNascimento(form.getDataDeNascimento());
		
		return repository.save(aluno);
	}

	@Override
	public Aluno get(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Aluno> getAll() {
		return repository.findAll();
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		Aluno aluno = repository.findById(id).get();
		aluno.setNome(formUpdate.getNome());
		aluno.setBairro(formUpdate.getBairro());
		aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
		return repository.save(aluno);
	}

	@Override
	public void delete(Long id) {
		Aluno aluno = repository.findById(id).get();
		repository.delete(aluno);
	}

	@Override
	public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
		return repository.findById(id).get().getAvaliacoes();
	}
}
