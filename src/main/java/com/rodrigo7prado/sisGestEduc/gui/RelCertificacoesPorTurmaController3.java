package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.config.StageManager;
import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.entities.Turma;
import com.rodrigo7prado.sisGestEduc.services.AlunoService;
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
public class RelCertificacoesPorTurmaController3 implements Initializable {
	
	
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
	private TreeTableView<Aluno> treeTableViewAluno;
	
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
	private DadosConsolidadosService dadosConsolidadosService;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private AlunoService alunoService;
	
	private ObservableList<Turma> turmaList = FXCollections.observableArrayList();
	
	private ObservableList<Aluno> alunoList = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		loadTurmaDetails();
		loadAlunosDetails();
		
		
		System.out.println(dadosConsolidadosService.findById(1L));
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initializeNodes() {	
		tableColumnTurma.setCellValueFactory(new PropertyValueFactory<>("nome"));
		treeTableColumnTurma.setCellValueFactory(new TreeItemPropertyValueFactory("turma"));
		treeTableColumnAluno.setCellValueFactory(new TreeItemPropertyValueFactory("nome"));
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
	
//	@SuppressWarnings("unlikely-arg-type")
	private void loadAlunosDetails(){
		
//		System.out.println("AAAA0");
//	    System.out.println(alunoService.findById(1L));
		
		alunoList.clear();
		alunoList.addAll(alunoService.findAll());
		
		TreeItem<Aluno> treeItemAlunoRoot = new TreeItem<>(new Aluno(1L,"Aluno","Turma")); // turma n0
		treeTableViewAluno.setRoot(treeItemAlunoRoot);
		
		for (Aluno aluno : alunoList) {
			
			TreeItem<Aluno> turmaNode = new TreeItem<>(new Aluno(null,aluno.getNome(),aluno.getTurma()));
			TreeItem<Aluno> alunoNode = new TreeItem<>(new Aluno(null,aluno.getNome(),null));
			Integer size = treeItemAlunoRoot.getChildren().size();
			
			if (size.equals(0)) {
				treeItemAlunoRoot.getChildren().add(turmaNode);
			} else {
				String ultimaTurmaAdd = treeItemAlunoRoot.getChildren().get(size-1).getValue().getTurma();
				
				if(ultimaTurmaAdd.equals(aluno.getTurma())) {
					System.out.println("boolean: " + true);
//					TreeItem<Aluno> alunoNode = new TreeItem<>(new Aluno(null,aluno.getNome(),aluno.getTurma()));
					
					System.out.println("adicionar a:" + turmaNode.getValue().getTurma());
					
					treeItemAlunoRoot.getChildren().get(size-1).getChildren().add(alunoNode);
					
//					turmaNode.getChildren().add(0,alunoNode);
					
				} else {
					System.out.println("boolean: " + false);
					treeItemAlunoRoot.getChildren().add(turmaNode);
				}
			}
//			turmaNode.setExpanded(true);
			turmaNode.setExpanded(true);
			treeItemAlunoRoot.setExpanded(true);
		}
		
		for (Turma turma : turmaList ) {
			turma.getNome();
			
//			TreeItem<Aluno> turmaNode = new TreeItem<>(new Aluno(null,aluno.getNome(),aluno.getTurma()));
//			treeItemAlunoRoot.getChildren().add(turmaNode);
			
			
		}
		
		treeTableViewAluno.setShowRoot(false);
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
