package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

@Controller
public class DadosAlunosController implements Initializable {
	@FXML
	private TextField matriculaField;
	@FXML
	private TextField nomeCompletoField;
//	@FXML
//	private TextField dataNascField;
	@FXML
	private TextField nomePaiField;
	@FXML
	private TextField nomeMaeField;
	@FXML
	private TextField rgField;
	
//	private AlunoPeriodoCurricularDto entity;
	
//	private AlunoPeriodoCurricularDto controller;

	public AlunoPeriodoCurricularDto setDadosAlunosController(AlunoPeriodoCurricularDto obj) {
		return obj;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
//		System.out.println("Iniciando DadosAlunosController...");
		matriculaField.setText("AAAA");
	}
	
	public void setController(AlunoPeriodoCurricularDto obj) {
		
		//		this.entity = obj;
	}
	
	public void getData() {
//		matriculaField.setText(arg0);
		nomeCompletoField.setText("BBBBBB");
	}
	
	public void updateFormData(AlunoPeriodoCurricularDto obj) {
//		if (entity == null) {
//			throw new IllegalStateException("Entity was null");
//		}
//		matriculaField.setText(entity.getMatricula());
		matriculaField.setText(obj.getMatricula());
		nomeCompletoField.setText(obj.getNomeCompleto());
//		dataNascField.setText(obj.getRg());		
		nomePaiField.setText(obj.getNomePai());
		nomeMaeField.setText(obj.getNomeMae());
		rgField.setText(obj.getRg());
	}

}
