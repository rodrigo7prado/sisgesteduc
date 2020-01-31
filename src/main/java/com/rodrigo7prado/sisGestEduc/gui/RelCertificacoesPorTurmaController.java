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

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

@Controller
public class RelCertificacoesPorTurmaController implements Initializable {

	@FXML
	private TableView<Turma> tableViewTurma;

	@FXML
	private TableColumn<Turma, String> tableColumnTurma;

	@FXML
	private TableColumn<Turma, Integer> tableColumnTotal;

	@FXML
	private TableColumn<Turma, Integer> tableColumnEfetuadas;

	@FXML
	private TableColumn<Turma, Integer> tableColumnPendentes;

	@FXML
	private TableColumn<Turma, Turma> tableColumnVISUALIZAR;

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
	private DadosConsolidadosService dadosConsolidadosService;

	@Autowired
	private TurmaService turmaService;

//	@Autowired
//	private AlunoService alunoService;

	private ObservableList<DadosConsolidadosAlunosDTO> dadosConsolidadosAlunosDtoList = FXCollections
			.observableArrayList();

	private ObservableList<Turma> turmaList = FXCollections.observableArrayList();

//	private ObservableList<Aluno> alunoList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		loadTurmaDetails();
		loadAlunosDetails();

		System.out.println(dadosConsolidadosService.findById(1L));

//		checkBoxDP.applyCss();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initializeNodes() {
		tableColumnTurma.setCellValueFactory(new PropertyValueFactory<>("nome"));
		treeTableColumnTurma.setCellValueFactory(new TreeItemPropertyValueFactory("turma"));
		treeTableColumnAluno.setCellValueFactory(new TreeItemPropertyValueFactory("aluno"));
		treeTableColumnNomeCompl.setCellValueFactory(new TreeItemPropertyValueFactory("nomeCompl"));
		treeTableColumnSituacaoFinal.setCellValueFactory(new TreeItemPropertyValueFactory("situacaoFinal"));
	}

	public void updateTableView() throws InterruptedException {
		turmaList.clear();
		turmaList.addAll(turmaService.findAll());
		tableViewTurma.setItems(turmaList);
		initVisualizarButtons();
	}

	private void loadTurmaDetails() {
		turmaList.clear();
		turmaList.addAll(turmaService.findAll());
		tableViewTurma.setItems(turmaList);
	}

//	@SuppressWarnings("unlikely-arg-type")
	private void loadAlunosDetails() {

		dadosConsolidadosAlunosDtoList.clear();
		dadosConsolidadosAlunosDtoList.addAll(dadosConsolidadosService.findFilterConcluintes());

//		alunoList.clear();
//		alunoList.addAll(alunoService.findAll());

//		TreeItem<Aluno> treeItemAlunoRoot = new TreeItem<>(new Aluno(1L,"Aluno","Turma")); // turma n0
		TreeItem<DadosConsolidadosAlunosDTO> treeItemAlunoRoot = new TreeItem<>(
				new DadosConsolidadosAlunosDTO(null, null, null, null, null, "Turma", null, "Aluno", null, null));
		treeTableViewAluno.setRoot(treeItemAlunoRoot);
//		treeTableViewAluno.setEditable(true);
//		treeTableColumnAluno.setEditable(true);

		for (DadosConsolidadosAlunosDTO aluno : dadosConsolidadosAlunosDtoList) {

//			TreeItem<Aluno> turmaNode = new TreeItem<>(new Aluno(null,aluno.getNome(),aluno.getTurma()));
//			TreeItem<Aluno> turmaNode = new TreeItem<>(new DadosConsolidadosAlunosDTO(null,aluno.getNomeCompl(),aluno.getTurma()));
			TreeItem<DadosConsolidadosAlunosDTO> turmaNode = new TreeItem<>(new DadosConsolidadosAlunosDTO(null, null,
					null, null, null, aluno.getTurma(), null, "...", null, null));

//			TreeItem<Aluno> alunoNode = new TreeItem<>(new Aluno(null,aluno.getNome(),null));
//			TreeItem<Aluno> alunoNode = new TreeItem<>(new Aluno(null,aluno.getNome(),null));
			TreeItem<DadosConsolidadosAlunosDTO> alunoNode = new TreeItem<>(
					new DadosConsolidadosAlunosDTO(null, null, null, null, null, aluno.getTurma(), aluno.getAluno(),
							aluno.getNomeCompl(), null, aluno.getSituacaoFinal()));
			Integer size = treeItemAlunoRoot.getChildren().size();

			if (size.equals(0)) {
				treeItemAlunoRoot.getChildren().add(turmaNode);
			} else {
				String ultimaTurmaAdd = treeItemAlunoRoot.getChildren().get(size - 1).getValue().getTurma();

				if (ultimaTurmaAdd.equals(aluno.getTurma())) {
//					System.out.println("boolean: " + true);
//					TreeItem<Aluno> alunoNode = new TreeItem<>(new Aluno(null,aluno.getNome(),aluno.getTurma()));

					treeItemAlunoRoot.getChildren().get(size - 1).getChildren().add(alunoNode);

//					turmaNode.getChildren().add(0,alunoNode);

				} else {
//					System.out.println("boolean: " + false);
					treeItemAlunoRoot.getChildren().add(turmaNode);
					System.out.println("adicionar a:" + turmaNode.getValue().getTurma());
				}
			}
//			turmaNode.setExpanded(true);
			turmaNode.setExpanded(false);
			treeItemAlunoRoot.setExpanded(true);
		}

		for (Turma turma : turmaList) {
			turma.getNome();

//			TreeItem<Aluno> turmaNode = new TreeItem<>(new Aluno(null,aluno.getNome(),aluno.getTurma()));
//			treeItemAlunoRoot.getChildren().add(turmaNode);

		}

		treeTableViewAluno.setShowRoot(false);
		initCheckBoxDP();
	}

	private void initVisualizarButtons() {
		tableColumnVISUALIZAR.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnVISUALIZAR.setCellFactory(param -> new TableCell<Turma, Turma>() {

			private final Button button = new Button("Visualizar");

			@Override
			protected void updateItem(Turma obj, boolean empty) {
				super.updateItem(obj, empty);

				if (obj == null) {
					setGraphic(null);
					return;
				}

				setGraphic(button);
			}
		});
	}

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
