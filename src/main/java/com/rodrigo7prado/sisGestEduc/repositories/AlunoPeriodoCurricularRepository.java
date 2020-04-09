package com.rodrigo7prado.sisGestEduc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.entities.AlunoPeriodoCurricular;

@Repository
public interface AlunoPeriodoCurricularRepository extends JpaRepository<AlunoPeriodoCurricular, Long> {
	String part = "SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto("
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
			+ ") " + "FROM VwAlunoPeriodoCurricular v " + "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id ";
	String order = "ORDER BY v.id.turma, v.nomeCompl";
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' "
			+ "AND v.id.ano LIKE 'Ano Letivo: 2017%' "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterNull();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' "
			+ "OR v.id.ano LIKE 'Ano Letivo: 2017%' "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterTodos();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' "
			+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterUltimosPeriodosLetivos();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterConcluintes();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
					+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
					+ "AND (a.dataNasc IS NOT NULL "
					+ "AND a.nacionalidade IS NOT NULL "
					+ "AND a.naturalidade IS NOT NULL "
					+ "AND a.rg IS NOT NULL "
					+ "AND a.nomePai IS NOT NULL "
					+ "AND a.nomeMae IS NOT NULL "
					+ ") "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterTodosOk();
	
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto(" + "v,a"
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
			+ ") " + "FROM VwAlunoPeriodoCurricular v " + "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
					+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
					+ "AND (a.dataNasc IS NULL "
					+ "OR a.nacionalidade IS NULL "
					+ "OR a.naturalidade IS NULL "
					+ "OR a.rg IS NULL "
					+ "OR a.nomePai IS NULL "
					+ "OR a.nomeMae IS NULL "
					+ ") "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterPendDadosPessoais();
	
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto(" + "v,a"
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
			+ ") " + "FROM VwAlunoPeriodoCurricular v " + "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
					+ "AND a.dataNasc IS NULL "
					+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterPendDataNasc();
	
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto(" + "v,a"
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
			+ ") " + "FROM VwAlunoPeriodoCurricular v " + "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
					+ "AND a.nacionalidade IS NULL "
					+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterPendNacionalidade();
	
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto(" + "v,a"
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
			+ ") " + "FROM VwAlunoPeriodoCurricular v " + "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
					+ "AND a.naturalidade IS NULL "
					+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterPendNaturalidade();
	
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto(" + "v,a"
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
			+ ") " + "FROM VwAlunoPeriodoCurricular v " + "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
					+ "AND a.rg IS NULL "
					+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterPendRg();
	
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto(" + "v,a"
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
			+ ") " + "FROM VwAlunoPeriodoCurricular v " + "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "		
			+ "AND a.nomePai IS NULL "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterPendNomePai();
	
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto(" + "v,a"
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
			+ ") " + "FROM VwAlunoPeriodoCurricular v " + "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "		
			+ "AND a.nomeMae IS NULL "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterPendNomeMae();

	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto(" + "v,a" + ", v.id.ano"
			+ ", v.id.turma" + ", v.id.turma" + ", v.id.turma" + ", v.nomeCompl" + ", a.sexo" + ", a.dataNasc"
			+ ", a.nomePai" + ", a.nomeMae" + ", a.nacionalidade" 
			+ ", a.naturalidade" 
			+ ", a.naturalidadeUF"
			+ ", a.rg" 
			+ ", a.rgEmissor"
			+ ", a.rgEmissorUf"
			+ ", v.id.aluno"
			+ ", v.id.situacaoFinal"

			+ ") " + "FROM VwAlunoPeriodoCurricular v " + "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
			+ "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterQuaisquerPendencias();
}
