package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularCondensedDto;
import com.rodrigo7prado.sisGestEduc.entities.external.VwAlunoPeriodoCurricularPopulated;
import com.rodrigo7prado.sisGestEduc.services.AlunoPeriodoCurricularPopulatedService;

import javafx.beans.property.SimpleStringProperty;
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
	private AlunoPeriodoCurricularPopulatedService service;

	private ObservableList<VwAlunoPeriodoCurricularPopulated> observableList = FXCollections.observableArrayList();

	@FXML
	private TableView<VwAlunoPeriodoCurricularPopulated> tableView;
	@FXML
	private TableColumn<VwAlunoPeriodoCurricularPopulated, String> tableColumnModalidade;
	@FXML
	private TableColumn<VwAlunoPeriodoCurricularPopulated, String> tableColumnPeriodoCurricular;
	@FXML
	private TableColumn<VwAlunoPeriodoCurricularPopulated, String> tableColumnAno;
	@FXML
	private TableColumn<VwAlunoPeriodoCurricularPopulated, String> tableColumnEscola;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

//		observableList.clear();

//		observableList.addAll(service.findFilterAluno());

	}

	private void initializeNodes() {
//		tableColumnModalidade.setCellValueFactory(new PropertyValueFactory<>("componenteCurricular"));
		tableColumnModalidade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().getModalidade()));
		tableColumnPeriodoCurricular.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().getPeriodoCurricular()));
		tableColumnAno.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().getAno()));
		
//		tableColumnAno.setCellValueFactory(new PropertyValueFactory<>("anoLetivo"));
//		tableColumnPeriodoCurricular.setCellValueFactory(new PropertyValueFactory<>("periodoCurricular"));
		tableColumnEscola.setCellValueFactory(new PropertyValueFactory<>("ensMedioEstabEns"));
	}

	public void updateFormData(AlunoPeriodoCurricularCondensedDto obj) {
//		System.out.println("Cliquei!");
//
//		tableView.getItems().clear();
//		
//		initializeNodes();
//
//		observableList.clear();
//		observableList.addAll(service.findFilterAluno(obj.getMatricula()));
//		tableView.getItems().addAll(observableList);
		
		initializeNodes();
		
		tableView.getItems().clear();
		
		
		
		observableList.clear();
		observableList.addAll(service.findFilterAluno(obj.getMatricula()));
//		tableView.getItems().addAll(observableList);
		
		
		tableView.getItems().addAll(observableList);
//		tableView.refresh();
	}

}
