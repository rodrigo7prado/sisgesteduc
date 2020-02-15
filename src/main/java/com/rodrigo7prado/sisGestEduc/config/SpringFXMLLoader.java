package com.rodrigo7prado.sisGestEduc.config;

import java.io.IOException;
import java.util.ArrayList;
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
	private final ResourceBundle resourceBundle;
	private final ApplicationContext context;
	private static Scene mainScene;

	@Autowired
	public SpringFXMLLoader(ApplicationContext context, ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
		this.context = context;
	}

	public Parent load(String fxmlPath) throws IOException {
		
		System.out.println("VAMOS VER AGORA");

		FXMLLoader loaderMain = new FXMLLoader();
		loaderMain.setControllerFactory(context::getBean); // Spring now FXML Controller Factory
		loaderMain.setResources(resourceBundle);
		loaderMain.setLocation(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/MainView.fxml"));
		ScrollPane scrollPane = loaderMain.load();

		mainScene = new Scene(scrollPane);

//    	----------------------------------------------------------------------
		
		BorderPane borderPane = (BorderPane) ((ScrollPane) mainScene.getRoot()).getContent();
		VBox vBox = (VBox) borderPane.getCenter();
		TabPane tabPane = (TabPane) vBox.getChildren().get(0);
		
		ArrayList<String> list = new ArrayList<String>();
        
        list.add("/com/rodrigo7prado/sisGestEduc/gui/RelCertificacoesPorTurma.fxml");
        list.add("/com/rodrigo7prado/sisGestEduc/gui/RelCertificacoesPorAluno.fxml");
        list.add("/com/rodrigo7prado/sisGestEduc/gui/Aluno.fxml");
        
        int i = 0;
        for (String fxml: list) {
        	
        	if(!fxml.equals(null)) {
        		FXMLLoader loader = new FXMLLoader();
    			loader.setControllerFactory(context::getBean); // Spring now FXML Controller Factory
    			loader.setResources(resourceBundle);
    			loader.setLocation(getClass().getResource(fxml));
    			
    			VBox newVBox = loader.load();
    			
            	Tab tab = (Tab) tabPane.getTabs().get(i);    
                VBox vBoxInTab = (VBox) tab.getContent();
                vBoxInTab.getChildren();
                vBoxInTab.getChildren().clear();
                vBoxInTab.getChildren().addAll(newVBox.getChildren());
        	} else {
        		Tab tab = (Tab) tabPane.getTabs().get(i);
            	VBox vBoxInTab = (VBox) tab.getContent();
                vBoxInTab.getChildren();
                vBoxInTab.getChildren().clear();
                vBoxInTab.getChildren().addAll();
        	}
        	
        	i++;
        }

		return borderPane;
	}

	public Parent load2(String fxmlPath) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setControllerFactory(context::getBean); // Spring now FXML Controller Factory
		loader.setResources(resourceBundle);
		loader.setLocation(getClass().getResource(fxmlPath));
		return loader.load();
	}
	
	public Parent load3() throws IOException {
		FXMLLoader loaderMain = new FXMLLoader();
		loaderMain.setControllerFactory(context::getBean); // Spring now FXML Controller Factory
		loaderMain.setResources(resourceBundle);
		loaderMain.setLocation(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/MainView.fxml"));
		ScrollPane scrollPane = loaderMain.load();

		mainScene = new Scene(scrollPane);
		return null;
	}
}