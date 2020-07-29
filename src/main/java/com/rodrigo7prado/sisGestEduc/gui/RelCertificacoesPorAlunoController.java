package com.rodrigo7prado.sisGestEduc.gui;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.config.StageManager;
import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.enums.StatusDocAluno;
import com.rodrigo7prado.sisGestEduc.services.AlunoPeriodoCurricularService;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

@Controller
public class RelCertificacoesPorAlunoController implements Initializable {

	private Map<String, String> mapObjects = new HashMap<String, String>();

//	@FXML
//	private VBox vBoxControllerDadosAlunos;

	@FXML
	private VBox vBoxControllerFiltro;
	
	@FXML
	private VBox vBoxControllerDadosEscolas;

	@FXML
	ProgressBar progressBar;

	@FXML
	@Autowired
	private DadosAlunosController dadosAlunosController;
	@FXML
	@Autowired
	private DadosEscolasController dadosEscolasController;
	@FXML
	@Autowired
	private HistoricoAlunoController historicoAlunoController;
	@Lazy
	@Autowired
	private StageManager stageManager;
	@Autowired
	private AlunoPeriodoCurricularService service;

	private ObservableList<AlunoPeriodoCurricularDto> observableList = FXCollections.observableArrayList();

	private List<List<AlunoPeriodoCurricularDto>> carregamentos;
	private Map<Integer, List<AlunoPeriodoCurricularDto>> mapCarregamentos = new HashMap<Integer, List<AlunoPeriodoCurricularDto>>();
	private Map<String, List<String>> mapCarregamentos2 = new HashMap<String, List<String>>();

	@FXML
	private TreeTableView<AlunoPeriodoCurricularDto> treeTableViewAluno;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, String> treeTableColumnTurma;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, String> treeTableColumnAluno;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, String> treeTableColumnNomeCompl;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, Integer> treeTableColumnNflCertidao;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, Integer> treeTableColumnNflCertificado;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, String> treeTableColumnSituacaoFinal;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, StatusDocAluno> treeTableColumnDP;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, StatusDocAluno> treeTableColumnDadosIdentif;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, StatusDocAluno> treeTableColumnDadosHeFund;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, StatusDocAluno> treeTableColumnDadosHeMedio;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, String> treeTableColumnBoolCertidao;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, String> treeTableColumnBoolCertificado;
	@FXML
	private VBox dialog;
	@FXML
	private ToggleGroup toggleGroupAnos;
	
	private Map<String,Predicate> mapFilters = new HashMap<String,Predicate>();
	
	private Map<ToggleGroup,RadioButton> mapToggleGroups = new HashMap<ToggleGroup,RadioButton>();
	
	private FilteredList<AlunoPeriodoCurricularDto> filteredList;
	
	private Predicate<AlunoPeriodoCurricularDto> predFilter01000Rb00000TodosAnos = 
			obj -> 	obj.getSituacaoFinal().equals("Reprovado por nota");
	private Predicate<AlunoPeriodoCurricularDto> p1 = 
			obj -> 	obj.getSituacaoFinal().equals("Reprovado por nota");
	
	private Predicate<AlunoPeriodoCurricularDto> predFilter02000Rb01000EnsinoMedioRegular = 
			obj -> !(obj.getTurma().contains("Turma: NEJA"));
			
	private Predicate<AlunoPeriodoCurricularDto> predFilter02000Rb02000Neja = 
			obj -> (obj.getTurma().contains("Turma: NEJA"));

	private Class<RelCertificacoesPorAlunoController> myClass;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		System.out.println("COMEÇAR AGORA, para filteredList");
		
		setupPredicates();

		observableList.clear();

