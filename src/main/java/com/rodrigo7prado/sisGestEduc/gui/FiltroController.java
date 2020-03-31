package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

@Controller
public class FiltroController implements Initializable {
	
	@FXML
	private ListView<String> listView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadListView();
		
	}
	
	private void loadListView() {
		listView.getItems().add("Todos os Alunos");
		listView.getItems().add("Últimos períodos curriculares");
		listView.getItems().add("Concluintes");
		listView.getItems().add("Todas as Certidões");
		listView.getItems().add("Todos os Certificados");
		listView.getItems().add("Todos ok");
		listView.getItems().add("Quaisquer pendências");
		listView.getItems().add("Pendência de dados pessoais");
		listView.getItems().add("Pendência de dados escolares");
		listView.getItems().add("Pendência de HE fund.");
		listView.getItems().add("Pendência de HE médio");
		listView.getItems().add("Diferenças c/ Conexão Educação");
		listView.getItems().add("Pendências em [Nome completo]");
		listView.getItems().add("Pendências em [Data de Nascimento]");
		listView.getItems().add("Pendências em [Sexo]");
		listView.getItems().add("Pendências em [Nome da mãe]");
		listView.getItems().add("Pendências em [Nome do pai]");
		listView.getItems().add("Pendências em [Nacionalidade]");
		listView.getItems().add("Pendências em [Naturalidade]");
		listView.getItems().add("Pendências em [Naturalidade UF]");
		listView.getItems().add("Pendências em [Rg]");
		listView.getItems().add("Pendências em [Rg Emissor]");
		listView.getItems().add("Pendências em [Rg Emissor UF]");
	}

}
