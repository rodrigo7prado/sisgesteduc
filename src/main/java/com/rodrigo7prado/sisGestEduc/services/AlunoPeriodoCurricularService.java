package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.entities.AlunoPeriodoCurricular;
import com.rodrigo7prado.sisGestEduc.repositories.AlunoPeriodoCurricularRepository;

@Service
public class AlunoPeriodoCurricularService {
	@Autowired
	private AlunoPeriodoCurricularRepository repository;

	public List<AlunoPeriodoCurricular> findAll() {
		return repository.findAll();
	}

	public AlunoPeriodoCurricular findById(Long id) {
		Optional<AlunoPeriodoCurricular> obj = repository.findById(id);
		return obj.get();
	}

	public List<AlunoPeriodoCurricularDto> findFilterNull() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterNull();

		return listDto;
	}

	public List<AlunoPeriodoCurricularDto> findFilterTodos() {
		System.out.println("Chamando sql?");
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterTodos();

		return listDto;
	}

	public Integer findFilterTodosCount() {
		Integer count = repository.findFilterTodosCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterUltimosPeriodosLetivos() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterUltimosPeriodosLetivos();

		return listDto;
	}

	public Integer findFilterUltimosPeriodosLetivosCount() {
		Integer count = repository.findFilterUltimosPeriodosLetivosCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterConcluintes() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterConcluintes();

		return listDto;
	}

	public Integer findFilterConcluintesCount() {
		Integer count = repository.findFilterConcluintesCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterConcluintesSemEmissao() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterConcluintesSemEmissao();
		return listDto;
	}

	public Integer findFilterConcluintesSemEmissaoCount() {
		Integer count = repository.findFilterConcluintesSemEmissaoCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterConcluintesComConcertidaoECertificado() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterConcluintesComConcertidaoECertificado();

		return listDto;
	}

	public Integer findFilterConcluintesComConcertidaoECertificadoCount() {
		Integer count = repository.findFilterConcluintesComConcertidaoECertificadoCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterTodasOsCertidoes() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterTodasOsCertidoes();

		return listDto;
	}

	public Integer findFilterTodasOsCertidoesCount() {
		Integer count = repository.findFilterTodasOsCertidoesCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterConcuintesComCertidaoSemCertificado() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterConcuintesComCertidaoSemCertificado();

		return listDto;
	}

	public Integer findFilterConcuintesComCertidaoSemCertificadoCount() {
		Integer count = repository.findFilterConcuintesComCertidaoSemCertificadoCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterTodasOsCertificados() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterTodasOsCertificados();

		return listDto;
	}

	public Integer findFilterTodasOsCertificadosCount() {
		Integer count = repository.findFilterTodasOsCertificadosCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterTodosOk() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterTodosOk();

		return listDto;
	}

	public Integer findFilterTodosOkCount() {
		Integer count = repository.findFilterTodosOkCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterPendDadosPessoais() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendDadosPessoais();

		return listDto;
	}

	public Integer findFilterPendDadosPessoaisCount() {
		Integer count = repository.findFilterPendDadosPessoaisCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterPendDataNasc() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendDataNasc();

		return listDto;
	}

	public Integer findFilterPendDataNascCount() {
		Integer count = repository.findFilterPendDataNascCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterPendNaturalidade() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendNaturalidade();

		return listDto;
	}

	public Integer findFilterPendNaturalidadeCount() {
		Integer count = repository.findFilterPendNaturalidadeCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterPendNacionalidade() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendNacionalidade();

		return listDto;
	}

	public Integer findFilterPendNacionalidadeCount() {
		Integer count = repository.findFilterPendNacionalidadeCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterPendRg() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendRg();

		return listDto;
	}

	public Integer findFilterPendRgCount() {
		Integer count = repository.findFilterPendRgCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterPendNomePai() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendNomePai();

		return listDto;
	}

	public Integer findFilterPendNomePaiCount() {
		Integer count = repository.findFilterPendNomePaiCount();

		return count;
	}

	public List<AlunoPeriodoCurricularDto> findFilterPendNomeMae() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendNomeMae();

		return listDto;
	}

	public Integer findFilterPendNomeMaeCount() {
		Integer count = repository.findFilterPendNomeMaeCount();

		return count;
	}

	public AlunoPeriodoCurricular fromDto(AlunoPeriodoCurricularDto objDto) {
		System.out.println("Service objDto: " + objDto);
		System.out.println("Service getAluno: " + objDto.getAluno());
		return new AlunoPeriodoCurricular(objDto.getAluno(), objDto.getPeriodoCurricular());
	}

	public void saveAll(AlunoPeriodoCurricular entity) {
		repository.save(entity);
	}

	public List<AlunoPeriodoCurricularDto> findFilterDadosEscolas(String matricula) {
		// TODO Auto-generated method stub
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterDadosEscolas(matricula);

		return listDto;
	}

}
