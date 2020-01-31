package com.rodrigo7prado.sisGestEduc.config;

import java.io.IOException;
import java.util.function.Consumer;

import com.rodrigo7prado.sisGestEduc.gui.util.Alerts;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Switcher {
	public void loadView2(final String str) {
		System.out.println("FFFF3");
	}
	
	public synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		System.out.println("FFFF2");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			System.out.println("AAAA5");
			VBox newVBox = loader.load();
			System.out.println("BBBB5");

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
}
