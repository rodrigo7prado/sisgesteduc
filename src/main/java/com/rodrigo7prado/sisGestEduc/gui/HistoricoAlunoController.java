package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto;
import com.rodrigo7prado.sisGestEduc.services.AlunoComponenteCurricularService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

@Controller
public class HistoricoAlunoController implements Initializable {
	
	@SuppressWarnings("unused")
	@Autowired
	private AlunoComponenteCurricularService service;
	
	@FXML
	private TableView<AlunoComponenteCurricularDto> tableView;
	
	@SuppressWarnings("unused")
	private ObservableList<AlunoComponenteCurricularDto> list = FXCollections.observableArrayList();
	
	@FXML
	private Text aluno;
	@FXML
	private TableColumn<AlunoComponenteCurricularDto, String> disciplina;
	@FXML
	private TableColumn<AlunoComponenteCurricularDto, String> serie1;
	@FXML
	private TableColumn<AlunoComponenteCurricularDto, String> serie2;
	@FXML
	private TableColumn<AlunoComponenteCurricularDto, String> serie3;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("ZAYG2");
		aluno.setText("AAAAA");
		initializeNodes();
		loadDetails();
	}
	
	private void initializeNodes() {
		disciplina.setCellValueFactory(new PropertyValueFactory<>("componenteCurricular"));
		serie1.setCellValueFactory(new PropertyValueFactory<>("totalPontos"));
	}
	
	private void loadDetails() {
		list.clear();
		list.addAll(service.findFilterConcluintes());
		tableView.setItems(list);
	}
	
	public void update() {
		System.out.println("ZAYG3");
		System.out.println(service.findFilterConcluintes());
		System.out.println("list: " + list);
		aluno.setText("BBBB");
	}
}
