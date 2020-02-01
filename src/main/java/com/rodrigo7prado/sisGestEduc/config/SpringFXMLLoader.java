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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

@Component
public class SpringFXMLLoader {
//    private MainViewController mainViewController;
	private final ResourceBundle resourceBundle;
    private final ApplicationContext context;
    private static Scene mainScene;

    @Autowired
    public SpringFXMLLoader(ApplicationContext context, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        this.context = context;
    }

    public Parent load(String fxmlPath) throws IOException {
    	
    	FXMLLoader loaderMain = new FXMLLoader();
    	loaderMain.setControllerFactory(context::getBean); //Spring now FXML Controller Factory
    	loaderMain.setResources(resourceBundle);
    	loaderMain.setLocation(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/MainView.fxml"));
    	ScrollPane scrollPane = loaderMain.load();
    	
    	mainScene = new Scene(scrollPane);
    	
//    	----------------------------------------------------------------------
    	
//    	ScrollPane scrollPane = FXMLLoader
//				.load(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/MainView.fxml"),resourceBundle);
//    	
//		mainScene = new Scene(scrollPane);
//		scrollPane.setFitToHeight(true);
//		scrollPane.setFitToWidth(true);
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(context::getBean); //Spring now FXML Controller Factory
        loader.setResources(resourceBundle);
        loader.setLocation(getClass().getResource(fxmlPath));
        
        VBox newVBox = loader.load();
        BorderPane borderPane = (BorderPane) ((ScrollPane) mainScene.getRoot()).getContent();
        VBox vBox = (VBox) borderPane.getCenter();
        TabPane tabPane = (TabPane) vBox.getChildren().get(0);
        Tab tab = (Tab) tabPane.getTabs().get(0);
        VBox mainTab = (VBox) tab.getContent();
        
		mainTab.getChildren();
		mainTab.getChildren().clear();
		mainTab.getChildren().addAll(newVBox.getChildren());
		
//		System.out.println(stageManager);
		
		return borderPane;
    }
    
    public Parent load2(String fxmlPath) throws IOException {      
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(context::getBean); //Spring now FXML Controller Factory
//        System.out.println("222resourceBundle: " + resourceBundle.getBaseBundleName());
//        System.out.println("222context: " + context.getBeanDefinitionNames());
        loader.setResources(resourceBundle);
        loader.setLocation(getClass().getResource(fxmlPath));
        return loader.load();
    }
}
