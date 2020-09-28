package com.rodrigo7prado.sisGestEduc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularCondensedDto;
import com.rodrigo7prado.sisGestEduc.entities.external.VwAlunoPeriodoCurricularCondensed;

@Repository
public interface AlunoPeriodoCurricularCondensedRepository extends JpaRepository<VwAlunoPeriodoCurricularCondensed, Long> {
	String part = "SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularCondensedDto("
			+ "c.id.ano"
			+ ", c.id.curso"
			+ ", c.id.modalidade"
			+ ", c.id.periodoCurricular"
			+ ", c.id.turma"
			+ ", c.nomeCompl"
			+ ", c.sexo"
			+ ", c.dataNasc"
			+ ", c.nomePai"
			+ ", c.nomeMae"
			+ ", c.nacionalidade"
			+ ", c.naturalidade"
			+ ", c.naturalidadeUF"
			+ ", c.rg"
			+ ", c.rgEmissor"
			+ ", c.rgEmissorUf"
			+ ", c.id.aluno"
			+ ", c.situacaoFinal"
			+ ", c.chSubst"
			+ ", c.ensMedioEstabEns"
			+ ", c.ensMedioCidadeEstadoEstabEns"
			+ ", c.freqSubst"
			+ ", c.frqg"
			+ ", c.resSerie"
			+ ", c.resSerieSubst"
			+ ", c.cdNfl"
			+ ", c.cfNfl"
			+ ") " + "FROM VwAlunoPeriodoCurricularCondensed c "
			;
	
//	String selectCount = "SELECT COUNT(*) "
//			+ "FROM VwAlunoPeriodoCurricular v " 
//			+ "LEFT JOIN AlunoExternal a " + "ON v.id.aluno = a.id "
//			+ "LEFT JOIN CertificadosCsv cf ON cf.aluno = a.id "
//			+ "LEFT JOIN CertidoesCsv cd ON cd.aluno = a.id "
//			;
	
	String selectCount = "SELECT COUNT(*) "
			+ "FROM VwAlunoPeriodoCurricularCondensed c "
			;
	
	String order = "ORDER BY c.id.turma, c.nomeCompl";
	String where1 = "WHERE " + "c.id.ano LIKE 'Ano Letivo: 2018%' ";
	
	String findFilterTodosWhere = ""
			+ "OR c.id.ano LIKE 'Ano Letivo: 2017%' ";
	String findFilterDadosEscolaWhere = ""
			+ "WHERE c.id.aluno = ?1";
	String findFilterUltimosPeriodosLetivosWhere = ""
			+ " AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') ";
	String findFilterConcluintesWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') ";
	String findFilterConcluintesSemEmissaoWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') "
			+ "AND c.cdNfl IS NULL "
			+ "AND c.cfNfl IS NULL ";
	String findFilterConcluintesComConcertidaoECertificadoWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') "
			+ "AND c.cdNfl IS NOT NULL "
			+ "AND c.cfNfl IS NOT NULL ";
	String findFilterTodasOsCertidoesWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') "
			+ "AND c.cdNfl IS NOT NULL ";
	String findFilterConcuintesComCertidaoSemCertificadoWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') "
			+ "AND cdNfl IS NOT NULL "
			+ "AND cfNfl IS NULL ";
	String findFilterTodasOsCertificadosWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') "
			+ "AND c.cfNfl IS NOT NULL ";
	String findFilterTodosOkWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') "
			+ "AND (c.dataNasc IS NOT NULL "
			+ "AND c.nacionalidade IS NOT NULL "
			+ "AND c.naturalidade IS NOT NULL "
			+ "AND c.rg IS NOT NULL "
			+ "AND c.nomePai IS NOT NULL "
			+ "AND c.nomeMae IS NOT NULL "
			+ ") ";
	String findFilterPendDadosPessoaisWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') "
			+ "AND (c.dataNasc IS NULL "
				+ "OR c.nacionalidade IS NULL "
				+ "OR c.naturalidade IS NULL "
				+ "OR c.rg IS NULL "
				+ "OR c.nomePai IS NULL "
				+ "OR c.nomeMae IS NULL "
			+ ") ";
	String findFilterPendDataNascWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') "
			+ "AND c.dataNasc IS NULL ";
	String findFilterPendNacionalidadeWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND c.nacionalidade IS NULL "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') ";
	String findFilterPendNaturalidadeWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND c.naturalidade IS NULL "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') ";
	String findFilterPendRgWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND c.rg IS NULL "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') ";
	String findFilterPendNomePaiWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') "		
			+ "AND c.nomePai IS NULL ";
	String findFilterPendNomeMaeWhere = ""
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "AND (c.id.turma LIKE 'Turma: NEJA-IV%' OR c.id.turma LIKE 'Turma: 3%') "		
			+ "AND c.nomeMae IS NULL ";
	
