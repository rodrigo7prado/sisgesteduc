package com.rodrigo7prado.sisGestEduc;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
 
public class Test4 extends Application {
 
    Stage window;
    Scene scene;
    Button button;
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Jasper Report Tutorial");
        button = new Button("Show Receipt");
        button.setOnAction(e -> {
            try {
                // --- Show Jasper Report on click-----
                new PrintReport().showReport();
            } catch (ClassNotFoundException | JRException | SQLException e1) {
                e1.printStackTrace();
            }
        });
 
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(button);
        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
 
}