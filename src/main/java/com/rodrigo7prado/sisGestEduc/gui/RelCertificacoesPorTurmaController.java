package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.config.StageManager;
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
import javafx.scene.control.cell.PropertyValueFactory;

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

	private ObservableList<Turma> turmaList = FXCollections.observableArrayList();

//	private ObservableList<Aluno> alunoList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		loadTurmaDetails();

		System.out.println(dadosConsolidadosService.findById(1L));

//		checkBoxDP.applyCss();

	}

	private void initializeNodes() {
		tableColumnTurma.setCellValueFactory(new PropertyValueFactory<>("nome"));
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
