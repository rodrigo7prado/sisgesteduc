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
			+ "al, v,a"
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
			+ ") " + "FROM Aluno al "
			+ "RIGHT JOIN VwAlunoPeriodoCurricular v ON al.id = v.id.aluno "
			+ "LEFT JOIN AlunoExternal a ON v.id.aluno = a.id "
			+ "LEFT JOIN VwUnionAnosSeries u ON a.id = u.id "
			+ "LEFT JOIN CertificadosCsv cf ON cf.aluno = a.id "
			+ "LEFT JOIN CertidoesCsv cd ON cd.aluno = a.id "
			;
	String selectCount = "SELECT COUNT(*) "
			+ "FROM VwAlunoPeriodoCurricular v " 
			+ "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
			+ "LEFT JOIN CertificadosCsv cf ON cf.aluno = a.id "
			+ "LEFT JOIN CertidoesCsv cd ON cd.aluno = a.id "
			;
	String order = "ORDER BY v.id.turma, v.nomeCompl";
	String where1 = "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' ";
	
	String findFilterTodosWhere = ""
			+ "OR v.id.ano LIKE 'Ano Letivo: 2017%' ";
	String findFilterUltimosPeriodosLetivosWhere = ""
			+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
	String findFilterConcluintesWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
	String findFilterConcluintesSemEmissaoWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "AND cd.nfl IS NULL "
			+ "AND cf.nfl IS NULL ";
	String findFilterConcluintesComConcertidaoECertificadoWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "AND cd.nfl IS NOT NULL "
			+ "AND cf.nfl IS NOT NULL ";
	String findFilterTodasOsCertidoesWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "AND cd.nfl IS NOT NULL ";
	String findFilterConcuintesComCertidaoSemCertificadoWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "AND cd.nfl IS NOT NULL "
			+ "AND cf.nfl IS NULL ";
	String findFilterTodasOsCertificadosWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "AND cf.nfl IS NOT NULL ";
	String findFilterTodosOkWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "AND (a.dataNasc IS NOT NULL "
			+ "AND a.nacionalidade IS NOT NULL "
			+ "AND a.naturalidade IS NOT NULL "
			+ "AND a.rg IS NOT NULL "
			+ "AND a.nomePai IS NOT NULL "
			+ "AND a.nomeMae IS NOT NULL "
			+ ") ";
	String findFilterPendDadosPessoaisWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "AND (a.dataNasc IS NULL "
				+ "OR a.nacionalidade IS NULL "
				+ "OR a.naturalidade IS NULL "
				+ "OR a.rg IS NULL "
				+ "OR a.nomePai IS NULL "
				+ "OR a.nomeMae IS NULL "
			+ ") ";
	String findFilterPendDataNascWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
			+ "AND a.dataNasc IS NULL ";
	String findFilterPendNacionalidadeWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND a.nacionalidade IS NULL "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
	String findFilterPendNaturalidadeWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND a.naturalidade IS NULL "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
	String findFilterPendRgWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND a.rg IS NULL "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
	String findFilterPendNomePaiWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "		
			+ "AND a.nomePai IS NULL ";
	String findFilterPendNomeMaeWhere = ""
			+ "AND v.id.situacaoFinal = 'Aprovado' "
			+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "		
			+ "AND a.nomeMae IS NULL ";
	
	@Query(part
			+ where1
			+ "AND v.id.ano LIKE 'Ano Letivo: 2018%' "
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterNull();
	
	@Query(part
			+ where1
			+ findFilterTodosWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterTodos();
	
	@Query(selectCount
			+ where1
			+ findFilterTodosWhere 
			)
	Integer findFilterTodosCount();
	
	@Query(part
			+ where1
			+ findFilterUltimosPeriodosLetivosWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterUltimosPeriodosLetivos();
	
	@Query(selectCount
			+ where1
			+ findFilterUltimosPeriodosLetivosWhere
			)
	Integer findFilterUltimosPeriodosLetivosCount();
	
	@Query(part
			+ where1 
			+ findFilterConcluintesWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterConcluintes();
	
	@Query(selectCount
			+ where1 
			+ findFilterConcluintesWhere
			)
	Integer findFilterConcluintesCount();
	
	@Query(part
			+ where1 
			+ findFilterConcluintesSemEmissaoWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterConcluintesSemEmissao();
	
	@Query(selectCount
			+ where1 
			+ findFilterConcluintesSemEmissaoWhere
			)
	Integer findFilterConcluintesSemEmissaoCount();
	
	@Query(part
			+ where1 
			+ findFilterConcluintesComConcertidaoECertificadoWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterConcluintesComConcertidaoECertificado();
	
	@Query(selectCount
			+ where1 
			+ findFilterConcluintesComConcertidaoECertificadoWhere
			)
	Integer findFilterConcluintesComConcertidaoECertificadoCount();
	
	@Query(part
			+ where1 
			+ findFilterTodasOsCertidoesWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterTodasOsCertidoes();
	
	@Query(selectCount
			+ where1 
			+ findFilterTodasOsCertidoesWhere
			)
	Integer findFilterTodasOsCertidoesCount();
	
	@Query(part
			+ where1 
			+ findFilterConcuintesComCertidaoSemCertificadoWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterConcuintesComCertidaoSemCertificado();
	
	@Query(selectCount
			+ where1 
			+ findFilterConcuintesComCertidaoSemCertificadoWhere
			)
	Integer findFilterConcuintesComCertidaoSemCertificadoCount();
	
	@Query(part
			+ where1 
			+ findFilterTodasOsCertificadosWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterTodasOsCertificados();
	
	@Query(selectCount
			+ where1 
			+ findFilterTodasOsCertificadosWhere
			)
	Integer findFilterTodasOsCertificadosCount();
	
	@Query(part
			+ where1 
			+ findFilterTodosOkWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterTodosOk();
	
	@Query(selectCount
			+ where1 
			+ findFilterTodosOkWhere
			)
	Integer findFilterTodosOkCount();
	
	@Query(part
			+ where1 
			+ findFilterPendDadosPessoaisWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendDadosPessoais();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendDadosPessoaisWhere
			)
	Integer findFilterPendDadosPessoaisCount();
	
	@Query(part
			+ where1 
			+ findFilterPendDataNascWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendDataNasc();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendDataNascWhere
			)
	Integer findFilterPendDataNascCount();
	
	@Query(part
			+ where1 
			+ findFilterPendNacionalidadeWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendNacionalidade();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendNacionalidadeWhere
			)
	Integer findFilterPendNacionalidadeCount();
	
	@Query(part
			+ where1 
			+ findFilterPendNaturalidadeWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendNaturalidade();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendNaturalidadeWhere
			)
	Integer findFilterPendNaturalidadeCount();
	
	@Query(part
			+ where1 
			+ findFilterPendRgWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendRg();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendRgWhere
			)
	Integer findFilterPendRgCount();
	
	@Query(part
			+ where1 
			+ findFilterPendNomePaiWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendNomePai();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendNomePaiWhere
			)
	Integer findFilterPendNomePaiCount();
	
	@Query(part
			+ where1 
			+ findFilterPendNomeMaeWhere
			+ order)
	List<AlunoPeriodoCurricularDto> findFilterPendNomeMae();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendNomeMaeWhere
			)
	Integer findFilterPendNomeMaeCount();

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
