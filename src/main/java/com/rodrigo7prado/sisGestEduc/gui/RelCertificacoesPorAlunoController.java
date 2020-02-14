package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.config.StageManager;
import com.rodrigo7prado.sisGestEduc.dto.ResultadoFinalExternalDTO;
import com.rodrigo7prado.sisGestEduc.services.ResultadoFinalExternalService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

@Controller
public class RelCertificacoesPorAlunoController implements Initializable {

	@Lazy
	@Autowired
	private StageManager stageManager;

	@Autowired
	private ResultadoFinalExternalService service;

	private ObservableList<ResultadoFinalExternalDTO> observableList = FXCollections.observableArrayList();

	@FXML
	private TreeTableView<ResultadoFinalExternalDTO> treeTableViewAluno;

	@FXML
	private TreeTableColumn<ResultadoFinalExternalDTO, String> treeTableColumnTurma;

	@FXML
	private TreeTableColumn<ResultadoFinalExternalDTO, String> treeTableColumnAluno;

	@FXML
	private TreeTableColumn<ResultadoFinalExternalDTO, String> treeTableColumnNomeCompl;

	@FXML
	private TreeTableColumn<ResultadoFinalExternalDTO, String> treeTableColumnSituacaoFinal;

	@FXML
	private TreeTableColumn<ResultadoFinalExternalDTO, Boolean> treeTableColumnDP;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		loadAlunosDetails();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initializeNodes() {
		treeTableColumnTurma.setCellValueFactory(new TreeItemPropertyValueFactory("turma"));
		treeTableColumnAluno.setCellValueFactory(new TreeItemPropertyValueFactory("matricula"));
		treeTableColumnNomeCompl.setCellValueFactory(new TreeItemPropertyValueFactory("nomeCompl"));
		treeTableColumnSituacaoFinal.setCellValueFactory(new TreeItemPropertyValueFactory("situacaoFinal"));
	}

	private void loadAlunosDetails() {

		observableList.clear();
		observableList.addAll(service.findFilterConcluintes());
		TreeItem<ResultadoFinalExternalDTO> treeItemAlunoRoot = new TreeItem<>(
				new ResultadoFinalExternalDTO(null, null, null, null, null, "Turma", null, null, null, null));
		treeTableViewAluno.setRoot(treeItemAlunoRoot);

		for (ResultadoFinalExternalDTO itemObsList : observableList) {
			TreeItem<ResultadoFinalExternalDTO> turmaNode = new TreeItem<>(new ResultadoFinalExternalDTO(
					null, null, null, null, null, itemObsList.getTurma(),
					itemObsList.getNomeCompl(), itemObsList.getAluno(), "...", null));
			TreeItem<ResultadoFinalExternalDTO> alunoNode = new TreeItem<>(new ResultadoFinalExternalDTO(
					null, null, null, null, null, itemObsList.getTurma(),
					itemObsList.getNomeCompl(), itemObsList.getAluno(), null, itemObsList.getSituacaoFinal()));
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

	@SuppressWarnings("unused")
	private void initCheckBoxDP() {
//		treeTableColumnDP.setCellValueFactory((callback) -> {return new ReadOnlyObjectWrapper<ResultadoFinalExternalDTO>(callback.getValue().getValue());});
//		treeTableColumnDP.setCellFactory(param -> new TreeTableCell<ResultadoFinalExternalDTO, Boolean>() {
//			private CheckBox checkBox;
//
//			@Override
//			protected void updateItem(ResultadoFinalExternalDTO obj, boolean empty) {
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
//				.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ResultadoFinalExternalDTO, Boolean>, //
//						ObservableValue<Boolean>>() {
//
//					@Override
//					public ObservableValue<Boolean> call(
//							TreeTableColumn.CellDataFeatures<ResultadoFinalExternalDTO, Boolean> param) {
//						TreeItem<ResultadoFinalExternalDTO> treeItem = param.getValue();
//						ResultadoFinalExternalDTO emp = treeItem.getValue();
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
//				new Callback<TreeTableColumn<ResultadoFinalExternalDTO, Boolean>, TreeTableCell<ResultadoFinalExternalDTO, Boolean>>() {
//					@Override
//					public TreeTableCell<ResultadoFinalExternalDTO, Boolean> call(
//							TreeTableColumn<ResultadoFinalExternalDTO, Boolean> p) {
//						CheckBoxTreeTableCell<ResultadoFinalExternalDTO, Boolean> cell = new CheckBoxTreeTableCell<ResultadoFinalExternalDTO, Boolean>();
//						cell.setAlignment(Pos.CENTER);
//						return cell;
//					}
//				});
	}
}