		observableList.addAll(service.findFilterTodos());
		
//		filteredList = new FilteredList<>(observableList, p -> true);
	}
	
	private void setupPredicates() {
		System.out.println("ToggleGroupAnos: " + toggleGroupAnos.getSelectedToggle());
		System.out.println("ToggleGroupAnos: " + toggleGroupAnos.getSelectedToggle().selectedProperty());
		
		
		mapToggleGroups.put(toggleGroupAnos, (RadioButton) toggleGroupAnos.getSelectedToggle());
		
		RadioButton radioButtonAssociated = mapToggleGroups.get(toggleGroupAnos);
		
		String str = radioButtonAssociated.getId();
		
		RelCertificacoesPorAlunoController.class.getDeclaredFields();
		
		
		Class<RelCertificacoesPorAlunoController> classe = RelCertificacoesPorAlunoController.class;
		
		for ( Field atributo : classe.getDeclaredFields() ) {
			System.out.println(radioButtonAssociated.getId());
			System.out.println("Atributo: " + atributo.getName().toString());
			if (atributo.getName().toString().equals(str)) {
				System.out.println("Código identificou corretamente");
			}
			else {
				System.out.println("Não identificado");
			}
			System.out.println("___________________________________________________");
		}
		
		mapFilters.put("EnsinoMedioRegular",predFilter02000Rb01000EnsinoMedioRegular);
		mapFilters.put("Cursos",predFilter02000Rb01000EnsinoMedioRegular);
		mapFilters.put("PeridosCurriculares",predFilter02000Rb01000EnsinoMedioRegular);
		mapFilters.put("SituacoesDeConclusao",predFilter02000Rb01000EnsinoMedioRegular);
		mapFilters.put("SituacoesFinais",predFilter02000Rb01000EnsinoMedioRegular);
		mapFilters.put("SituacoesPendenciais",predFilter02000Rb01000EnsinoMedioRegular);
		mapFilters.put("SituacoesDeCertidao",predFilter02000Rb01000EnsinoMedioRegular);
		mapFilters.put("SituacoesDeCertificado",predFilter02000Rb01000EnsinoMedioRegular);
		mapFilters.put("PendenciasDadosGeraisEPessoais",predFilter02000Rb01000EnsinoMedioRegular);
		mapFilters.put("SituacoesDeHistoricoMedio",predFilter02000Rb01000EnsinoMedioRegular);
		mapFilters.put("SituacoesDeConsistenciaConexao",predFilter02000Rb01000EnsinoMedioRegular);
		
//		System.out.println("getDeclaredFields: " + RelCertificacoesPorAlunoController.class.getD);
		
//		mapToggleGroups.forEach((k,v) -> 
//		
//		filteredList.setPredicate(p1)
//		);
		
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void associateTreeTableColumns() {

		System.out.println("Service: " + service.findFilterConcluintes());
		treeTableColumnTurma.setCellValueFactory(new TreeItemPropertyValueFactory("turma"));
		treeTableColumnAluno.setCellValueFactory(new TreeItemPropertyValueFactory("matricula"));
		treeTableColumnNomeCompl.setCellValueFactory(new TreeItemPropertyValueFactory("nomeCompleto"));
		treeTableColumnNflCertidao.setCellValueFactory(new TreeItemPropertyValueFactory("nflCertidao"));
		treeTableColumnNflCertificado.setCellValueFactory(new TreeItemPropertyValueFactory("nflCertificado"));
		treeTableColumnDP.setCellValueFactory(new TreeItemPropertyValueFactory("validDadosPessoais"));
		treeTableColumnDadosIdentif.setCellValueFactory(new TreeItemPropertyValueFactory("validDadosIdentif"));
		treeTableColumnDadosHeFund.setCellValueFactory(new TreeItemPropertyValueFactory("validDadosHeFund"));
		treeTableColumnDadosHeMedio.setCellValueFactory(new TreeItemPropertyValueFactory("validDadosHeMedio"));
//		treeTableColumnSituacaoFinal.setCellValueFactory(new TreeItemPropertyValueFactory("situacaoFinal"));
		treeTableColumnSituacaoFinal.setCellValueFactory(new TreeItemPropertyValueFactory("ensMedioEstabEns"));
	}

//	@SuppressWarnings("unused")
	private void initializeNodes(Integer keyMap, String radioSource) {

//		@SuppressWarnings("rawtypes")
//		Task task = new Task<Void>() {
//		    @Override public Void call() {
//		    	
//		        return null;
//		    }
//		};

//		final ProgressBar bar = new ProgressBar();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
//						progressBar.setProgress(0);
						progressBar.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
					}
				});
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {

						// Thread.sleep(3000);
						progressBar.setProgress(0);

						associateTreeTableColumns();
						System.out.println("Ráaa 8: " + keyMap);
						if (keyMap == null) {
//							TODO
							System.out.println("Ráaa 7");
							loadAlunosDetailsByFormElements(radioSource);
//							loadAlunosDetailsByFilteredList(1);
						} else {
							loadAlunosDetailsByFilteredList(keyMap);
						}
						loadElementTreeTableColumBoolCertidao();
						progressBar.setProgress(1);
					}
				});
			}
		});

