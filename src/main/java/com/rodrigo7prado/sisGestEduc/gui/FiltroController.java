package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.dto.FiltroItemDto;
import com.rodrigo7prado.sisGestEduc.services.AlunoPeriodoCurricularService;
import com.rodrigo7prado.sisGestEduc.services.FiltroItemService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
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
	private FiltroItemService service;
	
	@Autowired
	private AlunoPeriodoCurricularService serviceExternal;
	
	@FXML
	@Autowired
	private RelCertificacoesPorAlunoController relCertificacoesPorAlunoController;

	private ObservableList<FiltroItemDto> observableList = FXCollections.observableArrayList();

	@FXML
	private ListView<String> listView;

	@FXML
	private TreeTableView<FiltroItemDto> treeTableViewFiltro;
	@FXML
	private TreeTableColumn<FiltroItemDto, String> treeTableColumnFiltro;
	@FXML
	private TreeTableColumn<FiltroItemDto, Integer> treeTableColumnLinhas;
	
	private Map<Integer,Integer> mapCarregamentos = new HashMap<Integer,Integer>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		this.mapCarregamentos.put(1, serviceExternal.findFilterTodos().size());
		this.mapCarregamentos.put(2, serviceExternal.findFilterUltimosPeriodosLetivos().size());
		this.mapCarregamentos.put(3, serviceExternal.findFilterConcluintes().size());
		this.mapCarregamentos.put(8, serviceExternal.findFilterPendDadosPessoais().size());
		this.mapCarregamentos.put(11, serviceExternal.findFilterPendDataNasc().size());
		this.mapCarregamentos.put(12, serviceExternal.findFilterPendNacionalidade().size());
		this.mapCarregamentos.put(13, serviceExternal.findFilterPendNaturalidade().size());
		this.mapCarregamentos.put(15, serviceExternal.findFilterPendRg().size());
		this.mapCarregamentos.put(19, serviceExternal.findFilterPendNomePai().size());
		this.mapCarregamentos.put(20, serviceExternal.findFilterPendNomeMae().size());
		
		initializeColumns();
		loadListView();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initializeColumns() {
		treeTableColumnFiltro.setCellValueFactory(new TreeItemPropertyValueFactory("filtroItemNome"));
		treeTableColumnLinhas.setCellValueFactory(new TreeItemPropertyValueFactory("linhas"));
	}

	private void loadListView() {

		observableList.clear();
		observableList.addAll(service.findAllDto());
		TreeItem<FiltroItemDto> treeItemFiltroRoot = new TreeItem<>(
//				new AlunoPeriodoCurricularDto(null, null, null, null, null, "Turma", null, null, null)
		);
		treeTableViewFiltro.setRoot(treeItemFiltroRoot);

		for (FiltroItemDto itemObsList : observableList) {
			
			
			
			TreeItem<FiltroItemDto> node = new TreeItem<>(new FiltroItemDto(itemObsList.getId(),
					itemObsList.getFiltroGrupoId(), itemObsList.getFiltroItemNome(),mapCarregamentos.get(itemObsList.getId())));

			TreeItem<FiltroItemDto> filtroGrupoNode = node;

			TreeItem<FiltroItemDto> filtroItemNode = node;

			Integer size = treeItemFiltroRoot.getChildren().size();

			if (size.equals(0)) {
				treeItemFiltroRoot.getChildren().add(filtroGrupoNode);
			} else {
//				String ultimaTurmaAdd = treeItemFiltroRoot.getChildren().get(size - 1).getValue().getFiltroItemNome();

				Long ultimoIdGrupo = treeItemFiltroRoot.getChildren().get(size - 1).getValue().getFiltroGrupoId();

				if (ultimoIdGrupo.equals(itemObsList.getFiltroGrupoId())) {

					treeItemFiltroRoot.getChildren().get(size - 1).getChildren().add(filtroItemNode);

				} else {
					treeItemFiltroRoot.getChildren().add(filtroGrupoNode);
					System.out.println("adicionar a:" + filtroGrupoNode.getValue().getFiltroItemNome());
				}
			}
			filtroGrupoNode.setExpanded(false);
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

	@SuppressWarnings("unchecked")
	@FXML
	public void onMouseClicked(Event event) {
		
		
		TreeTableView<FiltroItemDto> source = (TreeTableView<FiltroItemDto>) event.getSource();
		
		FiltroItemDto obj = (FiltroItemDto) source.getFocusModel().getFocusedItem().getValue();
		
		System.out.println("Id: " + obj);
		
		switch (obj.getId()) {
		case 1:
			System.out.println("Ok, id 1");
			relCertificacoesPorAlunoController.updateTreeTableView(1);
			break;
		case 2:
//			relCertificacoesPorAlunoController.updateProgressBar1();
			relCertificacoesPorAlunoController.updateTreeTableView(2);
			break;
		case 3:
			relCertificacoesPorAlunoController.updateTreeTableView(3);
			break;
		case 8:
			relCertificacoesPorAlunoController.updateTreeTableView(8);
			break;
		case 11:
			relCertificacoesPorAlunoController.updateTreeTableView(11);
			break;
		case 12:
			relCertificacoesPorAlunoController.updateTreeTableView(12);
			break;
		case 13:
			relCertificacoesPorAlunoController.updateTreeTableView(13);
			break;
		case 15:
			relCertificacoesPorAlunoController.updateTreeTableView(15);
			break;
		case 19:
			relCertificacoesPorAlunoController.updateTreeTableView(19);
			break;
		case 20:
			relCertificacoesPorAlunoController.updateTreeTableView(20);
			break;
		default:
			relCertificacoesPorAlunoController.updateTreeTableView(0);
			break;
		}
	}
}
