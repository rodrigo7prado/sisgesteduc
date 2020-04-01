package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.entities.FiltroGrupo;
import com.rodrigo7prado.sisGestEduc.services.FiltroGrupoService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

@Controller
public class FiltroController implements Initializable {
	
	@Autowired
	private FiltroGrupoService service;

	private ObservableList<FiltroGrupo> observableList = FXCollections.observableArrayList();
	
	@FXML
	private ListView<String> listView;
	
	@FXML
	private TreeTableView<FiltroGrupo> treeTableViewFiltro;
	@FXML
	private TreeTableColumn<FiltroGrupo, String> treeTableColumnFiltro;
	@FXML
	private TreeTableColumn<FiltroGrupo, String> treeTableColumnLinhas;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		initializeColumns();
		loadListView();

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initializeColumns() {
		treeTableColumnFiltro.setCellValueFactory(new TreeItemPropertyValueFactory("nomeFiltroGrupo"));
	}

	private void loadListView() {

		observableList.clear();
		observableList.addAll(service.findAll());
		TreeItem<FiltroGrupo> treeItemFiltroRoot = new TreeItem<>(
//				new AlunoPeriodoCurricularDto(null, null, null, null, null, "Turma", null, null, null)
		);
		treeTableViewFiltro.setRoot(treeItemFiltroRoot);

		for (FiltroGrupo itemObsList : observableList) {
			TreeItem<FiltroGrupo> node = new TreeItem<>(new FiltroGrupo(null,itemObsList.getNomeFiltroGrupo()));

			TreeItem<FiltroGrupo> filtroGrupoNode = node;

			TreeItem<FiltroGrupo> filtroItemNode = node;

			Integer size = treeItemFiltroRoot.getChildren().size();

			if (size.equals(0)) {
				treeItemFiltroRoot.getChildren().add(filtroGrupoNode);
			} else {
				String ultimaTurmaAdd = treeItemFiltroRoot.getChildren().get(size - 1).getValue().getNomeFiltroGrupo();

				if (ultimaTurmaAdd.equals(itemObsList.getNomeFiltroGrupo())) {

					treeItemFiltroRoot.getChildren().get(size - 1).getChildren().add(filtroItemNode);

				} else {
					treeItemFiltroRoot.getChildren().add(filtroGrupoNode);
					System.out.println("adicionar a:" + filtroGrupoNode.getValue().getNomeFiltroGrupo());
				}
			}
			filtroGrupoNode.setExpanded(true);
			treeItemFiltroRoot.setExpanded(true);
		}

		treeTableViewFiltro.setShowRoot(false);

//		listView.getItems().add("Todos os Alunos");
//		listView.getItems().add("Últimos períodos curriculares");
//		listView.getItems().add("Concluintes");
//		listView.getItems().add("Todas as Certidões");
//		listView.getItems().add("Todos os Certificados");
//		listView.getItems().add("Todos ok");
//		listView.getItems().add("Quaisquer pendências");
//		listView.getItems().add("Pendência de dados pessoais");
//		listView.getItems().add("Pendência de dados escolares");
//		listView.getItems().add("Pendência de HE fund.");
//		listView.getItems().add("Pendência de HE médio");
//		listView.getItems().add("Diferenças c/ Conexão Educação");
//		listView.getItems().add("Pendências em [Nome completo]");
//		listView.getItems().add("Pendências em [Data de Nascimento]");
//		listView.getItems().add("Pendências em [Sexo]");
//		listView.getItems().add("Pendências em [Nome da mãe]");
//		listView.getItems().add("Pendências em [Nome do pai]");
//		listView.getItems().add("Pendências em [Nacionalidade]");
//		listView.getItems().add("Pendências em [Naturalidade]");
//		listView.getItems().add("Pendências em [Naturalidade UF]");
//		listView.getItems().add("Pendências em [Rg]");
//		listView.getItems().add("Pendências em [Rg Emissor]");
//		listView.getItems().add("Pendências em [Rg Emissor UF]");
	}

}