//		progressBar.setProgress(0);

//		thread2.start();

		thread1.start();
		try {
			thread1.join();
			Thread.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		thread2.start();

	}

	private void loadAlunosDetailsByFormElements(String eventSource) {
//		TODO
//		FilteredList<AlunoPeriodoCurricularDto> filteredList = new FilteredList<>(observableList, p -> true);
		System.out.println("Ráaa 6");
		if (eventSource.equals("Todos")) {
			System.out.println("Ráaa 5");

			Predicate<AlunoPeriodoCurricularDto> p2 = obj -> obj.getAnoLetivo().contains("Ano Letivo: 2018i")
					|| obj.getAnoLetivo().contains("Ano Letivo: 2017i");
			
//			System.out.println("intTest: " + intTest);
			System.out.println("Size filtered list: " + filteredList.size());

//			filteredList.setPredicate(p1);
			
//			filteredList.predicateProperty().set(p1);
			
			@SuppressWarnings("unchecked")
			Predicate<AlunoPeriodoCurricularDto> currentPredicate = (Predicate<AlunoPeriodoCurricularDto>) filteredList.getPredicate();
			
			
			
//			filteredList.setPredicate(currentPredicate.and(p1));
			filteredList.setPredicate(currentPredicate.and(p1));
			System.out.println("Size final: " + filteredList.size());
		} else if (eventSource.equals("fil02000_rb00000_TodosOsCursos")) {
			Predicate<AlunoPeriodoCurricularDto> p2 = obj -> obj.getAnoLetivo().contains("Ano Letivo: 2018")
					&& !(obj.getTurma().contains("Turma: NEJA"))
					;
			
			@SuppressWarnings("unchecked")
			Predicate<AlunoPeriodoCurricularDto> currentPredicate = (Predicate<AlunoPeriodoCurricularDto>) filteredList.getPredicate();
			
			filteredList.setPredicate(currentPredicate.and(predFilter02000Rb01000EnsinoMedioRegular));
			
//			for() {
//				
//			}
			
			
		} else if (eventSource.equals("fil02000_rb01000_EnsinoMedioRegular")) {
			Predicate<AlunoPeriodoCurricularDto> p2 = obj -> obj.getAnoLetivo().contains("Ano Letivo: 2018")
					&& !(obj.getTurma().contains("Turma: NEJA"))
					;
			
			@SuppressWarnings("unchecked")
			Predicate<AlunoPeriodoCurricularDto> currentPredicate = (Predicate<AlunoPeriodoCurricularDto>) filteredList.getPredicate();
			
			filteredList.setPredicate(currentPredicate.and(predFilter02000Rb02000Neja));
			
		} else if (eventSource.equals("fil02000_rb02000_ENEJA")) {
			Predicate<AlunoPeriodoCurricularDto> p2 = obj -> obj.getAnoLetivo().contains("Ano Letivo: 2018")
					&& (obj.getTurma().contains("Turma: NEJA"))
					;
			
			@SuppressWarnings("unchecked")
			Predicate<AlunoPeriodoCurricularDto> currentPredicate = (Predicate<AlunoPeriodoCurricularDto>) filteredList.getPredicate();
			
			filteredList.setPredicate(currentPredicate.and(p2));
			
		} else if (eventSource.equals("Anos finais")) {
			Predicate<AlunoPeriodoCurricularDto> p2 = obj -> obj.getAnoLetivo().contains("Ano Letivo: 2018")
					&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"));
			
			@SuppressWarnings("unchecked")
			Predicate<AlunoPeriodoCurricularDto> currentPredicate = (Predicate<AlunoPeriodoCurricularDto>) filteredList.getPredicate();
			
			filteredList.setPredicate(currentPredicate.and(p2));
			
		} else if (eventSource.equals("Todos")) {
			
		} else if (eventSource.equals("Todos")) {
			
		} else if (eventSource.equals("Todos")) {
			
		} else if (eventSource.equals("Todos")) {
			
		}
		
		buildView(filteredList);

	}

	private void loadAlunosDetailsByFilteredList2(Integer keyMap) {

		FilteredList<AlunoPeriodoCurricularDto> filteredList = new FilteredList<>(observableList, p -> true);

		if (keyMap == 1) {
			filteredList.setPredicate(obj -> {
				if (obj.getAnoLetivo().contains("Ano Letivo: 2018")
						|| obj.getAnoLetivo().contains("Ano Letivo: 2017")) {
					return true;
				} else {
					return false;
				}
			});
			System.out.println("Size: " + filteredList.size());
		} else if (keyMap == 2) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(3)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018")) && (obj.getSituacaoFinal().equals("Aprovado")
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3")))) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(4)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018")) && obj.getSituacaoFinal().equals("Aprovado")
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getNflCertidao() == null && obj.getNflCertificado() == null) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(5)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018")) && obj.getSituacaoFinal().equals("Aprovado")
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getNflCertidao() != null && obj.getNflCertificado() != null) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(6)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018")) && obj.getSituacaoFinal().equals("Aprovado")
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getNflCertidao() != null) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(7)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018")) && obj.getSituacaoFinal().equals("Aprovado")
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getNflCertidao() != null && obj.getNflCertificado() == null) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(8)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018")) && obj.getSituacaoFinal().equals("Aprovado")
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getNflCertificado() != null) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(12)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getSituacaoFinal().equals("Aprovado")
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getDataNasc() != null && obj.getNacionalidade() != null && obj.getNaturalidade() != null
						&& obj.getRg() != null && obj.getNomePai() != null && obj.getNomeMae() != null) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(14)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getSituacaoFinal().equals("Aprovado")
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& (obj.getDataNasc() == null || obj.getNacionalidade() == null || obj.getNaturalidade() == null
								|| obj.getRg() == null || obj.getNomePai() == null || obj.getNomeMae() == null)) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(17)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getSituacaoFinal().equals("Aprovado") && obj.getDataNasc() == null) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(18)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getSituacaoFinal().equals("Aprovado") && obj.getNacionalidade() == null) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(19)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getSituacaoFinal().equals("Aprovado") && obj.getNaturalidade() == null) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(21)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getSituacaoFinal().equals("Aprovado") && obj.getRg() == null) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(24)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getSituacaoFinal().equals("Aprovado") && obj.getNomePai() == null) {
					return true;
				} else {
					return false;
				}
			});
		} else if (keyMap.equals(25)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
						&& obj.getSituacaoFinal().equals("Aprovado") && obj.getNomeMae() == null) {
					return true;
				} else {
					return false;
				}
			});
		} else {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))) {
					return true;
				} else {
					return false;
				}
			});
		}

		System.out.println("Qualquer porra");
	}

	private void loadAlunosDetailsByFilteredList(Integer keyMap) {

//		TODO
//		FilteredList<AlunoPeriodoCurricularDto> filteredList = new FilteredList<>(observableList, p -> true);
		filteredList = new FilteredList<>(observableList, p -> true);
//		findFilterTodosWhere
		if (keyMap == 1) {

			Predicate<AlunoPeriodoCurricularDto> p2 = obj -> obj.getAnoLetivo().contains("Ano Letivo: 2018")
					|| obj.getAnoLetivo().contains("Ano Letivo: 2017")
					;

//			filteredList.setPredicate(p1.and(p2).negate());
			filteredList.setPredicate(p2);
//			intTest = 20;
			
			filteredList = filteredList.filtered(p2);
			System.out.println("SIZE new? " + filteredList.size());
		}
//		findFilterUltimosPeriodosLetivosWhere
		else if (keyMap == 2) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))) {
					return true;
				} else {
					return false;
				}
			});
			
			
			Predicate<AlunoPeriodoCurricularDto> p2 = obj -> obj.getAnoLetivo().contains("Ano Letivo: 2018")
					&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
					;

