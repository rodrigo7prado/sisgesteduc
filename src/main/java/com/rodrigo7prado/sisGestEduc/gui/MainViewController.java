package com.rodrigo7prado.sisGestEduc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.config.StageManager;
import com.rodrigo7prado.sisGestEduc.entities.PeriodoLetivo;
import com.rodrigo7prado.sisGestEduc.view.FxmlView;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

@Controller
public class MainViewController implements Initializable {

	@FXML
	private Label lbLogo;
	
	@FXML
	private TabPane tabPane;
	
	@FXML
	private Tab tabPendencias;
	
	@FXML
	private Tab tabAlunosACertificar;
	
	@FXML
	private Tab tabMigracaoConexao;
	
	@FXML
	private Tab tabAluno;

	@FXML
	private ComboBox<PeriodoLetivo> comboBoxPeriodoLetivo;

	@FXML
	private Button btShowIniSetup;

	@FXML
	private Button btSelPeriodoLetivo;
	
	@Lazy
	@Autowired
	private StageManager stageManager;

	@FXML
	public void showMainControllerAction(ActionEvent event) throws IOException {
//		stageManager.loadView("/com/rodrigo7prado/sisGestEduc/gui/RelCertificacoesPorTurma.fxml", x -> {
//		});
//		stageManager.switchScene("/com/rodrigo7prado/sisGestEduc/gui/RelCertificacoesPorTurma.fxml");
	}

	@FXML
	public void updateViewPeriodoLetivo() {
//		stageManager.loadView("/com/rodrigo7prado/sisGestEduc/gui/MainController.fxml", x -> {
//		});
	}
	
//	@RequestMapping(value = "/turmas")
	@FXML
	public void onLogoAction(ActionEvent ae) {		
		stageManager.switchScene(FxmlView.TURMAS);
	}
	
	@FXML
	public void showSetupIniFilesAction(ActionEvent event) throws IOException {
		System.out.println("stageManager: " + stageManager);
//		stageManager.switchScene(FxmlView.TURMAS);
	}
	
	@FXML
	public void onTabPendenciasSelectionChange(Event event) {
//		stageManager.switchScene(FxmlView.TURMAS);
//		stageManager.switchScene(FxmlView.TURMAS);
		
		System.out.println("event2: " + event.getEventType());
		System.out.println("event2: " + event.getSource().getClass());
		System.out.println("event2: " + event.getTarget().getClass());
		System.out.println("event2: " + event.isConsumed());
		
		System.out.println("stageManager: " + stageManager);
		System.out.println("Tab Pendências is Selected");
		
//		if (tabPendencias.isSelected()) {
//			
////            stageManager.switchScene(FxmlView.TURMAS);
//        }
	}
	
	@FXML
	public void onTabAlunosACertificarSelectionChange(Event event) {
		if (tabAlunosACertificar.isSelected()) {
			System.out.println("stageManager: " + stageManager);
            System.out.println("Tab is Selected");
//            stageManager.switchScene(FxmlView.ALUNOS);
        }
	}
	
	@FXML
	public void onTabMigracaoConexaoSelectionChange() {
		
	}
	
	@FXML
	public void onTabAlunoSelectionChange() {
		
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		System.out.println("ZZZZZZZZZZZZZZ: " + stageManager);
	}
}
