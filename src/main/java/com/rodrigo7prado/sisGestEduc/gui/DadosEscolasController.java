package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto;
import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.services.AlunoPeriodoCurricularService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Controller
public class DadosEscolasController implements Initializable {

	@Autowired
	private AlunoPeriodoCurricularService service;

	private ObservableList<AlunoPeriodoCurricularDto> observableList = FXCollections.observableArrayList();

	@FXML
	private TableView<AlunoPeriodoCurricularDto> tableView;
	@FXML
	private TableColumn<AlunoPeriodoCurricularDto, String> tableColumnModalidade;
	@FXML
	private TableColumn<AlunoPeriodoCurricularDto, String> tableColumnPeriodoCurricular;
	@FXML
	private TableColumn<AlunoPeriodoCurricularDto, String> tableColumnAno;
	@FXML
	private TableColumn<AlunoPeriodoCurricularDto, String> tableColumnEscola;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		observableList.clear();

//		observableList.addAll(service.findFilterTodos());

	}

	private void initializeNodes() {
//		tableColumnModalidade.setCellValueFactory(new PropertyValueFactory<>("componenteCurricular"));
//		tableColumnPeriodoCurricular.setCellValueFactory(new PropertyValueFactory<>("serie1"));
		tableColumnAno.setCellValueFactory(new PropertyValueFactory<>("anoLetivo"));
		tableColumnEscola.setCellValueFactory(new PropertyValueFactory<>("ensMedioEstabEns"));
	}

	public void updateFormData(AlunoPeriodoCurricularDto obj) {
		System.out.println("Cliquei!");
		

		tableView.getItems().clear();
		
		initializeNodes();

		observableList.clear();
		observableList.addAll(service.findFilterDadosEscolas(obj.getMatricula()));
		tableView.getItems().addAll(observableList);
	}

}
