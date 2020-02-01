package com.rodrigo7prado.sisGestEduc.config;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Objects;

import org.slf4j.Logger;

import com.rodrigo7prado.sisGestEduc.view.FxmlView;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

	public static Scene getMainScene() {
		return mainScene;
	}
	
	public void switchScene(final FxmlView view) {
		System.out.println("Chamada Switch!");
		System.out.println("2stageManager: " + this);
        Parent viewRootNodeHierarchy = loadViewNodeHierarchy(view.getFxmlFile());
        
//        System.out.println("333getFxmlFile(): " + view.getFxmlFile());
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
        System.out.println("EXIT???");
        Platform.exit();
    }
}