//			filteredList.setPredicate(p1.and(p2).negate());
			filteredList.setPredicate(p2);
//			intTest = 20;
			
			filteredList = filteredList.filtered(p2);
			System.out.println("SIZE new? " + filteredList.size());
			
			
			
//			findFilterConcluintesWhere
		} else if (keyMap.equals(3)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& (obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
								&& (obj.getTurma().contains("Turma: NEJA-IV")
										|| obj.getTurma().contains("Turma: 3")))) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterConcluintesSemEmissaoWhere
		} else if (keyMap.equals(4)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND cd.nfl IS NULL "
						&& obj.getNflCertidao() == null
//						+ "AND cf.nfl IS NULL ";
						&& obj.getNflCertificado() == null) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterConcluintesComConcertidaoECertificadoWhere
		} else if (keyMap.equals(5)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND cd.nfl IS NULL "
						&& obj.getNflCertidao() != null
//						+ "AND cf.nfl IS NULL ";
						&& obj.getNflCertificado() != null) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterTodasOsCertidoesWhere
		} else if (keyMap.equals(6)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND cd.nfl IS NOT NULL "
						&& obj.getNflCertidao() != null) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterConcuintesComCertidaoSemCertificadoWhere
		} else if (keyMap.equals(7)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND cd.nfl IS NOT NULL "
						&& obj.getNflCertidao() != null
//						+ "AND cf.nfl IS NULL ";
						&& obj.getNflCertificado() == null) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterTodasOsCertificadosWhere
		} else if (keyMap.equals(8)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND cf.nfl IS NOT NULL "
						&& obj.getNflCertificado() != null) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterTodosOkWhere
		} else if (keyMap.equals(12)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND (a.dataNasc IS NOT NULL "
						&& obj.getDataNasc() != null
//						+ "AND a.nacionalidade IS NOT NULL "
						&& obj.getNacionalidade() != null
//						+ "AND a.naturalidade IS NOT NULL "
						&& obj.getNaturalidade() != null
//						+ "AND a.rg IS NOT NULL "
						&& obj.getRg() != null
//						+ "AND a.nomePai IS NOT NULL "
						&& obj.getNomePai() != null
//						+ "AND a.nomeMae IS NOT NULL "
						&& obj.getNomeMae() != null) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterPendDadosPessoaisWhere
		} else if (keyMap.equals(14)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') "
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND (a.dataNasc IS NULL "
						&& (obj.getDataNasc() == null
//							+ "OR a.nacionalidade IS NULL "
								|| obj.getNacionalidade() == null
//							+ "OR a.naturalidade IS NULL "
								|| obj.getNaturalidade() == null
//							+ "OR a.rg IS NULL "
								|| obj.getRg() == null
//							+ "OR a.nomePai IS NULL "
								|| obj.getNomePai() == null
//							+ "OR a.nomeMae IS NULL ")
								|| obj.getNomeMae() == null)) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterPendDataNascWhere
		} else if (keyMap.equals(17)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND a.dataNasc IS NULL ";
						&& obj.getDataNasc() == null) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterPendNacionalidadeWhere
		} else if (keyMap.equals(18)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND a.nacionalidade IS NULL ";
						&& obj.getNacionalidade() == null) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterPendNaturalidadeWhere
		} else if (keyMap.equals(19)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND a.naturalidade IS NULL ";
						&& obj.getNaturalidade() == null) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterPendRgWhere
		} else if (keyMap.equals(21)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND a.rg IS NULL ";
						&& obj.getRg() == null) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterPendNomePaiWhere
		} else if (keyMap.equals(24)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND a.NomePai IS NULL ";
						&& obj.getNomePai() == null) {
					return true;
				} else {
					return false;
				}
			});
