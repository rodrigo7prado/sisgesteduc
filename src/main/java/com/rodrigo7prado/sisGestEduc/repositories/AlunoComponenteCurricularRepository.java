package com.rodrigo7prado.sisGestEduc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto;
import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.entities.AlunoComponenteCurricular;

@Repository
public interface AlunoComponenteCurricularRepository extends JpaRepository<AlunoComponenteCurricular, Long> {
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
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto("
			+ "v.anoLetivo"
			+ ", v.curso"
			+ ", v.modalidade"
			+ ", v.serie"
			+ ", v.aluno.id"
			+ ", v.nomeCompl"
			+ ", v.disciplina1"
			+ ", v.total_pontos"
			+ ", v.faltas"
			+ ", v.freq"
			+ ") "
			+ "FROM ResultadoFinalExternal v "
			+ "WHERE "
			+ "v.aluno.id = ?1 "
			+ "ORDER BY v.disciplina1"
			)
	List<AlunoComponenteCurricularDto> findFilterConcluintes(String matricula);
	
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto("
			+ " v.curso"
			+ ", v.modalidade"
			+ ", v.aluno.id"
			+ ", v.nomeCompl"
			+ ", v.disciplina1"
			+ ") "
			+ "FROM ResultadoFinalExternal v "
			+ "WHERE "
			+ "v.aluno = '201601911023339' "
			)
	List<AlunoComponenteCurricularDto> findFilterConcluintes2();
	
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto("
			+ "v,a"
			+ ", v.id.ano"
			+ ", v.id.turma"
			+ ", v.id.turma"
			+ ", v.id.turma"
			+ ", v.nomeCompl"
			+ ", a.sexo"
			+ ", a.dataNasc"
			+ ", a.nomePai"
			+ ", a.nomeMae"
			+ ", a.nacionalidade"
			+ ", a.naturalidade"
			+ ", a.naturalidadeUF"
			+ ", a.rg"
			+ ", a.rgEmissor"
			+ ", a.rgEmissorUf"
			+ ", v.id.aluno"
			+ ", v.id.situacaoFinal"

			+ ") "
			+ "FROM VwAlunoPeriodoCurricular v "
			+ "LEFT JOIN AlunoExternal a "
			+ "ON v.id.aluno = a.id "
			+ "WHERE "
			+ "v.id.ano LIKE 'Ano Letivo: 2018%' "
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "ORDER BY v.id.turma, v.nomeCompl"
			)
	List<AlunoPeriodoCurricularDto> findFilterQuaisquerPendencias();
}
