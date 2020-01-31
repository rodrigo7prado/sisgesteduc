package com.rodrigo7prado.sisGestEduc.config;

import java.io.IOException;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

@Component
public class SpringFXMLLoader {
    private final ResourceBundle resourceBundle;
    private final ApplicationContext context;
    private static Scene mainScene;

    @Autowired
    public SpringFXMLLoader(ApplicationContext context, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        this.context = context;
    }

    public Parent load(String fxmlPath) throws IOException {
    	ScrollPane scrollPane = FXMLLoader
				.load(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/MainView.fxml"));
		mainScene = new Scene(scrollPane);
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(context::getBean); //Spring now FXML Controller Factory
        loader.setResources(resourceBundle);
        loader.setLocation(getClass().getResource(fxmlPath));
        
        VBox newVBox = loader.load();
        
        System.out.println("Antes");
        BorderPane borderPane = (BorderPane) ((ScrollPane) mainScene.getRoot()).getContent();
        System.out.println("Depois");
        
        VBox mainVBox = (VBox) borderPane.getCenter();
        
        
		mainVBox.getChildren();
		mainVBox.getChildren().clear();
		mainVBox.getChildren().addAll(newVBox.getChildren());
        
		return borderPane;
    }
    
    public Parent load2(String fxmlPath) throws IOException {      
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(context::getBean); //Spring now FXML Controller Factory
        loader.setResources(resourceBundle);
        loader.setLocation(getClass().getResource(fxmlPath));
        return loader.load();
    }
}
