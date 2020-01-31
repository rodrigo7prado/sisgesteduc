package com.rodrigo7prado.sisGestEduc;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.rodrigo7prado.sisGestEduc.config.StageManager;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

//    private ConfigurableApplicationContext applicationContext;
    protected ConfigurableApplicationContext springContext;
    protected StageManager stageManager;
    private static Scene mainScene;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.springContext = new SpringApplicationBuilder()
        		.sources(Main.class)
                .run(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("AAAA");
		stageManager = springContext.getBean(StageManager.class, stage);
		System.out.println("BBBB");
//		stageManager.show(primaryStage, mainScene);
	}
	
	@Override
	public void stop() {
		this.springContext.close();
		Platform.exit();
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}

}