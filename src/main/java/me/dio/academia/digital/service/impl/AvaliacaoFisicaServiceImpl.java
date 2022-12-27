package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository repository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		
		avaliacaoFisica.setAluno(alunoRepository.findById(form.getAlunoId()).get());
		avaliacaoFisica.setAltura(form.getAltura());
		avaliacaoFisica.setPeso(form.getPeso());
		
		return repository.save(avaliacaoFisica);
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<AvaliacaoFisica> getAll() {
		return repository.findAll();
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		AvaliacaoFisica avaliacaoFisica = repository.findById(id).get();
		avaliacaoFisica.setAltura(formUpdate.getAltura());
		avaliacaoFisica.setPeso(formUpdate.getPeso());
		
		return repository.save(avaliacaoFisica);
	}

	@Override
	public void delete(Long id) {
		Aluno aluno = new Aluno();
		AvaliacaoFisica avaliacaoFisica = repository.findById(id).get();
		avaliacaoFisica.setAluno(aluno);
		repository.delete(avaliacaoFisica);
	}
}