//			findFilterPendNomeMaeWhere
		} else if (keyMap.equals(25)) {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))
//						+ "AND v.id.situacaoFinal = 'Aprovado' "
						&& obj.getSituacaoFinal().equals("Aprovado")
//						+ "AND a.NomeMae IS NULL ";
						&& obj.getNomeMae() == null) {
					return true;
				} else {
					return false;
				}
			});
		} else {
			filteredList.setPredicate(obj -> {
				if ((obj.getAnoLetivo().contains("Ano Letivo: 2018"))
//						+ " AND (v.id.turma LIKE 'Turma: NEJA-IV%' OR v.id.turma LIKE 'Turma: 3%') ";
						&& (obj.getTurma().contains("Turma: NEJA-IV") || obj.getTurma().contains("Turma: 3"))) {
					return true;
				} else {
					return false;
				}
			});
		}

		buildView(filteredList);

	}

	private void buildView(FilteredList<AlunoPeriodoCurricularDto> filteredList) {
		TreeItem<AlunoPeriodoCurricularDto> treeItemAlunoRoot = new TreeItem<>(
//				new AlunoPeriodoCurricularDto(null, null, null, null, null, "Turma", null, null, null)
		);
		treeTableViewAluno.setRoot(treeItemAlunoRoot);

//		for (AlunoPeriodoCurricularDto itemObsList : filteredList) {
//			TreeItem<AlunoPeriodoCurricularDto> node = new TreeItem<>(new AlunoPeriodoCurricularDto(null, null, null, null, null,
//					itemObsList.getTurma(), itemObsList.getNomeCompleto(),
//					itemObsList.getSexo(), itemObsList.getDataNasc(), itemObsList.getNomePai(),
//					itemObsList.getNomeMae(), itemObsList.getNacionalidade(), itemObsList.getNaturalidade(),
//					itemObsList.getNaturalidadeUF(), itemObsList.getRg(), itemObsList.getRgEmissor(),
//					itemObsList.getRgEmissorUf(), itemObsList.getMatricula(), itemObsList.getSituacaoFinal(),itemObsList.getNflCertidao(),
//					itemObsList.getNflCertificado(), itemObsList.getValidDadosPessoais(),
//					itemObsList.getValidDadosIdentif(), itemObsList.getValidDadosHeFund(),
//					itemObsList.getValidDadosHeMedio()));
		
		for (AlunoPeriodoCurricularDto itemObsList : filteredList) {
			System.out.println("Repetições onde?");
			TreeItem<AlunoPeriodoCurricularDto> node = new TreeItem<>(new AlunoPeriodoCurricularDto(null, itemObsList.getCurso(), itemObsList.getModalidade(),
					itemObsList.getSerie(), itemObsList.getTurma(), itemObsList.getMatricula(), itemObsList.getNomeCompleto(),
					itemObsList.getSexo(), itemObsList.getDataNasc(), itemObsList.getNomePai(),
					itemObsList.getNomeMae(), itemObsList.getNacionalidade(), itemObsList.getNaturalidade(),
					itemObsList.getNaturalidadeUF(), itemObsList.getRg(), itemObsList.getRgEmissor(),
					itemObsList.getRgEmissorUf(), itemObsList.getValidDadosPessoais(),
					itemObsList.getValidDadosIdentif(), itemObsList.getValidDadosHeFund(),
					itemObsList.getValidDadosHeMedio(), itemObsList.getSituacaoFinal(),
					itemObsList.getEnsMedioEstabEns(),
					itemObsList.getNflCertidao(),
					itemObsList.getNflCertificado()));

			TreeItem<AlunoPeriodoCurricularDto> turmaNode = node;

			TreeItem<AlunoPeriodoCurricularDto> alunoNode = node;

			Integer size = treeItemAlunoRoot.getChildren().size();

			if (size.equals(0)) {
				treeItemAlunoRoot.getChildren().add(turmaNode);
			} else {
				String ultimaTurmaAdd = treeItemAlunoRoot.getChildren().get(size - 1).getValue().getTurma();

				if (ultimaTurmaAdd.equals(itemObsList.getTurma())) {

					treeItemAlunoRoot.getChildren().get(size - 1).getChildren().add(alunoNode);

				} else {
					treeItemAlunoRoot.getChildren().add(turmaNode);
					System.out.println("adicionar a:" + turmaNode.getValue().getTurma());
				}
			}
			turmaNode.setExpanded(true);
			treeItemAlunoRoot.setExpanded(true);
		}

		treeTableViewAluno.setShowRoot(false);
	}

	@FXML
	public void onClickRadioButton(Event event) throws IOException {
//		RadioButton rb = new RadioButton();

		RadioButton eventSource = (RadioButton) event.getSource();
//		TODO
//		loadAlunosDetailsByFormElements(eventSource.getText());
		initializeNodes(null,eventSource.getId());

		System.out.println("Ráaaa 2: " + eventSource.getViewOrder());
		System.out.println("Ráaaa 2: " + eventSource.getId());
		System.out.println("Ráaaa 2: " + eventSource.getToggleGroup().getSelectedToggle());
		System.out.println("Ráaaa 3: " + eventSource.getText());

	}

	@FXML
	public void onClickTreeTableView(Event event) throws IOException {

		TreeTableView<?> treeTableView = (TreeTableView<?>) event.getSource();

		System.out.println("Clicked1! " + event.getSource());
		System.out.println("Clicked2! " + treeTableView.getFocusModel().getFocusedIndex());
		System.out.println("Clicked3! " + treeTableView.getFocusModel().getFocusedItem().getValue());

		AlunoPeriodoCurricularDto obj = (AlunoPeriodoCurricularDto) treeTableView.getFocusModel().getFocusedItem()
				.getValue();
		AlunoPeriodoCurricularDto obj2 = (AlunoPeriodoCurricularDto) treeTableView.getFocusModel().getFocusedItem()
				.getValue();
		
		System.out.println("obj2: " + obj2.getEnsMedioEstabEns());

		dadosAlunosController.updateFormData(obj);
		historicoAlunoController.updateFormData(obj2);
		dadosEscolasController.updateFormData(obj2);
	}

	@SuppressWarnings("unused")
	private void initCheckBoxDP() {

	}

	private void setDadosAlunosController(AlunoPeriodoCurricularDto obj) throws IOException {
		dadosAlunosController.updateFormData(obj);
	}
	
	public void setDataOfRowSelected(AlunoPeriodoCurricularDto obj) {
		System.out.println("DataAlunoObj = " + obj);
		System.out.println("Clicked2! " + treeTableViewAluno.getFocusModel().getFocusedIndex());
		treeTableViewAluno.getFocusModel().getFocusedItem().setValue(obj);
		treeTableViewAluno.refresh();
	}

	private void loadElementTreeTableColumBoolCertidao() {
//		CellValueFactory
		ObservableList<String> obsList = FXCollections.observableArrayList();
		obsList.addAll(Arrays.asList("Sim", "Não"));
		treeTableColumnBoolCertidao.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<AlunoPeriodoCurricularDto, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<AlunoPeriodoCurricularDto, String> param) {
						return null;
					}

				});
		treeTableColumnBoolCertidao.setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(obsList));

	}

	public void updateTreeTableView(Integer keyMap) {
		initializeNodes(keyMap, null);
		System.out.println("Agora");
	}

	public void updateProgressBar1() {
		progressBar.setProgress(1);
	}

	public void updateProgressBar0() {
		progressBar.setProgress(0);
	}

	public void updateProgressBarIndeterinate() {
		progressBar.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
	}
}
