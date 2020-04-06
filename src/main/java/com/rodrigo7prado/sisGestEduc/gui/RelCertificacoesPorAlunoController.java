package com.rodrigo7prado.sisGestEduc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
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

//	@FXML
//	private VBox vBoxControllerDadosAlunos;

	@FXML
	private VBox vBoxControllerFiltro;

	@FXML
	ProgressBar progressBar;

	@FXML
	@Autowired
	private DadosAlunosController dadosAlunosController;
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
	private Map<Integer,List<AlunoPeriodoCurricularDto>> mapCarregamentos = new HashMap<Integer,List<AlunoPeriodoCurricularDto>>();
	private Map<String,List<String>> mapCarregamentos2 = new HashMap<String,List<String>>();

	@FXML
	private TreeTableView<AlunoPeriodoCurricularDto> treeTableViewAluno;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, String> treeTableColumnTurma;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, String> treeTableColumnAluno;
	@FXML
	private TreeTableColumn<AlunoPeriodoCurricularDto, String> treeTableColumnNomeCompl;
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

	private Thread thread3;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		this.mapCarregamentos.put(0, service.findFilterNull());
		this.mapCarregamentos.put(1, service.findFilterTodos());
		this.mapCarregamentos.put(2, service.findFilterUltimosPeriodosLetivos());
		this.mapCarregamentos.put(3, service.findFilterConcluintes());
		
		this.mapCarregamentos.put(9, service.findFilterTodosOk());
		this.mapCarregamentos.put(11, service.findFilterPendDadosPessoais());
		this.mapCarregamentos.put(14, service.findFilterPendDataNasc());
		this.mapCarregamentos.put(15, service.findFilterPendNacionalidade());
		this.mapCarregamentos.put(16, service.findFilterPendNaturalidade());
		this.mapCarregamentos.put(18, service.findFilterPendRg());
		this.mapCarregamentos.put(21, service.findFilterPendNomePai());
		this.mapCarregamentos.put(22, service.findFilterPendNomeMae());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void associateTreeTableColumns() {
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		System.out.println("Service: " + service.findFilterConcluintes());
		treeTableColumnTurma.setCellValueFactory(new TreeItemPropertyValueFactory("turma"));
		treeTableColumnAluno.setCellValueFactory(new TreeItemPropertyValueFactory("matricula"));
		treeTableColumnNomeCompl.setCellValueFactory(new TreeItemPropertyValueFactory("nomeCompleto"));
		treeTableColumnDP.setCellValueFactory(new TreeItemPropertyValueFactory("validDadosPessoais"));
		treeTableColumnDadosIdentif.setCellValueFactory(new TreeItemPropertyValueFactory("validDadosIdentif"));
		treeTableColumnDadosHeFund.setCellValueFactory(new TreeItemPropertyValueFactory("validDadosHeFund"));
		treeTableColumnDadosHeMedio.setCellValueFactory(new TreeItemPropertyValueFactory("validDadosHeMedio"));
		treeTableColumnSituacaoFinal.setCellValueFactory(new TreeItemPropertyValueFactory("situacaoFinal"));
	}

//	@SuppressWarnings("unused")
	private void initializeNodes(Integer keyMap) {

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
						loadAlunosDetails(keyMap);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread2.start();

	}

	private void loadAlunosDetails(Integer keyMap) {

		observableList.clear();

		observableList.addAll(mapCarregamentos.get(keyMap));

		TreeItem<AlunoPeriodoCurricularDto> treeItemAlunoRoot = new TreeItem<>(
//						new AlunoPeriodoCurricularDto(null, null, null, null, null, "Turma", null, null, null)
		);
		treeTableViewAluno.setRoot(treeItemAlunoRoot);

		for (AlunoPeriodoCurricularDto itemObsList : observableList) {
			TreeItem<AlunoPeriodoCurricularDto> node = new TreeItem<>(new AlunoPeriodoCurricularDto(null, null, null,
					itemObsList.getTurma(), itemObsList.getMatricula(), itemObsList.getNomeCompleto(),
					itemObsList.getSexo(), itemObsList.getDataNasc(), itemObsList.getNomePai(),
					itemObsList.getNomeMae(), itemObsList.getNacionalidade(), itemObsList.getNaturalidade(),
					itemObsList.getNaturalidadeUF(), itemObsList.getRg(), itemObsList.getRgEmissor(),
					itemObsList.getRgEmissorUf(), itemObsList.getValidDadosPessoais(),
					itemObsList.getValidDadosIdentif(), itemObsList.getValidDadosHeFund(),
					itemObsList.getValidDadosHeMedio(), itemObsList.getSituacaoFinal()));

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
//				initCheckBoxDP();

	}

	@FXML
	public void onClickTreeTableView(Event event) throws IOException {
//		@SuppressWarnings("unchecked")
//		TreeTableView<AlunoPeriodoCurricularDto> treeTableView = (TreeTableView<AlunoPeriodoCurricularDto>) event.getSource();

		TreeTableView<?> treeTableView = (TreeTableView<?>) event.getSource();

//		AlunoPeriodoCurricularDto obj = (AlunoPeriodoCurricularDto) treeTableView.getFocusModel().getFocusedItem().getValue();

		System.out.println("Clicked! " + event.getSource());
		System.out.println("Clicked! " + treeTableView.getFocusModel().getFocusedIndex());
		System.out.println("Clicked! " + treeTableView.getFocusModel().getFocusedItem().getValue());

		AlunoPeriodoCurricularDto obj = (AlunoPeriodoCurricularDto) treeTableView.getFocusModel().getFocusedItem()
				.getValue();
		AlunoPeriodoCurricularDto obj2 = (AlunoPeriodoCurricularDto) treeTableView.getFocusModel().getFocusedItem()
				.getValue();

//		setDadosAlunosController(obj);
		dadosAlunosController.updateFormData(obj);
		historicoAlunoController.updateFormData(obj2);
	}

	@SuppressWarnings("unused")
	private void initCheckBoxDP() {
		
	}

	private void setDadosAlunosController(AlunoPeriodoCurricularDto obj) throws IOException {
		dadosAlunosController.updateFormData(obj);
	}

	private void loadElementTreeTableColumBoolCertidao() {
//		CellValueFactory
		ObservableList<String> obsList = FXCollections.observableArrayList();
		obsList.addAll(Arrays.asList("Sim", "Não"));
		treeTableColumnBoolCertidao.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<AlunoPeriodoCurricularDto, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<AlunoPeriodoCurricularDto, String> param) {
						// TODO Auto-generated method stub
						return null;
					}

				});
		treeTableColumnBoolCertidao.setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(obsList));

	}

	public void updateTreeTableView(Integer keyMap) {
		initializeNodes(keyMap);
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
