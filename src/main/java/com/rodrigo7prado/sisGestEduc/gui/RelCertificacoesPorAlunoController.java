package com.rodrigo7prado.sisGestEduc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
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

	private List<AlunoPeriodoCurricularDto> carregamento;

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
//		progressBar.setProgress(0);
		this.carregamento = service.findFilterConcluintes();

//		this.thread3 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				Platform.runLater(new Runnable() {
//					@Override
//					public void run() {
//						associateTreeTableColumns();
//						loadAlunosDetails();
//						loadElementTreeTableColumBoolCertidao();
////						progressBar.setProgress(1);
//					}
//				});
//			}
//		});

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
	private void initializeNodes() {

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
						loadAlunosDetails();
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
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread2.start();
//		progressBar.setProgress(0);

//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		progressBar.setProgress(0.1);

//		do {
//			progressBar.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
//		} while (!thread2.isAlive());

//		progressBar.setProgress(1);
//		thread2.interrupt();
//		progressBar.progressProperty().setValue(0.23);

//		System.out.println("TESTANDO!");

//		thread2.start();

//		while(thread2.isAlive()) {
////			System.out.println("TESTANDO!");
//			thread2.interrupt();
//			progressBar.setProgress(0);
//			progressBar.indeterminateProperty();
//		}

//		if (thread2.isAlive() == false) {
//			progressBar.setProgress(1);
//		}

//		else {
//			progressBar.setProgress(0);
//		}

//		thread2.run();
//		thread2.start();

//		thread.run();
//		progressBar.setProgress(0);

//		try {
//			thread.run();
//			thread.interrupt();
//			progressBar.setProgress(0);
//			thread.wait(100);
//			thread.start();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		thread1.start();
//		try {
//			thread1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		thread2.start();

//		progressBar.isIndeterminate();

//		ProgressBar bar = new ProgressBar();
//		bar.progressProperty().bind(task.progressProperty());
//		new Thread(task).start();

//		new Thread() {
//			@Override
//			public void run() {
//				
//			}
//		}.start();

	}

	private void loadAlunosDetails() {

		observableList.clear();

		observableList.addAll(carregamento);

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
//		treeTableColumnDP.setCellValueFactory((callback) -> {return new ReadOnlyObjectWrapper<AlunoPeriodoCurricularDto>(callback.getValue().getValue());});
//		treeTableColumnDP.setCellFactory(param -> new TreeTableCell<AlunoPeriodoCurricularDto, Boolean>() {
//			private CheckBox checkBox;
//
//			protected void updateItem(AlunoPeriodoCurricularDto obj, boolean empty) {
//				super.updateItem(obj, empty);
//				
//				if (obj == null) {
//					setGraphic(null);
//					return;
//				}
//				//System.out.println(obj.getName());
//				
//				checkBox = new CheckBox();
//				
//				setGraphic(checkBox);
//			}
//		});

//		treeTableColumnDP
//				.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<AlunoPeriodoCurricularDto, Boolean>, //
//						ObservableValue<Boolean>>() {
//
//					@Override
//					public ObservableValue<Boolean> call(
//							TreeTableColumn.CellDataFeatures<AlunoPeriodoCurricularDto, Boolean> param) {
//						TreeItem<AlunoPeriodoCurricularDto> treeItem = param.getValue();
//						AlunoPeriodoCurricularDto emp = treeItem.getValue();
//						SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(emp.isSingle());
//
//						// Note: singleCol.setOnEditCommit(): Not work for
//						// CheckBoxTreeTableCell.
//						// When "Single?" column change.
//						booleanProp.addListener(new ChangeListener<Boolean>() {
//
//							@Override
//							public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
//									Boolean newValue) {
//								emp.setSingle(newValue);
//							}
//						});
//						return booleanProp;
//					}
//				});
//
//		treeTableColumnDP.setCellFactory(
//				new Callback<TreeTableColumn<AlunoPeriodoCurricularDto, Boolean>, TreeTableCell<AlunoPeriodoCurricularDto, Boolean>>() {
//					@Override
//					public TreeTableCell<AlunoPeriodoCurricularDto, Boolean> call(
//							TreeTableColumn<AlunoPeriodoCurricularDto, Boolean> p) {
//						CheckBoxTreeTableCell<AlunoPeriodoCurricularDto, Boolean> cell = new CheckBoxTreeTableCell<AlunoPeriodoCurricularDto, Boolean>();
//						cell.setAlignment(Pos.CENTER);
//						return cell;
//					}
//				});
	}

	private void setDadosAlunosController(AlunoPeriodoCurricularDto obj) throws IOException {

//		System.out.println("gerResource: " + getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/DadosAlunos.fxml"));
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/DadosAlunos.fxml"));
//		loader.setControllerFactory(context::getBean);

//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/DadosAlunos.fxml"));
//		loader.setLocation(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/DadosAlunos.fxml"));
//		loader.load();

//		System.out.println(loader);

//		DadosAlunosController dadosAlunosController = dadosAlunosController.getData();

//		FXMLLoader fxmlLoader = new FXMLLoader();
//		fxmlLoader.load(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/DadosAlunos.fxml").openStream());
//		DadosAlunosController dadosAlunosController = (DadosAlunosController) fxmlLoader.getController();

//		FXMLLoader loader = new FXMLLoader();

//		System.out.println(loader.getResources());

//		System.out.println(vBoxControllerDadosAlunos  .getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/DadosAlunos.fxml"));

//		Parent parent = FXMLLoader.load(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/DadosAlunos.fxml"));

//		System.out.println("Controller: " + dadosAlunosController);

		dadosAlunosController.updateFormData(obj);

//		System.out.println(parent.getProperties());
//		
//		dadosAlunosController.setController(obj);
//		
//		dadosAlunosController.updateFormData();
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
//		treeTableColumnBoolCertidao.setCellFactory(param -> new TableCell<AlunoPeriodoCurricularDto, Boolean>() {

	}

	public void updateTreeTableView() {

//		progressBar.setProgress(1);
		// progressBar.setProgress(0);
		initializeNodes();
//		progressBar.setProgress(1);
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
