package com.rodrigo7prado.sisGestEduc;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
 
@SpringBootApplication
public class Main2 extends Application {
 
    private ConfigurableApplicationContext context;
    private static Scene mainScene;
 
    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main2.class);
        context = builder.run(getParameters().getRaw().toArray(new String[0]));
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
    public void stop() throws Exception {
        context.close();
    }
    
    public static void main(String[] args) {
//		SpringApplication.run(CursoApplication.class, args);
		launch(args);
	}
}