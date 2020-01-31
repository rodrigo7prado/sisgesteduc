package com.rodrigo7prado.sisGestEduc.config;

import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;

import org.slf4j.Logger;

import com.rodrigo7prado.sisGestEduc.gui.util.Alerts;
import com.rodrigo7prado.sisGestEduc.view.FxmlView;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StageManager {
	private static final Logger LOG = getLogger(StageManager.class);
	private static Scene mainScene;
	private final Stage primaryStage;
	private final SpringFXMLLoader springFXMLLoader;

	public StageManager(SpringFXMLLoader springFXMLLoader, Stage stage) {

		this.springFXMLLoader = springFXMLLoader;
		this.primaryStage = stage;
	}
	
	private void show(final Parent rootnode, String title) {
        Scene scene = prepareScene(rootnode);
        
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        
        try {
            primaryStage.show();
        } catch (Exception exception) {
            logAndExit ("Unable to show scene for title" + title,  exception);
        }
    }
	
	public void show2() {
		System.out.println("BBBB");
		try {
			System.out.println("BBBB2");
			ScrollPane scrollPane = FXMLLoader
					.load(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/MainView.fxml"));
			mainScene = new Scene(scrollPane);
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Sistema Gerenciador Educ7");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		System.out.println("FFFF2");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			Scene mainScene = StageManager.getMainScene();
			BorderPane borderPane = (BorderPane) ((ScrollPane) mainScene.getRoot()).getContent();

			VBox mainVBox = (VBox) borderPane.getCenter();
			mainVBox.getChildren();
			mainVBox.getChildren().clear();
			mainVBox.getChildren().addAll(newVBox.getChildren());

			T controller = loader.getController();
			initializingAction.accept(controller);

		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	public synchronized <T> void loadView3(String fullPathView, Consumer<T> initializingAction) {
		System.out.println("FFFF2");
//		switchScene(fullPathView);
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fullPathView));
		try {
			VBox newVBox = loader.load();
			
//			Scene scene = prepareScene(fullPathView);
			Parent root = loadViewNodeHierarchy(fullPathView);
			Scene scene = prepareScene(root);
			
//			Scene scene = primaryStage.getScene();
			
			BorderPane borderPane = (BorderPane) ((ScrollPane) scene.getRoot()).getContent();

			VBox mainVBox = (VBox) borderPane.getCenter();
//			
			
			mainVBox.getChildren();
			mainVBox.getChildren().clear();
			mainVBox.getChildren().addAll(newVBox.getChildren());

			T controller = loader.getController();
			System.out.println("AAAA" + controller.toString());
			initializingAction.accept(controller);	
//			initializingAction.accept(controller);
			
//			System.out.println("PrefWidth: " + newVBox.getPrefWidth());
//			System.out.println("MainScene: " + scene.heightProperty());
//			System.out.println("MainScene: " + mainScene.getRoot().visibleProperty());
//			System.out.println("MainScene: " + mainVBox.prefWidthProperty());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static Scene getMainScene() {
		return mainScene;
	}
	
	public void switchScene(final FxmlView view) {
        Parent viewRootNodeHierarchy = loadViewNodeHierarchy(view.getFxmlFile());
        show(viewRootNodeHierarchy, "Título");
    }
	
	public void switchScene2(final String fullPathView) {
        Parent viewRootNodeHierarchy = loadViewNodeHierarchy(fullPathView);
        show(viewRootNodeHierarchy, "Título");
    }
	
	private Scene prepareScene(Parent rootnode){
		System.out.println("Antes");
        Scene scene = primaryStage.getScene();
        System.out.println("Depois");

        if (scene == null) {
            scene = new Scene(rootnode);
        }
        scene.setRoot(rootnode);
        return scene;
    }
	
	private Parent loadViewNodeHierarchy(String fxmlFilePath) {
		Parent rootNode = null;
		try {
			rootNode = springFXMLLoader.load(fxmlFilePath);
			Objects.requireNonNull(rootNode, "A Root FXML node must not be null");
		} catch (Exception exception) {
            logAndExit("Unable to load FXML view" + fxmlFilePath, exception);
		}
		return rootNode;
	}
	
	private void logAndExit(String errorMsg, Exception exception) {
        LOG.error(errorMsg, exception, exception.getCause());
        Platform.exit();
    }
}
