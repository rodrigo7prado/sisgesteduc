package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.config.StageManager;
import com.rodrigo7prado.sisGestEduc.dto.DadosConsolidadosAlunosDTO;
import com.rodrigo7prado.sisGestEduc.entities.Turma;
import com.rodrigo7prado.sisGestEduc.services.DadosConsolidadosService;
import com.rodrigo7prado.sisGestEduc.services.TurmaService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

@Controller
public class RelCertificacoesPorAlunoController2 implements Initializable {

	@FXML
	private TreeTableView<Turma> treeTableViewTurma;

	@FXML
	private TreeTableView<DadosConsolidadosAlunosDTO> treeTableViewAluno;

	@FXML
	private TreeTableColumn<DadosConsolidadosAlunosDTO, String> treeTableColumnTurma;

	@FXML
	private TreeTableColumn<DadosConsolidadosAlunosDTO, String> treeTableColumnAluno;

	@FXML
	private TreeTableColumn<DadosConsolidadosAlunosDTO, String> treeTableColumnNomeCompl;

	@FXML
	private TreeTableColumn<DadosConsolidadosAlunosDTO, String> treeTableColumnSituacaoFinal;

	@FXML
	private TreeTableColumn<Turma, Integer> treeTableColumnAlunoTurma;

	@FXML
	private TreeTableColumn<DadosConsolidadosAlunosDTO, Boolean> treeTableColumnDP;

	@FXML
	private Label lbl;

	@Lazy
	@Autowired
	private StageManager stageManager;

	@Autowired
	private DadosConsolidadosService service;

	@Autowired
	private TurmaService turmaService;

	private ObservableList<DadosConsolidadosAlunosDTO> observableList = FXCollections
			.observableArrayList();

	private ObservableList<Turma> turmaList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		loadTurmaDetails();
		loadAlunosDetails();

//		System.out.println(service.findById(1L));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initializeNodes() {
		treeTableColumnTurma.setCellValueFactory(new TreeItemPropertyValueFactory("turma"));
		treeTableColumnAluno.setCellValueFactory(new TreeItemPropertyValueFactory("aluno"));
		treeTableColumnNomeCompl.setCellValueFactory(new TreeItemPropertyValueFactory("nomeCompl"));
		treeTableColumnSituacaoFinal.setCellValueFactory(new TreeItemPropertyValueFactory("situacaoFinal"));
	}

	public void updateTableView() throws InterruptedException {
		turmaList.clear();
		turmaList.addAll(turmaService.findAll());
	}

	private void loadTurmaDetails() {
		turmaList.clear();
		turmaList.addAll(turmaService.findAll());
	}

	private void loadAlunosDetails() {

		observableList.clear();
		observableList.addAll(service.findFilterConcluintes());
		TreeItem<DadosConsolidadosAlunosDTO> treeItemAlunoRoot = new TreeItem<>(
				new DadosConsolidadosAlunosDTO(null, null, null, null, null, "Turma", null, "Aluno", null, null));
		treeTableViewAluno.setRoot(treeItemAlunoRoot);

		for (DadosConsolidadosAlunosDTO aluno : observableList) {
			TreeItem<DadosConsolidadosAlunosDTO> turmaNode = new TreeItem<>(new DadosConsolidadosAlunosDTO(null, null,
					null, null, null, aluno.getTurma(), null, "...", null, null));
			TreeItem<DadosConsolidadosAlunosDTO> alunoNode = new TreeItem<>(
					new DadosConsolidadosAlunosDTO(null, null, null, null, null, aluno.getTurma(), aluno.getAluno(),
							aluno.getNomeCompl(), null, aluno.getSituacaoFinal()));
			Integer size = treeItemAlunoRoot.getChildren().size();

			if (size.equals(0)) {
				treeItemAlunoRoot.getChildren().add(turmaNode);
			} else {
				String ultimaTurmaAdd = treeItemAlunoRoot.getChildren().get(size - 1).getValue().getTurma();

				if (ultimaTurmaAdd.equals(aluno.getTurma())) {

					treeItemAlunoRoot.getChildren().get(size - 1).getChildren().add(alunoNode);

				} else {
					treeItemAlunoRoot.getChildren().add(turmaNode);
					System.out.println("adicionar a:" + turmaNode.getValue().getTurma());
				}
			}
			turmaNode.setExpanded(false);
			treeItemAlunoRoot.setExpanded(true);
		}

		for (Turma turma : turmaList) {
			turma.getNome();
		}

		treeTableViewAluno.setShowRoot(false);
//		initCheckBoxDP();
	}

	@SuppressWarnings("unused")
	private void initCheckBoxDP() {
//		treeTableColumnDP.setCellValueFactory((callback) -> {return new ReadOnlyObjectWrapper<DadosConsolidadosAlunosDTO>(callback.getValue().getValue());});
//		treeTableColumnDP.setCellFactory(param -> new TreeTableCell<DadosConsolidadosAlunosDTO, Boolean>() {
//			private CheckBox checkBox;
//
//			@Override
//			protected void updateItem(DadosConsolidadosAlunosDTO obj, boolean empty) {
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
//				.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<DadosConsolidadosAlunosDTO, Boolean>, //
//						ObservableValue<Boolean>>() {
//
//					@Override
//					public ObservableValue<Boolean> call(
//							TreeTableColumn.CellDataFeatures<DadosConsolidadosAlunosDTO, Boolean> param) {
//						TreeItem<DadosConsolidadosAlunosDTO> treeItem = param.getValue();
//						DadosConsolidadosAlunosDTO emp = treeItem.getValue();
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
//				new Callback<TreeTableColumn<DadosConsolidadosAlunosDTO, Boolean>, TreeTableCell<DadosConsolidadosAlunosDTO, Boolean>>() {
//					@Override
//					public TreeTableCell<DadosConsolidadosAlunosDTO, Boolean> call(
//							TreeTableColumn<DadosConsolidadosAlunosDTO, Boolean> p) {
//						CheckBoxTreeTableCell<DadosConsolidadosAlunosDTO, Boolean> cell = new CheckBoxTreeTableCell<DadosConsolidadosAlunosDTO, Boolean>();
//						cell.setAlignment(Pos.CENTER);
//						return cell;
//					}
//				});
	}
}
