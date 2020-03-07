package com.rodrigo7prado.sisGestEduc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.config.StageManager;
import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.enums.StatusDocAluno;
import com.rodrigo7prado.sisGestEduc.services.AlunoPeriodoCurricularService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.VBox;

@Controller
public class RelCertificacoesPorAlunoController implements Initializable {
	
//	@FXML
//	private VBox vBoxControllerDadosAlunos;
	
	@FXML
	@Autowired
	private DadosAlunosController dadosAlunosController;

	@Lazy
	@Autowired
	private StageManager stageManager;

	@Autowired
	private AlunoPeriodoCurricularService service;

	private ObservableList<AlunoPeriodoCurricularDto> observableList = FXCollections.observableArrayList();

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
	private VBox dialog;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		loadAlunosDetails();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initializeNodes() {

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

	private void loadAlunosDetails() {

		observableList.clear();
		observableList.addAll(service.findFilterConcluintes());
		TreeItem<AlunoPeriodoCurricularDto> treeItemAlunoRoot = new TreeItem<>(
//				new AlunoPeriodoCurricularDto(null, null, null, null, null, "Turma", null, null, null)
		);
		treeTableViewAluno.setRoot(treeItemAlunoRoot);

		for (AlunoPeriodoCurricularDto itemObsList : observableList) {
			TreeItem<AlunoPeriodoCurricularDto> turmaNode = new TreeItem<>(
					new AlunoPeriodoCurricularDto(null, null, null, itemObsList.getTurma(), itemObsList.getMatricula(),
							itemObsList.getNomeCompleto(), itemObsList.getValidDadosPessoais(),
							itemObsList.getValidDadosIdentif(), itemObsList.getValidDadosHeFund(),
							itemObsList.getValidDadosHeMedio(), itemObsList.getSituacaoFinal()));
			TreeItem<AlunoPeriodoCurricularDto> alunoNode = new TreeItem<>(
					new AlunoPeriodoCurricularDto(null, null, null, itemObsList.getTurma(), itemObsList.getMatricula(),
							itemObsList.getNomeCompleto(), itemObsList.getValidDadosPessoais(),
							itemObsList.getValidDadosIdentif(), itemObsList.getValidDadosHeFund(),
							itemObsList.getValidDadosHeMedio(), itemObsList.getSituacaoFinal()));
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
			turmaNode.setExpanded(false);
			treeItemAlunoRoot.setExpanded(true);
		}

		treeTableViewAluno.setShowRoot(false);
//		initCheckBoxDP();
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
		
		AlunoPeriodoCurricularDto obj = (AlunoPeriodoCurricularDto) treeTableView.getFocusModel().getFocusedItem().getValue();  
		
		setDadosAlunosController(obj);
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
		
		Parent parent = FXMLLoader.load(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/DadosAlunos.fxml"));
		
		System.out.println("Controller: " + dadosAlunosController);
		
		dadosAlunosController.updateFormData(obj);
		
		System.out.println(parent.getProperties());
//		
//		dadosAlunosController.setController(obj);
//		
//		dadosAlunosController.updateFormData();
	}
}
