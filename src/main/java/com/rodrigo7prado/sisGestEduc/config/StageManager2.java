package com.rodrigo7prado.sisGestEduc.config;

import java.io.IOException;
import java.util.function.Consumer;

import com.rodrigo7prado.sisGestEduc.gui.util.Alerts;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StageManager2 {
//	private static final Logger LOG = getLogger(StageManager2.class);
	private static Scene mainScene;
	private final Stage primaryStage;
//	private final SpringFXMLLoader springFXMLLoader;

	public StageManager2(SpringFXMLLoader springFXMLLoader, Stage stage) {
		// TODO Auto-generated constructor stub
		System.out.println("AAAA3");
//		this.springFXMLLoader = springFXMLLoader;
		this.primaryStage = stage;
	}
	
//	private void show(final Parent rootnode, String title) {
//        Scene scene = prepareScene(rootnode);
//        //scene.getStylesheets().add("/styles/Styles.css");
//        
//        //primaryStage.initStyle(StageStyle.TRANSPARENT);
//        primaryStage.setTitle(title);
//        primaryStage.setScene(scene);
//        primaryStage.sizeToScene();
//        primaryStage.centerOnScreen();
//        
//        try {
//            primaryStage.show();
//        } catch (Exception exception) {
//            logAndExit ("Unable to show scene for title" + title,  exception);
//        }
//    }

	public void show3(final Parent rootnode, String title) {
//		System.out.println("BBBB");
//		Scene scene = prepareScene(rootnode);
//		primaryStage.setTitle(title);
//        primaryStage.setScene(scene);
//        primaryStage.sizeToScene();
//        primaryStage.centerOnScreen();
//        
//        try {
//            primaryStage.show();
//        } catch (Exception exception) {
//        	//            logAndExit ("Unable to show scene for title" + title,  exception);
//        }
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

	public void loadView2() {
		System.out.println("FFFF3");
		System.out.println("BBBB");
		System.out.println("DDDD5: " + primaryStage.getTitle());
//        try {
//        	System.out.println("BBBB2");
//			ScrollPane scrollPane = FXMLLoader.load(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/MainView.fxml"));
//			mainScene = new Scene(scrollPane);
//			scrollPane.setFitToHeight(true);
//			scrollPane.setFitToWidth(true);
//			primaryStage.setScene(mainScene);
//			primaryStage.setTitle("Sistema Gerenciador Educ7");
//			primaryStage.show();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		System.out.println("FFFF2");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			System.out.println("AAAA5");
			VBox newVBox = loader.load();
			System.out.println("BBBB5");

			Scene mainScene = StageManager2.getMainScene();
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

	public static Scene getMainScene() {
		return mainScene;
	}
}
