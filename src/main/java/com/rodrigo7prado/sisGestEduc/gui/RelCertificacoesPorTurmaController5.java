package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.config.StageManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

@Controller
public class RelCertificacoesPorTurmaController5 implements Initializable {

	@Lazy
	@Autowired
	private StageManager stageManager;

//	@Autowired
//	private DadosConsolidadosService dadosConsolidadosService;

	@FXML
	public void onBtnAction() {
		System.out.println("3stageManager: " + stageManager);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
//		System.out.println("dadosConsolidadosService: " + this.dadosConsolidadosService);
//		System.out.println("turmaService: " + this.turmaService);
		
//		initializeNodes();
//		loadTurmaDetails();

//		System.out.println("PARAR QUANDO?!");
//		System.out.println("111: " + dadosConsolidadosService.findById(1L));
//		System.out.println("1stageManager: " + stageManager);

//		checkBoxDP.applyCss();

	}

	@SuppressWarnings("unused")
	private void initializeNodes() {
//		tableColumnTurma.setCellValueFactory(new PropertyValueFactory<>("nome"));
	}

	public void updateTableView() throws InterruptedException {
//		turmaList.clear();
//		turmaList.addAll(turmaService.findAll());
//		tableViewTurma.setItems(turmaList);
//		initVisualizarButtons();
	}

	@SuppressWarnings("unused")
	private void loadTurmaDetails() {
//		turmaList.clear();
//		turmaList.addAll(turmaService.findAll());
//		tableViewTurma.setItems(turmaList);
	}



	@SuppressWarnings("unused")
	private void initVisualizarButtons() {
//		tableColumnVISUALIZAR.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
//		tableColumnVISUALIZAR.setCellFactory(param -> new TableCell<Turma, Turma>() {
//
//			private final Button button = new Button("Visualizar");
//
//			@Override
//			protected void updateItem(Turma obj, boolean empty) {
//				super.updateItem(obj, empty);
//
//				if (obj == null) {
//					setGraphic(null);
//					return;
//				}
//
//				setGraphic(button);
//			}
//		});
	}
}
