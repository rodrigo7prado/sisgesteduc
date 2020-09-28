package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularCondensedDto;
import com.rodrigo7prado.sisGestEduc.services.AlunoPeriodoCurricularCondensedService;

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
	private AlunoPeriodoCurricularCondensedService service;

	private ObservableList<AlunoPeriodoCurricularCondensedDto> observableList = FXCollections.observableArrayList();

	@FXML
	private TableView<AlunoPeriodoCurricularCondensedDto> tableView;
	@FXML
	private TableColumn<AlunoPeriodoCurricularCondensedDto, String> tableColumnModalidade;
	@FXML
	private TableColumn<AlunoPeriodoCurricularCondensedDto, String> tableColumnPeriodoCurricular;
	@FXML
	private TableColumn<AlunoPeriodoCurricularCondensedDto, String> tableColumnAno;
	@FXML
	private TableColumn<AlunoPeriodoCurricularCondensedDto, String> tableColumnEscola;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		observableList.clear();

		observableList.addAll(service.findFilterTodos());

	}

	private void initializeNodes() {
//		tableColumnModalidade.setCellValueFactory(new PropertyValueFactory<>("componenteCurricular"));
//		
		tableColumnModalidade.setCellValueFactory(new PropertyValueFactory<>("modalidade"));
		tableColumnAno.setCellValueFactory(new PropertyValueFactory<>("anoLetivo"));
		tableColumnPeriodoCurricular.setCellValueFactory(new PropertyValueFactory<>("serie"));
		tableColumnEscola.setCellValueFactory(new PropertyValueFactory<>("ensMedioEstabEns"));
	}

	public void updateFormData(AlunoPeriodoCurricularCondensedDto obj) {
		System.out.println("Cliquei!");

		tableView.getItems().clear();
		
		initializeNodes();

		observableList.clear();
//		Ainda por ajustar
		observableList.addAll(service.findFilterDadosEscolas(obj.getMatricula()));
		tableView.getItems().addAll(observableList);
	}

}
