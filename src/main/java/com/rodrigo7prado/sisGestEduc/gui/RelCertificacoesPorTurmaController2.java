package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.config.StageManager;
import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.entities.Turma;
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
public class RelCertificacoesPorTurmaController2 implements Initializable {
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
	private TreeTableColumn<Turma, Integer> treeTableColumnAlunoTurma;
	
//	private ObservableList<Turma> obsList;
	
	@FXML
	private TreeTableView<Turma> treeTableViewAluno;
	
	@FXML
	private TreeTableColumn<Turma, String> treeTableColumnTurma;
	
	@FXML
	private TreeTableColumn<Turma, String> treeTableColumnAluno;
	
	@FXML
	private Label lbl;
	
	@Lazy
	@Autowired
	private StageManager stageManager;
	
	@Autowired
	private TurmaService turmaService;
	
//	@Autowired
//	private AlunoService alunoService;
	
	private ObservableList<Turma> turmaList = FXCollections.observableArrayList();
	
	private ObservableList<Aluno> alunoList = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		loadTurmaDetails();
		loadAlunosDetails();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initializeNodes() {	
		tableColumnTurma.setCellValueFactory(new PropertyValueFactory<>("nome"));
		treeTableColumnTurma.setCellValueFactory(new TreeItemPropertyValueFactory("nome"));
	}
	
	public void updateTableView() throws InterruptedException {
		turmaList.clear();
		turmaList.addAll(turmaService.findAll());
		tableViewTurma.setItems(turmaList);
		initVisualizarButtons();
	}
	
	private void loadTurmaDetails(){
		turmaList.clear();
		turmaList.addAll(turmaService.findAll());
		tableViewTurma.setItems(turmaList);
	}
	
	private void loadAlunosDetails(){
		turmaList.clear();
		turmaList.addAll(turmaService.findAll());
		
		TreeItem<Turma> treeItemTurmaRoot = new TreeItem<>(new Turma(1L,"3001")); // turma n0
		treeTableViewTurma.setRoot(treeItemTurmaRoot);
		
		for (Turma turma : turmaList) {
			TreeItem<Turma> turmaNode = new TreeItem<>(new Turma(null,turma.getNome()));
			treeItemTurmaRoot.getChildren().add(turmaNode);
			
			TreeItem<Aluno> treeItemAlunoRoot = new TreeItem<>(new Aluno(null,"Aluno","Turma")); // aluno n0
			
//			turmaNode.getChildren().add(treeItemAlunoRoot);
			
//			treeTableViewAluno.setRoot(treeItemAlunoRoot);  .setRoot(treeItemAlunoRoot);
			for (Aluno aluno : alunoList) {
				
				TreeItem<Aluno> alunoNode = new TreeItem<>(new Aluno(null,aluno.getNome(),null));
				treeItemAlunoRoot.getChildren().add(alunoNode);
			}
			
		}
		
		treeTableViewTurma.setShowRoot(false);
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
}
