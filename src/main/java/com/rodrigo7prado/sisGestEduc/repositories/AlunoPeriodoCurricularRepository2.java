package com.rodrigo7prado.sisGestEduc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.entities.AlunoPeriodoCurricular;

@Repository
public interface AlunoPeriodoCurricularRepository2 extends JpaRepository<AlunoPeriodoCurricular, Long> {
//	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto("
//			+ "c,e"
//			+ ", c.anoLetivo"
////			+ "e.ultimaTurma"
//
////			+ ", c.id.periodoCurricular.id.cursoModalidade.id.curso.nome"
//			+ ", e.ultimaTurma"
//
////			+ ", c.id.periodoCurricular.id.cursoModalidade.id.modalidade.nome"
//			+ ", e.ultimaTurma"
//
////			+ ", c.ultimaTurma"
//			+ ", e.ultimaTurma"
//
////			+ ", c.id.aluno.nomeCompleto"
//			+ ", e.nomeCompleto"
//
////			+ ", c.id.aluno.matricula"
//			+ ", e.id"
//
//			+ ") "
//			+ "FROM AlunoPeriodoCurricular c "
//			+ "RIGHT JOIN AlunoExternal e "
//			+ "ON c.id.aluno.id = e.id "
////			+ "WHERE "
////			+ "c.anoLetivo LIKE 'Ano Letivo: 2018%' "
////			+ "AND c.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY e.ultimaTurma"
//			)
//	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto("
//			+ "c,e"
//			+ ", c.anoLetivo"
////			+ "e.ultimaTurma"
//
////			+ ", c.id.periodoCurricular.id.cursoModalidade.id.curso.nome"
//			+ ", e.ultimaTurma"
//
////			+ ", c.id.periodoCurricular.id.cursoModalidade.id.modalidade.nome"
//			+ ", e.ultimaTurma"
//
////			+ ", c.ultimaTurma"
//			+ ", e.ultimaTurma"
//
////			+ ", c.id.aluno.nomeCompleto"
//			+ ", e.nomeCompleto"
//
////			+ ", c.id.aluno.matricula"
//			+ ", e.id"
//
//			+ ") "
//			+ "FROM AlunoExternal e "
//			+ "LEFT JOIN AlunoPeriodoCurricular c "
//			+ "ON c.id.aluno.id = e.id "
////			+ "WHERE "
////			+ "c.anoLetivo LIKE 'Ano Letivo: 2018%' "
////			+ "AND c.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY e.ultimaTurma"
//			)
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto(" + "v,a"

	// ano
			+ ", v.id.ano"
//			+ "e.ultimaTurma"

			// curso
//			+ ", c.id.periodoCurricular.id.cursoModalidade.id.curso.nome"
			+ ", v.id.turma"

			// modalidade
//			+ ", c.id.periodoCurricular.id.cursoModalidade.id.modalidade.nome"
			+ ", v.id.turma"

			// turma
//			+ ", c.ultimaTurma"
			+ ", v.id.turma"

			// nomeCompl
//			+ ", c.id.aluno.nomeCompleto"
			+ ", v.nomeCompl"

			// nomeCompl
//			+ ", c.id.aluno.nomeCompleto"
			+ ", a.sexo"

			// nomeCompl
//			+ ", c.id.aluno.nomeCompleto"
//			+ ", a.dataNasc"

//			nomeCompl
//			+ ", c.id.aluno.nomeCompleto"
			+ ", a.dataNasc"

			// nomeCompl
//			+ ", c.id.aluno.nomeCompleto"
			+ ", a.nomePai"

			// nomeCompl
//			+ ", c.id.aluno.nomeCompleto"
			+ ", a.nomeMae"

			// nomeCompl
//			+ ", c.id.aluno.nomeCompleto"
			+ ", a.nacionalidade"

			// nomeCompl
//			+ ", c.id.aluno.nomeCompleto"
			+ ", a.naturalidade"

			+ ", a.naturalidadeUF"

//			nomeCompl
//			+ ", c.id.aluno.nomeCompleto"
			+ ", a.rg"

//			nomeCompl
//			+ ", c.id.aluno.nomeCompleto"
			+ ", a.rgEmissor"

//			nomeCompl
//			+ ", c.id.aluno.nomeCompleto"
			+ ", a.rgEmissorUf"

			// matricula
//			+ ", c.id.aluno.matricula"
			+ ", v.id.aluno"

			// validDadosPessoais
//			+ ", c.id.aluno.matricula"
//			+ ", a.id.aluno"

			// dadosHe
//			+ ", c.id.aluno.matricula"
//			+ ", v.id.aluno"

			// situacaoFinal
//			+ ", c.situacaoFinal"
			+ ", v.id.situacaoFinal"

			+ ") " + "FROM VwAlunoPeriodoCurricular v " + "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterConcluintes();
}
