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
			+ ", cd.nfl"
			+ ", cf.nfl"
			+ ") " + "FROM VwAlunoPeriodoCurricular v " 
			+ "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
			+ "LEFT JOIN CertificadosCsv cf ON cf.aluno = a.id "
			+ "LEFT JOIN CertidoesCsv cd ON cd.aluno = a.id "
			;
	String order = "ORDER BY v.id.turma, v.nomeCompl";
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' "
			+ "AND v.id.ano LIKE 'Ano Letivo: 2018%' "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterNull();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' "
			+ "OR v.id.ano LIKE 'Ano Letivo: 2017%' "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterTodos();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' "
			+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterUltimosPeriodosLetivos();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterConcluintes();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "AND cd.nfl IS NULL "
			+ "AND cf.nfl IS NULL "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterConcluintesSemEmissao();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "AND cd.nfl IS NOT NULL "
			+ "AND cf.nfl IS NOT NULL "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterConcluintesComConcertidaoECertificado();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "AND cd.nfl IS NOT NULL "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterTodasOsCertidoes();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "AND cf.nfl IS NOT NULL "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterTodasOsCertificados();
	
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
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterTodosOk();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
					+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
					+ "AND (a.dataNasc IS NULL "
						+ "OR a.nacionalidade IS NULL "
						+ "OR a.naturalidade IS NULL "
						+ "OR a.rg IS NULL "
						+ "OR a.nomePai IS NULL "
						+ "OR a.nomeMae IS NULL "
					+ ") "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendDadosPessoais();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
					+ "AND a.dataNasc IS NULL "
					+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendDataNasc();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
					+ "AND a.nacionalidade IS NULL "
					+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendNacionalidade();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
					+ "AND a.naturalidade IS NULL "
					+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendNaturalidade();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
					+ "AND a.rg IS NULL "
					+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendRg();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "		
			+ "AND a.nomePai IS NULL "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendNomePai();
	
	@Query(part
			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "		
			+ "AND a.nomeMae IS NULL "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendNomeMae();

//	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto(" + "v,a" + ", v.id.ano"
//			+ ", v.id.turma" + ", v.id.turma" + ", v.id.turma" + ", v.nomeCompl" + ", a.sexo" + ", a.dataNasc"
//			+ ", a.nomePai" + ", a.nomeMae" + ", a.nacionalidade" 
//			+ ", a.naturalidade" 
//			+ ", a.naturalidadeUF"
//			+ ", a.rg" 
//			+ ", a.rgEmissor"
//			+ ", a.rgEmissorUf"
//			+ ", v.id.aluno"
//			+ ", v.id.situacaoFinal"
//			+ ") " + "FROM VwAlunoPeriodoCurricular v " + "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
//			+ "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' " + "AND v.id.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY v.id.turma, v.nomeCompl")
//	List<AlunoPeriodoCurricularDto> findFilterQuaisquerPendencias();
}
