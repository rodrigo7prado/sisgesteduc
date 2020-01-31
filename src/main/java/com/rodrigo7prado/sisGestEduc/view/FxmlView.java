package com.rodrigo7prado.sisGestEduc.view;

import java.util.ResourceBundle;

public enum FxmlView {
	INICIAL {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("inicial.title");
        }

        @Override
		public String getFxmlFile() {
            return "/com/rodrigo7prado/sisGestEduc/gui/MainController.fxml";
        }
    }, 
    TURMAS {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("turmas.title");
        }

        @Override
		public String getFxmlFile() {
            return "/com/rodrigo7prado/sisGestEduc/gui/RelCertificacoesPorTurma.fxml";
        }
    };
    
    public abstract String getTitle();
    public abstract String getFxmlFile();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }
}
