package com.rodrigo7prado.sisGestEduc.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.ComponenteCurricular;
import com.rodrigo7prado.sisGestEduc.entities.Curso;
import com.rodrigo7prado.sisGestEduc.entities.CursoModalidade;
import com.rodrigo7prado.sisGestEduc.entities.Disciplina;
import com.rodrigo7prado.sisGestEduc.entities.FiltroGrupo;
import com.rodrigo7prado.sisGestEduc.entities.FiltroItem;
import com.rodrigo7prado.sisGestEduc.entities.Modalidade;
import com.rodrigo7prado.sisGestEduc.entities.PeriodoCurricular;
import com.rodrigo7prado.sisGestEduc.entities.Turma;
import com.rodrigo7prado.sisGestEduc.repositories.ComponenteCurricularRepository;
import com.rodrigo7prado.sisGestEduc.repositories.CursoModalidadeRepository;
import com.rodrigo7prado.sisGestEduc.repositories.CursoRepository;
import com.rodrigo7prado.sisGestEduc.repositories.DisciplinaRepository;
import com.rodrigo7prado.sisGestEduc.repositories.FiltroGrupoRepository;
import com.rodrigo7prado.sisGestEduc.repositories.FiltroItemRepository;
import com.rodrigo7prado.sisGestEduc.repositories.ModalidadeRepository;
import com.rodrigo7prado.sisGestEduc.repositories.PeriodoCurricularRepository;
import com.rodrigo7prado.sisGestEduc.repositories.TurmaRepository;

@Service
public class DBService {
	
	@Autowired
	private FiltroGrupoRepository filtroGrupoRepository;
	@Autowired
	private FiltroItemRepository filtroItemRepository;
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

		PeriodoCurricular pc1 = new PeriodoCurricular(cm2,1);
		PeriodoCurricular pc2 = new PeriodoCurricular(cm2,2);
		PeriodoCurricular pc3 = new PeriodoCurricular(cm2,3);
		PeriodoCurricular pc4 = new PeriodoCurricular(cm3,1);
		PeriodoCurricular pc5 = new PeriodoCurricular(cm3,2);
		PeriodoCurricular pc6 = new PeriodoCurricular(cm3,3);
		PeriodoCurricular pc7 = new PeriodoCurricular(cm3,4);

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
		
		FiltroGrupo fg1 = new FiltroGrupo(null,"Todos os alunos");
		FiltroGrupo fg2 = new FiltroGrupo(null,"Últimos períodos curriculares");
		FiltroGrupo fg3 = new FiltroGrupo(null,"Concluintes");
		FiltroGrupo fg4 = new FiltroGrupo(null,"Todas as Certidões");
		FiltroGrupo fg5 = new FiltroGrupo(null,"Todos os Certificados");
		FiltroGrupo fg6 = new FiltroGrupo(null,"Todos ok");
		FiltroGrupo fg7 = new FiltroGrupo(null,"Quaisquer pendências");
		FiltroGrupo fg8 = new FiltroGrupo(null,"Pendência de dados pessoais");
		FiltroGrupo fg9 = new FiltroGrupo(null,"Pendência de dados escolares");
		FiltroGrupo fg10 = new FiltroGrupo(null,"Pendência de HE fund.");
		FiltroGrupo fg11 = new FiltroGrupo(null,"Pendência de HE médio");
		FiltroGrupo fg12 = new FiltroGrupo(null,"Diferenças c/ Conexão Educação");
		
		
		
		filtroGrupoRepository.saveAll(Arrays.asList(fg1,fg2,fg3,fg4,fg5,fg6,fg7,fg8,fg9,fg10,fg11,fg12));
		
		FiltroItem fi1 = new FiltroItem(null,fg1,"Todos os alunos");
		FiltroItem fi2 = new FiltroItem(null,fg2,"Últimos períodos curriculares");
		FiltroItem fi3 = new FiltroItem(null,fg3,"Concluintes");
		FiltroItem fi4 = new FiltroItem(null,fg4,"Todas as Certidões");
		FiltroItem fi5 = new FiltroItem(null,fg5,"Todas as Certidões");
		FiltroItem fi6 = new FiltroItem(null,fg6,"Todos ok");
		FiltroItem fi7 = new FiltroItem(null,fg7,"Quaisquer pendências");
		FiltroItem fi8 = new FiltroItem(null,fg8,"Pendências de dados pessoais");
		FiltroItem fi9 = new FiltroItem(null,fg8,"Pendência de [Matrícula]");
		FiltroItem fi10 = new FiltroItem(null,fg8,"Pendência de [Nome completo]");
		FiltroItem fi11 = new FiltroItem(null,fg8,"Pendência de [Data de Nascimento]");
		FiltroItem fi12 = new FiltroItem(null,fg8,"Pendência de [Nacionalidade]");
		FiltroItem fi13 = new FiltroItem(null,fg8,"Pendência de [Naturalidade]");
		FiltroItem fi14 = new FiltroItem(null,fg8,"Pendência de [Naturalidade UF]");
		FiltroItem fi15 = new FiltroItem(null,fg8,"Pendência de [Rg]");
		FiltroItem fi16 = new FiltroItem(null,fg8,"Pendência de [Rg emissor]");
		FiltroItem fi17 = new FiltroItem(null,fg8,"Pendência de [Rg emissor UF]");
		FiltroItem fi18 = new FiltroItem(null,fg8,"Pendência de [Rg]");
		FiltroItem fi19 = new FiltroItem(null,fg8,"Pendência de [Pai]");
		FiltroItem fi20 = new FiltroItem(null,fg8,"Pendência de [Mãe]");
		
		FiltroItem fi21 = new FiltroItem(null,fg9,"Pendênci de dados escolares");
		FiltroItem fi22 = new FiltroItem(null,fg10,"Pendência de HE fun.");
		FiltroItem fi23 = new FiltroItem(null,fg11,"Pendência de HE médio");
		FiltroItem fi24 = new FiltroItem(null,fg12,"Diferenças c/ Conexão Educação");

		
		
		filtroItemRepository.saveAll(Arrays.asList(fi1,fi2,fi3,fi4,fi5,fi6,fi7,fi8,fi9,fi10,fi11,fi12,fi13,fi14,fi15,fi16,fi17,fi18,fi19,fi20,fi21,fi22,fi23,fi24));
	}
}
