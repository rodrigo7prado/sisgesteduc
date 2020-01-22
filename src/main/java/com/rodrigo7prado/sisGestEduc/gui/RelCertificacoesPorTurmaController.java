package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.entities.Turma;
import com.rodrigo7prado.sisGestEduc.services.AlunoService;
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
import net.rgielen.fxweaver.core.FxmlView;

@Controller
@Component
@FxmlView("RelCertificacoesPorTurmaController.fxml")
public class RelCertificacoesPorTurmaController implements Initializable {
	
	private TurmaService service;
	
	private AlunoService alunoService;
	
	@Autowired
	public void setTurmaService(TurmaService service) {
		this.service = service;
	}
	
	@Autowired
	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
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
	
	private ObservableList<Turma> obsList;
	
	@FXML
	private TreeTableView<Aluno> treeTableViewAluno;
	
	@FXML
	private TreeTableColumn<Aluno, String> treeTableColumnTurma;
	
	@FXML
	private TreeTableColumn<Aluno, String> treeTableColumnAluno;
	
//	private ObservableList<Aluno> obsListAluno;
	
	@FXML
	private Label lbl;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initializeNodes() {	
		tableColumnTurma.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
//		treeTableColumnAlunoTurma.setCellValueFactory(new TreeItemPropertyValueFactory("nome"));
		treeTableColumnAluno.setCellValueFactory(new TreeItemPropertyValueFactory("nome"));
		treeTableColumnTurma.setCellValueFactory(new TreeItemPropertyValueFactory("turma"));
		
	}
	
//	@SuppressWarnings("unlikely-arg-type")
	public void updateTableView() throws InterruptedException {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		if (alunoService == null) {
			throw new IllegalStateException("Service was null");
		}
		
//		List<Turma> list = service.findBy();
		List<Turma> list = service.findAll();
		
		System.out.println("CCCC");
		obsList = FXCollections.observableArrayList(list);
		System.out.println("DDDD");
		tableViewTurma.setItems(obsList);
		initVisualizarButtons();
		
		List<Aluno> listAluno = alunoService.findBy();
//		List<Aluno> listAluno = alunoService.findAll();
		
		TreeItem<Aluno> treeItemAlunoRoot = new TreeItem<>(new Aluno("AlunoRoot","3001"));
		
		treeTableViewAluno.setRoot(treeItemAlunoRoot);
		
		for (Aluno aluno : listAluno) {
			TreeItem<Aluno> turmaNode = new TreeItem<>(new Aluno(null,aluno.getTurma()));
			
//			System.out.println(turmaNode.getValue().equals(aluno.getTurma()));
			System.out.println(turmaNode.getValue().getTurma() + " - " + aluno.getTurma());
//			System.out.println(turmaNode.getValue().contentEquals(aluno.getTurma()));
			
//			if () {
//				
//			}
			treeItemAlunoRoot.getChildren().add(turmaNode);
			
			/*
			TreeItem<Aluno> alunoLeaf = new TreeItem<>(new Aluno(aluno.getNome(),aluno.getTurma()));
//            boolean found = false;
            for (TreeItem<Aluno> turmaNode : treeItemAlunoRoot.getChildren()) {
                if (turmaNode.getValue().equals(aluno.getTurma())){
                    turmaNode.getChildren().add(alunoLeaf);
//                    found = true;
                    break;
                }
            }
//            if (!found) {
//                TreeItem<Aluno> turmaNode = new TreeItem<>(new Aluno(aluno.getNome(),aluno.getTurma()));
//                treeItemAlunoRoot.getChildren().add(turmaNode);
//                turmaNode.getChildren().add(alunoLeaf);
//            }
 */
			
			
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
