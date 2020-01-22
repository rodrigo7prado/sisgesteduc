package com.rodrigo7prado.sisGestEduc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.JavaFxApplication;
import com.rodrigo7prado.sisGestEduc.entities.PeriodoLetivo;
import com.rodrigo7prado.sisGestEduc.gui.util.Alerts;
import com.rodrigo7prado.sisGestEduc.services.AlunoService;
import com.rodrigo7prado.sisGestEduc.services.TurmaService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;

@Controller
@Component
@FxmlView("MainView.fxml")
public class MainViewController implements Initializable {

	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}

	@FXML
	private Label lbLogo;

	@FXML
	private ComboBox<PeriodoLetivo> comboBoxPeriodoLetivo;

	@FXML
	private Button btShowIniSetup;

	@FXML
	private Button btSelPeriodoLetivo;

	@FXML
	public void showMainControllerAction() {
		this.loadView("/com/rodrigo7prado/sisGestEduc/gui/RelCertificacoesPorTurma.fxml", x -> {
		});
	}

	@FXML
	public void showSetupIniFilesAction() {
		this.loadView("/com/rodrigo7prado/sisGestEduc/gui/SetupIniFiles.fxml", x -> {
		});
	}

	@FXML
	public void updateViewPeriodoLetivo() {
		this.loadView("/com/rodrigo7prado/sisGestEduc/gui/MainController.fxml", x -> {
		});
	}
	
//	@RequestMapping(value = "/turmas")
	@FXML
	public void onLogoAction() {
		loadView("/com/rodrigo7prado/sisGestEduc/gui//RelCertificacoesPorTurma.fxml", (RelCertificacoesPorTurmaController controller) -> {
			controller.setTurmaService(new TurmaService());
			controller.setAlunoService(new AlunoService());
			try {
				controller.updateTableView();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			System.out.println("AAAA");
			VBox newVBox = loader.load();
			System.out.println("BBBB");

			Scene mainScene = JavaFxApplication.getMainScene();
			BorderPane borderPane = (BorderPane) ((ScrollPane) mainScene.getRoot()).getContent();

			VBox mainVBox = (VBox) borderPane.getCenter();
			mainVBox.getChildren();
			mainVBox.getChildren().clear();
			mainVBox.getChildren().addAll(newVBox.getChildren());

			T controller = loader.getController();
			initializingAction.accept(controller);
			
		} catch (IOException e) {
//			System.out.println("Deu erro");
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
}