	@Query(part
			+ where1
			+ "AND c.id.ano LIKE 'Ano Letivo: 2018%' "
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterNull();
	
	@Query(part
//			+ where1
//			+ findFilterTodosWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterTodos();
	
	@Query(part
			+ findFilterDadosEscolaWhere
			)
	List<AlunoPeriodoCurricularCondensedDto> findFilterDadosEscolas(String matricula);
	
	@Query(selectCount
			+ where1
			+ findFilterTodosWhere 
			)
	Integer findFilterTodosCount();
	
	@Query(part
			+ where1
			+ findFilterUltimosPeriodosLetivosWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterUltimosPeriodosLetivos();
	
	@Query(selectCount
			+ where1
			+ findFilterUltimosPeriodosLetivosWhere
			)
	Integer findFilterUltimosPeriodosLetivosCount();
	
	@Query(part
			+ where1 
			+ findFilterConcluintesWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterConcluintes();
	
	@Query(selectCount
			+ where1 
			+ findFilterConcluintesWhere
			)
	Integer findFilterConcluintesCount();
	
	@Query(part
			+ where1 
			+ findFilterConcluintesSemEmissaoWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterConcluintesSemEmissao();
	
	@Query(selectCount
			+ where1 
			+ findFilterConcluintesSemEmissaoWhere
			)
	Integer findFilterConcluintesSemEmissaoCount();
	
	@Query(part
			+ where1 
			+ findFilterConcluintesComConcertidaoECertificadoWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterConcluintesComConcertidaoECertificado();
	
	@Query(selectCount
			+ where1 
			+ findFilterConcluintesComConcertidaoECertificadoWhere
			)
	Integer findFilterConcluintesComConcertidaoECertificadoCount();
	
	@Query(part
			+ where1 
			+ findFilterTodasOsCertidoesWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterTodasOsCertidoes();
	
	@Query(selectCount
			+ where1 
			+ findFilterTodasOsCertidoesWhere
			)
	Integer findFilterTodasOsCertidoesCount();
	
	@Query(part
			+ where1 
			+ findFilterConcuintesComCertidaoSemCertificadoWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterConcuintesComCertidaoSemCertificado();
	
	@Query(selectCount
			+ where1 
			+ findFilterConcuintesComCertidaoSemCertificadoWhere
			)
	Integer findFilterConcuintesComCertidaoSemCertificadoCount();
	
	@Query(part
			+ where1 
			+ findFilterTodasOsCertificadosWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterTodasOsCertificados();
	
	@Query(selectCount
			+ where1 
			+ findFilterTodasOsCertificadosWhere
			)
	Integer findFilterTodasOsCertificadosCount();
	
	@Query(part
			+ where1 
			+ findFilterTodosOkWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterTodosOk();
	
	@Query(selectCount
			+ where1 
			+ findFilterTodosOkWhere
			)
	Integer findFilterTodosOkCount();
	
	@Query(part
			+ where1 
			+ findFilterPendDadosPessoaisWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterPendDadosPessoais();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendDadosPessoaisWhere
			)
	Integer findFilterPendDadosPessoaisCount();
	
	@Query(part
			+ where1 
			+ findFilterPendDataNascWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterPendDataNasc();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendDataNascWhere
			)
	Integer findFilterPendDataNascCount();
	
	@Query(part
			+ where1 
			+ findFilterPendNacionalidadeWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterPendNacionalidade();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendNacionalidadeWhere
			)
	Integer findFilterPendNacionalidadeCount();
	
	@Query(part
			+ where1 
			+ findFilterPendNaturalidadeWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterPendNaturalidade();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendNaturalidadeWhere
			)
	Integer findFilterPendNaturalidadeCount();
	
	@Query(part
			+ where1 
			+ findFilterPendRgWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterPendRg();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendRgWhere
			)
	Integer findFilterPendRgCount();
	
	@Query(part
			+ where1 
			+ findFilterPendNomePaiWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterPendNomePai();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendNomePaiWhere
			)
	Integer findFilterPendNomePaiCount();
	
	@Query(part
			+ where1 
			+ findFilterPendNomeMaeWhere
			+ order)
	List<AlunoPeriodoCurricularCondensedDto> findFilterPendNomeMae();
	
	@Query(selectCount
			+ where1 
			+ findFilterPendNomeMaeWhere
			)
	Integer findFilterPendNomeMaeCount();

	
	}
