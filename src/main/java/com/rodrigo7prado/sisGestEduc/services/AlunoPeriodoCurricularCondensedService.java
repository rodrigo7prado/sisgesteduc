package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularCondensedDto;
import com.rodrigo7prado.sisGestEduc.entities.external.VwAlunoPeriodoCurricularCondensed;
import com.rodrigo7prado.sisGestEduc.repositories.AlunoPeriodoCurricularCondensedRepository;

@Service
public class AlunoPeriodoCurricularCondensedService {
	@Autowired
	private AlunoPeriodoCurricularCondensedRepository repository;

	public List<VwAlunoPeriodoCurricularCondensed> findAll() {
		return repository.findAll();
	}

//	public List<VwAlunoPeriodoCurricularCondensedCondensedDto> findFilterTodos() {
//		System.out.println("Chamando sql?");
//		List<VwAlunoPeriodoCurricularCondensedCondensedDto> listDto = repository.findFilterTodos();
//
//		return listDto;
//	}

	public VwAlunoPeriodoCurricularCondensed findById(Long id) {
		Optional<VwAlunoPeriodoCurricularCondensed> obj = repository.findById(id);
		return obj.get();
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterNull() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterNull();

		return listDto;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterTodos() {
		System.out.println("Chamando sql?");
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterTodos();

		return listDto;
	}

	public Integer findFilterTodosCount() {
		Integer count = repository.findFilterTodosCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterUltimosPeriodosLetivos() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterUltimosPeriodosLetivos();

		return listDto;
	}

	public Integer findFilterUltimosPeriodosLetivosCount() {
		Integer count = repository.findFilterUltimosPeriodosLetivosCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterConcluintes() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterConcluintes();

		return listDto;
	}

	public Integer findFilterConcluintesCount() {
		Integer count = repository.findFilterConcluintesCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterConcluintesSemEmissao() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterConcluintesSemEmissao();
		return listDto;
	}

	public Integer findFilterConcluintesSemEmissaoCount() {
		Integer count = repository.findFilterConcluintesSemEmissaoCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterConcluintesComConcertidaoECertificado() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterConcluintesComConcertidaoECertificado();

		return listDto;
	}

	public Integer findFilterConcluintesComConcertidaoECertificadoCount() {
		Integer count = repository.findFilterConcluintesComConcertidaoECertificadoCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterTodasOsCertidoes() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterTodasOsCertidoes();

		return listDto;
	}

	public Integer findFilterTodasOsCertidoesCount() {
		Integer count = repository.findFilterTodasOsCertidoesCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterConcuintesComCertidaoSemCertificado() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterConcuintesComCertidaoSemCertificado();

		return listDto;
	}

	public Integer findFilterConcuintesComCertidaoSemCertificadoCount() {
		Integer count = repository.findFilterConcuintesComCertidaoSemCertificadoCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterTodasOsCertificados() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterTodasOsCertificados();

		return listDto;
	}

	public Integer findFilterTodasOsCertificadosCount() {
		Integer count = repository.findFilterTodasOsCertificadosCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterTodosOk() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterTodosOk();

		return listDto;
	}

	public Integer findFilterTodosOkCount() {
		Integer count = repository.findFilterTodosOkCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterPendDadosPessoais() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterPendDadosPessoais();

		return listDto;
	}

	public Integer findFilterPendDadosPessoaisCount() {
		Integer count = repository.findFilterPendDadosPessoaisCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterPendDataNasc() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterPendDataNasc();

		return listDto;
	}

	public Integer findFilterPendDataNascCount() {
		Integer count = repository.findFilterPendDataNascCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterPendNaturalidade() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterPendNaturalidade();

		return listDto;
	}

	public Integer findFilterPendNaturalidadeCount() {
		Integer count = repository.findFilterPendNaturalidadeCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterPendNacionalidade() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterPendNacionalidade();

		return listDto;
	}

	public Integer findFilterPendNacionalidadeCount() {
		Integer count = repository.findFilterPendNacionalidadeCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterPendRg() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterPendRg();

		return listDto;
	}

	public Integer findFilterPendRgCount() {
		Integer count = repository.findFilterPendRgCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterPendNomePai() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterPendNomePai();

		return listDto;
	}

	public Integer findFilterPendNomePaiCount() {
		Integer count = repository.findFilterPendNomePaiCount();

		return count;
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterPendNomeMae() {
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterPendNomeMae();

		return listDto;
	}

	public Integer findFilterPendNomeMaeCount() {
		Integer count = repository.findFilterPendNomeMaeCount();

		return count;
	}

	public VwAlunoPeriodoCurricularCondensed fromDto(AlunoPeriodoCurricularCondensedDto objDto) {
		System.out.println("Service objDto: " + objDto);
		System.out.println("Service getAluno: " + objDto.getAluno());
		return new VwAlunoPeriodoCurricularCondensed(objDto.getAluno(), objDto.getPeriodoCurricular());
	}

	public void saveAll(VwAlunoPeriodoCurricularCondensed entity) {
		repository.save(entity);
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterDadosEscolas(String matricula) {
		// TODO Auto-generated method stub
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterDadosEscolas(matricula);

		return listDto;
	}


}
