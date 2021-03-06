package com.rodrigo7prado.sisGestEduc.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.entities.ComponenteCurricular;
import com.rodrigo7prado.sisGestEduc.entities.Curso;
import com.rodrigo7prado.sisGestEduc.entities.CursoModalidade;
import com.rodrigo7prado.sisGestEduc.entities.Disciplina;
import com.rodrigo7prado.sisGestEduc.entities.FiltroGrupo;
import com.rodrigo7prado.sisGestEduc.entities.FiltroItem;
import com.rodrigo7prado.sisGestEduc.entities.Modalidade;
import com.rodrigo7prado.sisGestEduc.entities.PeriodoCurricular;
import com.rodrigo7prado.sisGestEduc.entities.Turma;
import com.rodrigo7prado.sisGestEduc.repositories.AlunoRepository;
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
	private AlunoRepository alunoRepository;
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

		Aluno a1 = new Aluno("1111", "Alanderson", "2001");

//		alunoRepository.save(a1);

		Turma t1 = new Turma(null, "3001");

		Disciplina d1 = new Disciplina(null, "Língua Portuguesa", "LÍNGUA PORTUGUESA/LITERATURA");
		Disciplina d2 = new Disciplina(null, "Matemática", "MATEMÁTICA");
		Disciplina d3 = new Disciplina(null, "Física", "FÍSICA");
		Disciplina d4 = new Disciplina(null, "Química", "QUÍMICA");
		Disciplina d5 = new Disciplina(null, "Biologia", "BIOLOGIA");
		Disciplina d6 = new Disciplina(null, "Geografia", "GEOGRAFIA");
		Disciplina d7 = new Disciplina(null, "Artes", "ARTE");
		Disciplina d8 = new Disciplina(null, "História", "HISTÓRIA");
		Disciplina d9 = new Disciplina(null, "Filosofia", "FILOSOFIA");
		Disciplina d10 = new Disciplina(null, "Sociologia", "SOCIOLOGIA");
		Disciplina d11 = new Disciplina(null, "Educação Física", "EDUCAÇÃO FÍSICA");
		Disciplina d12 = new Disciplina(null, "Língua Inglesa", "LÍNGUA ESTRANGEIRA - INGLES");
		Disciplina d13 = new Disciplina(null, "Língua Espanhola", "LÍNGUA ESTRANGEIRA - ESPANHOL");
		Disciplina d14 = new Disciplina(null, "Língua Francesa", "LÍNGUA ESTRANGEIRA - FRANCĘS");
		Disciplina d15 = new Disciplina(null, "Língua Estrangeira Obrigatória", "LÍNGUA ESTRANGEIRA OBRIGATÓRIA");
		Disciplina d16 = new Disciplina(null, "Língua Inglesa", "LÍNGUA ESTRANGEIRA - INGLĘS");
		Disciplina d17 = new Disciplina(null, "Leitura e Produção Textual", "LEITURA E PRODUÇĂO TEXTUAL");
		Disciplina d18 = new Disciplina(null, "Produção Textual", "PRODUÇĂO TEXTUAL");
		Disciplina d19 = new Disciplina(null, "Resolução de Problemas Matemáticos",
				"RESOLUÇĂO DE PROBLEMAS MATEMÁTICOS");
		Disciplina d20 = new Disciplina(null, "Ensino Religioso", "ENSINO RELIGIOSO");

		Curso c1 = new Curso(null, "Ensino Fundamental", "Curso: ENSINO FUNDAMENTAL", "ENSINO FUNDAMENTAL");
		Curso c2 = new Curso(null, "Ensino Médio", "Curso: ENSINO MÉDIO", "ENSINO MÉDIO");
		Curso c3 = new Curso(null, "EJA Ensino Médio", "Curso: EJA ENSINO MÉDIO", "EJA ENSINO MÉDIO");

		Modalidade m1 = new Modalidade(null, "Regular", c2, "Modalidade: REGULAR", "REGULAR");
		Modalidade m2 = new Modalidade(null, "EJA", c2, "Modalidade: EJA", "EJA");
		Modalidade m3 = new Modalidade(null, "NEJA", c3, "Modalidade: NOVA EDUCAÇĂO DE JOVENS E ADULTOS",
				"NOVA EDUCAÇĂO DE JOVENS E ADULTOS");

		CursoModalidade cm1 = new CursoModalidade(c1, m1);
		CursoModalidade cm2 = new CursoModalidade(c2, m1);
		CursoModalidade cm3 = new CursoModalidade(c2, m2);
		CursoModalidade cm4 = new CursoModalidade(c3, m3);

		PeriodoCurricular pc1 = new PeriodoCurricular(cm2, 1L);
		PeriodoCurricular pc2 = new PeriodoCurricular(cm2, 2L);
		PeriodoCurricular pc3 = new PeriodoCurricular(cm2, 3L);
		PeriodoCurricular pc4 = new PeriodoCurricular(cm4, 1L);
		PeriodoCurricular pc5 = new PeriodoCurricular(cm4, 2L);
		PeriodoCurricular pc6 = new PeriodoCurricular(cm4, 3L);
		PeriodoCurricular pc7 = new PeriodoCurricular(cm4, 4L);

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
		ComponenteCurricular cc12 = new ComponenteCurricular(pc1, d13);
		ComponenteCurricular cc13 = new ComponenteCurricular(pc1, d14);
		ComponenteCurricular cc14 = new ComponenteCurricular(pc1, d16);
		ComponenteCurricular cc15 = new ComponenteCurricular(pc2, d1);
		ComponenteCurricular cc16 = new ComponenteCurricular(pc2, d2);
		ComponenteCurricular cc17 = new ComponenteCurricular(pc2, d3);
		ComponenteCurricular cc18 = new ComponenteCurricular(pc2, d4);
		ComponenteCurricular cc19 = new ComponenteCurricular(pc2, d5);
		ComponenteCurricular cc20 = new ComponenteCurricular(pc2, d6);
		ComponenteCurricular cc21 = new ComponenteCurricular(pc2, d7);
		ComponenteCurricular cc22 = new ComponenteCurricular(pc2, d8);
		ComponenteCurricular cc23 = new ComponenteCurricular(pc2, d9);
		ComponenteCurricular cc24 = new ComponenteCurricular(pc2, d10);
		ComponenteCurricular cc25 = new ComponenteCurricular(pc2, d11);
		ComponenteCurricular cc26 = new ComponenteCurricular(pc2, d12);
		ComponenteCurricular cc27 = new ComponenteCurricular(pc2, d13);
		ComponenteCurricular cc28 = new ComponenteCurricular(pc2, d14);
		ComponenteCurricular cc29 = new ComponenteCurricular(pc2, d16);
		ComponenteCurricular cc30 = new ComponenteCurricular(pc2, d19);
		ComponenteCurricular cc31 = new ComponenteCurricular(pc3, d1);
		ComponenteCurricular cc32 = new ComponenteCurricular(pc3, d2);
		ComponenteCurricular cc33 = new ComponenteCurricular(pc3, d3);
		ComponenteCurricular cc34 = new ComponenteCurricular(pc3, d4);
		ComponenteCurricular cc35 = new ComponenteCurricular(pc3, d5);
		ComponenteCurricular cc36 = new ComponenteCurricular(pc3, d6);
		ComponenteCurricular cc37 = new ComponenteCurricular(pc3, d7);
		ComponenteCurricular cc38 = new ComponenteCurricular(pc3, d8);
		ComponenteCurricular cc39 = new ComponenteCurricular(pc3, d9);
		ComponenteCurricular cc40 = new ComponenteCurricular(pc3, d10);
		ComponenteCurricular cc41 = new ComponenteCurricular(pc3, d11);
		ComponenteCurricular cc42 = new ComponenteCurricular(pc3, d12);
		ComponenteCurricular cc43 = new ComponenteCurricular(pc3, d13);
		ComponenteCurricular cc44 = new ComponenteCurricular(pc3, d14);
		ComponenteCurricular cc45 = new ComponenteCurricular(pc3, d16);
		ComponenteCurricular cc46 = new ComponenteCurricular(pc3, d17);
		ComponenteCurricular cc47 = new ComponenteCurricular(pc3, d18);
		ComponenteCurricular cc48 = new ComponenteCurricular(pc4, d1);
		ComponenteCurricular cc49 = new ComponenteCurricular(pc4, d2);
		ComponenteCurricular cc50 = new ComponenteCurricular(pc4, d6);
		ComponenteCurricular cc51 = new ComponenteCurricular(pc4, d8);
		ComponenteCurricular cc52 = new ComponenteCurricular(pc4, d9);
		ComponenteCurricular cc53 = new ComponenteCurricular(pc4, d10);
		ComponenteCurricular cc54 = new ComponenteCurricular(pc4, d20);
		ComponenteCurricular cc55 = new ComponenteCurricular(pc5, d1);
		ComponenteCurricular cc56 = new ComponenteCurricular(pc5, d2);
		ComponenteCurricular cc57 = new ComponenteCurricular(pc5, d3);
		ComponenteCurricular cc58 = new ComponenteCurricular(pc5, d4);
		ComponenteCurricular cc59 = new ComponenteCurricular(pc5, d5);
		ComponenteCurricular cc60 = new ComponenteCurricular(pc6, d1);
		ComponenteCurricular cc61 = new ComponenteCurricular(pc6, d2);
		ComponenteCurricular cc62 = new ComponenteCurricular(pc6, d6);
		ComponenteCurricular cc63 = new ComponenteCurricular(pc6, d8);
		ComponenteCurricular cc64 = new ComponenteCurricular(pc6, d9);
		ComponenteCurricular cc65 = new ComponenteCurricular(pc6, d10);
		ComponenteCurricular cc66 = new ComponenteCurricular(pc6, d11);
		ComponenteCurricular cc67 = new ComponenteCurricular(pc7, d1);
		ComponenteCurricular cc68 = new ComponenteCurricular(pc7, d2);
		ComponenteCurricular cc69 = new ComponenteCurricular(pc7, d3);
		ComponenteCurricular cc70 = new ComponenteCurricular(pc7, d4);
		ComponenteCurricular cc71 = new ComponenteCurricular(pc7, d5);
		ComponenteCurricular cc72 = new ComponenteCurricular(pc7, d7);
		ComponenteCurricular cc73 = new ComponenteCurricular(pc7, d15);
		ComponenteCurricular cc74 = new ComponenteCurricular(pc7, d16);

		turmaRepository.saveAll(Arrays.asList(t1));
		disciplinaRepository.saveAll(
				Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d19, d20));
		cursoRepository.saveAll(Arrays.asList(c1, c2, c3));
		modalidadeRepository.saveAll(Arrays.asList(m1, m2, m3));

		cursoModalidadeRepository.saveAll(Arrays.asList(cm1, cm2, cm3, cm4));
		System.out.println("pc1" + pc1);
		periodoCurricularRepository.saveAll(Arrays.asList(pc1, pc2, pc3, pc4, pc5, pc6, pc7));
		componenteCurricularRepository.saveAll(Arrays.asList(cc1, cc2, cc3, cc4, cc5, cc6, cc7, cc8, cc9, cc10, cc11,
				cc12, cc13, cc14, cc15, cc16, cc17, cc18, cc19, cc20, cc21, cc22, cc23, cc24, cc25, cc26, cc27, cc28,
				cc29, cc30, cc31, cc32, cc33, cc34, cc35, cc36, cc37, cc38, cc39, cc40, cc41, cc42, cc43, cc44, cc45,
				cc46, cc47, cc48, cc49, cc50, cc51, cc52, cc53, cc54, cc55, cc56, cc57, cc58, cc59, cc60, cc61, cc62,
				cc63, cc64, cc65, cc66, cc67, cc68, cc69, cc70, cc71, cc72, cc73, cc74));

		FiltroGrupo fg1 = new FiltroGrupo(null, "Todos os alunos (2018)");
		FiltroGrupo fg2 = new FiltroGrupo(null, "Períodos curriculares finais");
		FiltroGrupo fg3 = new FiltroGrupo(null, "Concluintes");
		FiltroGrupo fg4 = new FiltroGrupo(null, "Concl. c/ certid. e certif.");
		FiltroGrupo fg5 = new FiltroGrupo(null, "Concluintes sem emissão");
		FiltroGrupo fg6 = new FiltroGrupo(null, "Todas as Certidões");

		FiltroGrupo fg7 = new FiltroGrupo(null, "Concluintes c/ Certidão s/ Certificado");
		FiltroGrupo fg8 = new FiltroGrupo(null, "Todos os Certificados");
		FiltroGrupo fg9 = new FiltroGrupo(null, "Turmas completas");
		FiltroGrupo fg10 = new FiltroGrupo(null, "-");
		FiltroGrupo fg11 = new FiltroGrupo(null, "-");
		FiltroGrupo fg12 = new FiltroGrupo(null, "Todos ok");
		FiltroGrupo fg13 = new FiltroGrupo(null, "Quaisquer pendências");
		FiltroGrupo fg14 = new FiltroGrupo(null, "Pendência de dados pessoais");
		FiltroGrupo fg15 = new FiltroGrupo(null, "Pendência de dados escolares");
		FiltroGrupo fg16 = new FiltroGrupo(null, "Pendência de HE fund.");
		FiltroGrupo fg17 = new FiltroGrupo(null, "Pendência de HE médio");
		FiltroGrupo fg18 = new FiltroGrupo(null, "Diferenças c/ Conexão Educação");

		filtroGrupoRepository.saveAll(Arrays.asList(fg1, fg2, fg3, fg4, fg5, fg6, fg7, fg8, fg9, fg10, fg11, fg12, fg13,
				fg14, fg15, fg16, fg17, fg18));

		FiltroItem fi1 = new FiltroItem(null, fg1, "Todos os alunos");
		FiltroItem fi2 = new FiltroItem(null, fg2, "Períodos/anos finais");
		FiltroItem fi3 = new FiltroItem(null, fg3, "Concluintes");
		FiltroItem fi4 = new FiltroItem(null, fg4, "Concluintes sem emissão");
		FiltroItem fi5 = new FiltroItem(null, fg5, "Concl. c/ Certid. e Certif.");
		FiltroItem fi6 = new FiltroItem(null, fg6, "Emissões de Certidões");

		FiltroItem fi7 = new FiltroItem(null, fg7, "Concl. c/ Certid. sem Certif.");
		FiltroItem fi8 = new FiltroItem(null, fg8, "Emissões de Certificados");
		FiltroItem fi9 = new FiltroItem(null, fg9, "Turma completas");
		FiltroItem fi10 = new FiltroItem(null, fg10, "-");
		FiltroItem fi11 = new FiltroItem(null, fg11, "-");

		FiltroItem fi12 = new FiltroItem(null, fg12, "Todos ok");
		FiltroItem fi13 = new FiltroItem(null, fg13, "Quaisquer pendências");
		FiltroItem fi14 = new FiltroItem(null, fg14, "Pend. dados pessoais");
		FiltroItem fi15 = new FiltroItem(null, fg14, "Pend. [Matrícula]");
		FiltroItem fi16 = new FiltroItem(null, fg14, "Pend. [Nome completo]");
		FiltroItem fi17 = new FiltroItem(null, fg14, "Pend. [Data de Nascimento]");
		FiltroItem fi18 = new FiltroItem(null, fg14, "Pend. [Nacionalidade]");
		FiltroItem fi19 = new FiltroItem(null, fg14, "Pend. [Naturalidade]");
		FiltroItem fi20 = new FiltroItem(null, fg14, "Pend. [Naturalidade UF]");
		FiltroItem fi21 = new FiltroItem(null, fg14, "Pend. [Rg]");
		FiltroItem fi22 = new FiltroItem(null, fg14, "Pend. [Rg emissor]");
		FiltroItem fi23 = new FiltroItem(null, fg14, "Pend. [Rg emissor UF]");
		FiltroItem fi24 = new FiltroItem(null, fg14, "Pend. [Pai]");
		FiltroItem fi25 = new FiltroItem(null, fg14, "Pend. [Mãe]");

		FiltroItem fi26 = new FiltroItem(null, fg15, "Pend. de dados escolares");
		FiltroItem fi27 = new FiltroItem(null, fg16, "Pendência de HE fun.");
		FiltroItem fi28 = new FiltroItem(null, fg17, "Pendência de HE médio");
		FiltroItem fi29 = new FiltroItem(null, fg18, "Dif. c/ Conexão Educação");

		filtroItemRepository.saveAll(Arrays.asList(fi1, fi2, fi3, fi4, fi5, fi6, fi7, fi8, fi9, fi10, fi11, fi12, fi13,
				fi14, fi15, fi16, fi17, fi18, fi19, fi20, fi21, fi22, fi23, fi24, fi25, fi26, fi27, fi28, fi29));
	}
}
