package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto;
import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.dto.AutoDto;
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

	@Autowired
	private AlunoComponenteCurricularService service;

	@FXML
	private TableView<AutoDto> tableView;

	private ObservableList<AlunoComponenteCurricularDto> list = FXCollections.observableArrayList();

	private ObservableList<AlunoComponenteCurricularDto> list2 = FXCollections.observableArrayList();

	@FXML
	private Text aluno;
	@FXML
	private TableColumn<AutoDto, String> disciplina;
	@FXML
	private TableColumn<AutoDto, String> serie1;
	@FXML
	private TableColumn<AutoDto, String> serie2;
	@FXML
	private TableColumn<AutoDto, String> serie3;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("ZAYG2");
		aluno.setText("AAAAA");
//		initializeNodes();
//		loadDetails();
	}

	private void initializeNodes() {
		disciplina.setCellValueFactory(new PropertyValueFactory<>("componenteCurricular"));
		serie1.setCellValueFactory(new PropertyValueFactory<>("serie1"));
		serie2.setCellValueFactory(new PropertyValueFactory<>("serie2"));
		serie3.setCellValueFactory(new PropertyValueFactory<>("serie3"));
	}

	private void loadDetails() {
		list.clear();
		list.addAll(service.findFilterConcluintes("201601911023339"));
		list2.clear();
		list2.addAll(service.findFilterConcluintes2("201601911023339"));
//		tableView.getItems().add(new AutoDto(list.get(0).getComponenteCurricular(),list.get(0).getTotalPontos()));
		String serie1TotalPontos;
		String serie2TotalPontos;
		String serie3TotalPontos;
		String cc0;
		cc0 = "";
		serie1TotalPontos = null;
		serie2TotalPontos = null;
		serie3TotalPontos = null;
		for (AlunoComponenteCurricularDto row : list) {

			if (row.getPeriodoCurricular().equals("Série: 1")) {
				serie1TotalPontos = row.getTotalPontos();
			} else if (row.getPeriodoCurricular().equals("Série: 2")) {
				serie2TotalPontos = row.getTotalPontos();
			} else if (row.getPeriodoCurricular().equals("Série: 3")) {
				serie3TotalPontos = row.getTotalPontos();
			}

			if (!cc0.equals(row.getComponenteCurricular())) {
				System.out.println("KERK" + cc0 + " -  " + row.getComponenteCurricular());
				tableView.getItems().add(new AutoDto(row.getComponenteCurricular(), serie1TotalPontos,
						serie2TotalPontos, serie3TotalPontos));
			}
			cc0 = row.getComponenteCurricular();

		}

//		tableView.setItems();
	}

	public void updateFormData(AlunoPeriodoCurricularDto obj) {
		
		initializeNodes();
		
		tableView.getItems().clear();
		
		list.clear();
		list.addAll(service.findFilterConcluintes(obj.getMatricula()));
//		list.addAll(service.findFilterConcluintes("201601911023339"));
		
		String serie1TotalPontos;
		String serie2TotalPontos;
		String serie3TotalPontos;
		String cc0;
		cc0 = "";
		serie1TotalPontos = null;
		serie2TotalPontos = null;
		serie3TotalPontos = null;
		for (AlunoComponenteCurricularDto row : list) {

			if (row.getPeriodoCurricular().equals("Série: 1")) {
				serie1TotalPontos = row.getTotalPontos();
			} else if (row.getPeriodoCurricular().equals("Série: 2")) {
				serie2TotalPontos = row.getTotalPontos();
			} else if (row.getPeriodoCurricular().equals("Série: 3")) {
				serie3TotalPontos = row.getTotalPontos();
			}

			if (!cc0.equals(row.getComponenteCurricular())) {
				System.out.println("KERK" + cc0 + " -  " + row.getComponenteCurricular());
				tableView.getItems().add(new AutoDto(row.getComponenteCurricular(), serie1TotalPontos,
						serie2TotalPontos, serie3TotalPontos));
			}
			cc0 = row.getComponenteCurricular();

		}
	}
}
