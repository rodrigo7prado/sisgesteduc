package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto;
import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularCondensedDto;
import com.rodrigo7prado.sisGestEduc.dto.AutoDto;
import com.rodrigo7prado.sisGestEduc.services.AlunoComponenteCurricularService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

@Controller
public class HistoricoAlunoController implements Initializable {

	@Autowired
	private AlunoComponenteCurricularService service;

	@FXML
	private TableView<AutoDto> tableView;

	private ObservableList<AlunoComponenteCurricularDto> list = FXCollections.observableArrayList();

	private ObservableList<AlunoComponenteCurricularDto> list2 = FXCollections.observableArrayList();

//	@FXML
//	private Text aluno;
	@FXML
	private TableColumn<AutoDto, String> disciplina;
	@FXML
	private TableColumn<AutoDto, String> serie1;
	@FXML
	private TableColumn<AutoDto, String> serie2;
	@FXML
	private TableColumn<AutoDto, String> serie3;
	
	private AlunoPeriodoCurricularCondensedDto alunoDadosParam;
	
	private AlunoComponenteCurricularDto controller = new AlunoComponenteCurricularDto();
	
	private List<AlunoComponenteCurricularDto> listController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("ZAYG2");
//		aluno.setText("AAAAA");
//		initializeNodes();
//		loadDetails();
	}

	private void initializeNodes() {
		disciplina.setCellValueFactory(new PropertyValueFactory<>("componenteCurricular"));
		serie1.setCellValueFactory(new PropertyValueFactory<>("serie1"));
		serie2.setCellValueFactory(new PropertyValueFactory<>("serie2"));
		serie3.setCellValueFactory(new PropertyValueFactory<>("serie3"));
		
		tableView.setEditable(true);
//		serie1.setCellValueFactory(new PropertyValueFactory<>("serie1"));
		serie1.setCellFactory(TextFieldTableCell.forTableColumn());
		serie2.setCellFactory(TextFieldTableCell.forTableColumn());
		serie3.setCellFactory(TextFieldTableCell.forTableColumn());
		
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
	
	public void onEditCommit(CellEditEvent<?,?> event) {
		
		
//		TablePosition pos = tableView.getSelectionModel().getSelectedCells().get(0);
		
		TablePosition pos = tableView.editingCellProperty().get();
		
//		tableView.getSelectionModel().getSelectedItem().getSerie1();
		
		Integer row = pos.getRow();
		
		// Item here is the table view type:
        AutoDto item = tableView.getItems().get(row);
        
        
		
        TableColumn col = (TableColumn) event.getSource();
        
//        TableColumn col2 = (TableColumn) col.getCellFactory();
//        TableColumn col = pos.getTableColumn();
        
     // this gives the value in the selected cell:
        String data = (String) col.getCellObservableValue(item).getValue();
//        String data = (String) col.get;
//        .getCellObservableValue(item).getValue();
		
//        col.get
        
        
        
		System.out.println("Salvando...:" + event.getNewValue());
		

		System.out.println("listController é: " + listController);
		
		System.out.println("alunoDadosParam é: " + alunoDadosParam);
		
		System.out.println("Controller 0: " + listController.get(0).getCurso());
		
		System.out.println(service.findFilterConcluintes(alunoDadosParam.getMatricula()));
		
//		service.findByIndex(alunoId, cursoId, cursoModalidadeId, periodoCurricularId, disciplinaId)
		
//		listController.get(0)
		
//		service.findByIndex(alunoDadosParam.getMatricula(), cursoId, cursoModalidadeId, periodoCurricularId, disciplinaId)
		
//		controller.get
		
//		System.out.println("Salvando...:" + col2.);

//		System.out.println("Salvando...:" + tableView.getEditingCell().get);
//		service.findByIndex(alunoId, cursoId, cursoModalidadeId, periodoCurricularId, disciplinaId);
	}

	public void updateFormData(AlunoPeriodoCurricularCondensedDto obj) {
		
		
		initializeNodes();
		
		alunoDadosParam = obj;
		
		listController = service.findFilterConcluintes(obj.getMatricula());
		
		System.out.println("listController is: " + listController);
		
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
