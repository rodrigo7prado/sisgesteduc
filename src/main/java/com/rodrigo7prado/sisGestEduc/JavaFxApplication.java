package com.rodrigo7prado.sisGestEduc;

import java.io.IOException;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

    private ConfigurableApplicationContext applicationContext;
    private static Scene mainScene;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
        		.sources(Main.class)
                .run(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			ScrollPane scrollPane = FXMLLoader.load(getClass().getResource("/com/rodrigo7prado/sisGestEduc/gui/MainView.fxml"));
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
	
	public static Scene getMainScene() {
		return mainScene;
	}
	
	@Override
	public void stop() {
	    this.applicationContext.close();
	    Platform.exit();
	}

}