package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.dto.FiltroItemDto;
import com.rodrigo7prado.sisGestEduc.services.AlunoPeriodoCurricularService;
import com.rodrigo7prado.sisGestEduc.services.FiltroItemService;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
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
	@FXML
	private TreeTableColumn<FiltroItemDto, FiltroItemDto> treeTableColumnActions;

	private Map<Integer, Integer> mapCarregamentos = new HashMap<Integer, Integer>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		this.mapCarregamentos.put(1, serviceExternal.findFilterTodosCount());
		this.mapCarregamentos.put(2, serviceExternal.findFilterUltimosPeriodosLetivosCount());
		this.mapCarregamentos.put(3, serviceExternal.findFilterConcluintesCount());
		this.mapCarregamentos.put(4, serviceExternal.findFilterConcluintesSemEmissaoCount());
		this.mapCarregamentos.put(5, serviceExternal.findFilterConcluintesComConcertidaoECertificadoCount());
		this.mapCarregamentos.put(6, serviceExternal.findFilterTodasOsCertidoesCount());
		this.mapCarregamentos.put(7, serviceExternal.findFilterConcuintesComCertidaoSemCertificadoCount());
		this.mapCarregamentos.put(8, serviceExternal.findFilterTodasOsCertificadosCount());
		this.mapCarregamentos.put(12, serviceExternal.findFilterTodosOkCount());
		this.mapCarregamentos.put(14, serviceExternal.findFilterPendDadosPessoaisCount());
		this.mapCarregamentos.put(17, serviceExternal.findFilterPendDataNascCount());
		this.mapCarregamentos.put(18, serviceExternal.findFilterPendNacionalidadeCount());
		this.mapCarregamentos.put(19, serviceExternal.findFilterPendNaturalidadeCount());
		this.mapCarregamentos.put(21, serviceExternal.findFilterPendRgCount());
		this.mapCarregamentos.put(24, serviceExternal.findFilterPendNomePaiCount());
		this.mapCarregamentos.put(25, serviceExternal.findFilterPendNomeMaeCount());
		
		
//		this.mapCarregamentos.put(1, serviceExternal.findFilterTodos().size());
//		this.mapCarregamentos.put(2, serviceExternal.findFilterUltimosPeriodosLetivos().size());
//		this.mapCarregamentos.put(3, serviceExternal.findFilterConcluintes().size());
//		this.mapCarregamentos.put(4, serviceExternal.findFilterConcluintesSemEmissao().size());
//		this.mapCarregamentos.put(5, serviceExternal.findFilterConcluintesComConcertidaoECertificado().size());
//		this.mapCarregamentos.put(6, serviceExternal.findFilterTodasOsCertidoes().size());
//		this.mapCarregamentos.put(7, serviceExternal.findFilterConcuintesComCertidaoSemCertificado().size());
//		this.mapCarregamentos.put(8, serviceExternal.findFilterTodasOsCertificados().size());
//		this.mapCarregamentos.put(12, serviceExternal.findFilterTodosOk().size());
//		this.mapCarregamentos.put(14, serviceExternal.findFilterPendDadosPessoais().size());
//		this.mapCarregamentos.put(17, serviceExternal.findFilterPendDataNasc().size());
//		this.mapCarregamentos.put(18, serviceExternal.findFilterPendNacionalidade().size());
//		this.mapCarregamentos.put(19, serviceExternal.findFilterPendNaturalidade().size());
//		this.mapCarregamentos.put(21, serviceExternal.findFilterPendRg().size());
//		this.mapCarregamentos.put(24, serviceExternal.findFilterPendNomePai().size());
//		this.mapCarregamentos.put(25, serviceExternal.findFilterPendNomeMae().size());

		initializeColumns();
		loadListView();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initializeColumns() {
		treeTableColumnFiltro.setCellValueFactory(new TreeItemPropertyValueFactory("filtroItemNome"));
		treeTableColumnLinhas.setCellValueFactory(new TreeItemPropertyValueFactory("linhas"));
		initButtonCertificadosAction();
	}

	private void loadListView() {

		observableList.clear();
		observableList.addAll(service.findAllDto());
		TreeItem<FiltroItemDto> treeItemFiltroRoot = new TreeItem<>(
//				new AlunoPeriodoCurricularDto(null, null, null, null, null, "Turma", null, null, null)
		);
		treeTableViewFiltro.setRoot(treeItemFiltroRoot);

		for (FiltroItemDto itemObsList : observableList) {

			TreeItem<FiltroItemDto> node = new TreeItem<>(
					new FiltroItemDto(itemObsList.getId(), itemObsList.getFiltroGrupoId(),
							itemObsList.getFiltroItemNome(), mapCarregamentos.get(itemObsList.getId())));

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
	}

	@SuppressWarnings("unchecked")
	@FXML
	public void onMouseClicked(Event event) {

		TreeTableView<FiltroItemDto> source = (TreeTableView<FiltroItemDto>) event.getSource();

		FiltroItemDto obj = (FiltroItemDto) source.getFocusModel().getFocusedItem().getValue();

		System.out.println("Id: " + obj);

		relCertificacoesPorAlunoController.updateTreeTableView(obj.getId());
	}

	private void initButtonCertificadosAction() {
		treeTableColumnActions.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getValue()));
		treeTableColumnActions.setCellFactory(param -> new TreeTableCell<FiltroItemDto, FiltroItemDto>() {
			private Button button;

			@Override
			protected void updateItem(FiltroItemDto obj, boolean empty) {
				super.updateItem(obj, empty);

				if (obj == null) {
					setGraphic(null);
					return;
				}
				
				if ( obj.getId().equals(6) || obj.getId().equals(8) ) {
					button = new Button("c");
					setGraphic(button);
					
					button.setOnAction(event -> System.out.println(""));
				}

			}
		});
	}
}