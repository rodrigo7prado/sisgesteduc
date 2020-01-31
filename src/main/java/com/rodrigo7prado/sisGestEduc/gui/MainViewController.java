package com.rodrigo7prado.sisGestEduc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.config.StageManager;
import com.rodrigo7prado.sisGestEduc.entities.PeriodoLetivo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

@Controller
public class MainViewController implements Initializable {

	@FXML
	private Label lbLogo;

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
		stageManager.loadView("/com/rodrigo7prado/sisGestEduc/gui/RelCertificacoesPorTurma.fxml", x -> {
		});
//		stageManager.switchScene("/com/rodrigo7prado/sisGestEduc/gui/RelCertificacoesPorTurma.fxml");
	}

	@FXML
	public void showSetupIniFilesAction(ActionEvent event) throws IOException {
		System.out.println("GGGG");
		
//		stageManager.switchScene("/com/rodrigo7prado/sisGestEduc/gui/SetupIniFiles.fxml");
		
		stageManager.loadView3("/com/rodrigo7prado/sisGestEduc/gui/RelCertificacoesPorTurma.fxml", (RelCertificacoesPorTurmaController controller) -> {
			System.out.println("Aqui");
//			TurmaService turmaService = new TurmaService();	
			
//			controller.setTurmaService(new TurmaServiceImpl());
			
			//controller.setAlunoService(new AlunoService());
			try {
				controller.updateTableView();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@FXML
	public void updateViewPeriodoLetivo() {
		stageManager.loadView("/com/rodrigo7prado/sisGestEduc/gui/MainController.fxml", x -> {
		});
	}
	
//	@RequestMapping(value = "/turmas")
	@FXML
	public void onLogoAction() {
		System.out.println("FFFF");
//		stageManager.switchScene("/com/rodrigo7prado/sisGestEduc/gui/RelCertificacoesPorTurma.fxml");
		stageManager.loadView3("/com/rodrigo7prado/sisGestEduc/gui//RelCertificacoesPorTurma.fxml", (RelCertificacoesPorTurmaController controller) -> {
			System.out.println("Aqui");
//			controller.setTurmaService(new TurmaServiceImpl());
//			controller.setAlunoService(new AlunoService());
			try {
				controller.updateTableView();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}
	

	
//	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
//
//		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
//			System.out.println("AAAA5");
//			VBox newVBox = loader.load();
//			System.out.println("BBBB5");
//
//			Scene mainScene = StageManager.getMainScene();
//			BorderPane borderPane = (BorderPane) ((ScrollPane) mainScene.getRoot()).getContent();
//
//			VBox mainVBox = (VBox) borderPane.getCenter();
//			mainVBox.getChildren();
//			mainVBox.getChildren().clear();
//			mainVBox.getChildren().addAll(newVBox.getChildren());
//
//			T controller = loader.getController();
//			initializingAction.accept(controller);
//			
//		} catch (IOException e) {
//			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
//		}
//	}
}
