package com.rodrigo7prado.sisGestEduc.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.ComponenteCurricular;
import com.rodrigo7prado.sisGestEduc.entities.Curso;
import com.rodrigo7prado.sisGestEduc.entities.CursoModalidade;
import com.rodrigo7prado.sisGestEduc.entities.Disciplina;
import com.rodrigo7prado.sisGestEduc.entities.Modalidade;
import com.rodrigo7prado.sisGestEduc.entities.PeriodoCurricular;
import com.rodrigo7prado.sisGestEduc.entities.Turma;
import com.rodrigo7prado.sisGestEduc.repositories.ComponenteCurricularRepository;
import com.rodrigo7prado.sisGestEduc.repositories.CursoModalidadeRepository;
import com.rodrigo7prado.sisGestEduc.repositories.CursoRepository;
import com.rodrigo7prado.sisGestEduc.repositories.DisciplinaRepository;
import com.rodrigo7prado.sisGestEduc.repositories.ModalidadeRepository;
import com.rodrigo7prado.sisGestEduc.repositories.PeriodoCurricularRepository;
import com.rodrigo7prado.sisGestEduc.repositories.TurmaRepository;

@Service
public class DBService {

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private ModalidadeRepository modalidadeRepository;
	
	@Autowired
	private CursoModalidadeRepository cursoModalidadeRepository;

	@Autowired
	private PeriodoCurricularRepository periodoCurricularRepository;

	@Autowired
	private ComponenteCurricularRepository componenteCurricularRepository;

	public void instanciateTestDatabase() {

		Turma t1 = new Turma(null, "3001");

		Disciplina d1 = new Disciplina(null, "Língua Portuguesa");
		Disciplina d2 = new Disciplina(null, "Matemática");
		Disciplina d3 = new Disciplina(null, "Física");
		Disciplina d4 = new Disciplina(null, "Química");
		Disciplina d5 = new Disciplina(null, "Biologia");
		Disciplina d6 = new Disciplina(null, "Geografia");
		Disciplina d7 = new Disciplina(null, "Artes");
		Disciplina d8 = new Disciplina(null, "História");
		Disciplina d9 = new Disciplina(null, "Filosofia");
		Disciplina d10 = new Disciplina(null, "Sociologia");
		Disciplina d11 = new Disciplina(null, "Educação Física");
		Disciplina d12 = new Disciplina(null, "Língua Inglesa");

		Curso c1 = new Curso(null, "Ensino Fundamental");
		Curso c2 = new Curso(null, "Ensino Médio");

		Modalidade m1 = new Modalidade(null, "Regular", c2);
		Modalidade m2 = new Modalidade(null, "EJA", c2);
		
		CursoModalidade cm1 = new CursoModalidade(c1,m1);
		CursoModalidade cm2 = new CursoModalidade(c2,m1);
		CursoModalidade cm3 = new CursoModalidade(c2,m2);

		PeriodoCurricular pc1 = new PeriodoCurricular(cm2,"1ª série");
		PeriodoCurricular pc2 = new PeriodoCurricular(cm2, "2ª série");
		PeriodoCurricular pc3 = new PeriodoCurricular(cm2, "3ª série");
		PeriodoCurricular pc4 = new PeriodoCurricular(cm3, "Módulo I");
		PeriodoCurricular pc5 = new PeriodoCurricular(cm3, "Módulo II");
		PeriodoCurricular pc6 = new PeriodoCurricular(cm3, "Módulo III");
		PeriodoCurricular pc7 = new PeriodoCurricular(cm3, "Módulo IV");

		ComponenteCurricular cc1 = new ComponenteCurricular(pc1, d1);
		ComponenteCurricular cc2 = new ComponenteCurricular(pc1, d2);
		ComponenteCurricular cc3 = new ComponenteCurricular(pc1, d3);
		ComponenteCurricular cc4 = new ComponenteCurricular(pc1, d4);
		ComponenteCurricular cc5 = new ComponenteCurricular(pc1, d5);
		ComponenteCurricular cc6 = new ComponenteCurricular(pc1, d6);
		ComponenteCurricular cc7 = new ComponenteCurricular(pc1, d8);
		ComponenteCurricular cc8 = new ComponenteCurricular(pc1, d9);
		ComponenteCurricular cc9 = new ComponenteCurricular(pc1, d10);
		ComponenteCurricular cc10 = new ComponenteCurricular(pc1, d11);
		ComponenteCurricular cc11 = new ComponenteCurricular(pc1, d12);
		ComponenteCurricular cc12 = new ComponenteCurricular(pc2, d1);
		ComponenteCurricular cc13 = new ComponenteCurricular(pc2, d2);
		ComponenteCurricular cc14 = new ComponenteCurricular(pc2, d3);
		ComponenteCurricular cc15 = new ComponenteCurricular(pc2, d4);
		ComponenteCurricular cc16 = new ComponenteCurricular(pc2, d5);
		ComponenteCurricular cc17 = new ComponenteCurricular(pc2, d6);
		ComponenteCurricular cc18 = new ComponenteCurricular(pc2, d7);
		ComponenteCurricular cc19 = new ComponenteCurricular(pc2, d8);
		ComponenteCurricular cc20 = new ComponenteCurricular(pc2, d9);
		ComponenteCurricular cc21 = new ComponenteCurricular(pc2, d10);
		ComponenteCurricular cc22 = new ComponenteCurricular(pc2, d11);
		ComponenteCurricular cc23 = new ComponenteCurricular(pc2, d12);
		ComponenteCurricular cc24 = new ComponenteCurricular(pc3, d1);
		ComponenteCurricular cc25 = new ComponenteCurricular(pc3, d2);
		ComponenteCurricular cc26 = new ComponenteCurricular(pc3, d3);
		ComponenteCurricular cc27 = new ComponenteCurricular(pc3, d4);
		ComponenteCurricular cc28 = new ComponenteCurricular(pc3, d5);
		ComponenteCurricular cc29 = new ComponenteCurricular(pc3, d6);
		ComponenteCurricular cc30 = new ComponenteCurricular(pc3, d7);
		ComponenteCurricular cc31 = new ComponenteCurricular(pc3, d8);
		ComponenteCurricular cc32 = new ComponenteCurricular(pc3, d9);
		ComponenteCurricular cc33 = new ComponenteCurricular(pc3, d10);
		ComponenteCurricular cc34 = new ComponenteCurricular(pc3, d11);
		ComponenteCurricular cc35 = new ComponenteCurricular(pc3, d12);

		turmaRepository.saveAll(Arrays.asList(t1));
		disciplinaRepository.saveAll(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12));
		cursoRepository.saveAll(Arrays.asList(c1,c2));
		modalidadeRepository.saveAll(Arrays.asList(m1, m2));
		
		cursoModalidadeRepository.saveAll(Arrays.asList(cm1,cm2,cm3));
		System.out.println("pc1" + pc1);
		periodoCurricularRepository.saveAll(Arrays.asList(pc1, pc2, pc3, pc4, pc5, pc6, pc7));
		componenteCurricularRepository.saveAll(Arrays.asList(cc1, cc2, cc3, cc4, cc5, cc6, cc7, cc8, cc9, cc10, cc11,
				cc12, cc13, cc14, cc15, cc16, cc17, cc18, cc19, cc20, cc21, cc22, cc23, cc24, cc25, cc26, cc27, cc28,
				cc29, cc30, cc31, cc32, cc33, cc34, cc35));
	}
}
