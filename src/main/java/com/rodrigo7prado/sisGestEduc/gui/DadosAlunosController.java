package com.rodrigo7prado.sisGestEduc.gui;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.stereotype.Controller;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

@Controller
public class DadosAlunosController implements Initializable {
	@FXML
	private TextField matriculaField;
	@FXML
	private TextField nomeCompletoField;
	@FXML
	private ComboBox<String> sexoField;
	@FXML
	private DatePicker dataNascField;
	@FXML
	private TextField nomePaiField;
	@FXML
	private TextField nomeMaeField;
	@FXML
	private TextField nacionalidade;
	@FXML
	private TextField naturalidade;
	@FXML
	private ComboBox<String> naturalidadeUfField;
	@FXML
	private TextField rgField;
	@FXML
	private ComboBox<String> rgEmissorField;

//	private AlunoPeriodoCurricularDto entity;

//	private AlunoPeriodoCurricularDto controller;

	public AlunoPeriodoCurricularDto setDadosAlunosController(AlunoPeriodoCurricularDto obj) {
		return obj;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		System.out.println("Iniciando AAAAAA");
		matriculaField.setText("AAAA");
		sexoField.getItems().clear();
		sexoField.getItems().addAll(Arrays.asList("-- Selecione --", "Masculino", "Feminino"));

		naturalidadeUfField.getItems().clear();
		naturalidadeUfField.getItems()
				.addAll(Arrays.asList("-- Selecione --", "RJ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
						"MA", "MT", "MS", "MG", "PA", "PB", "PE", "PI", "PR", "RN", "RS", "RO", "RO", "SC", "SP", "SE",
						"TO"));
		
		
		rgEmissorField.getItems().clear();
		rgEmissorField.getItems().addAll(Arrays.asList("-- Selecione --", "DETRAN", "SSP", "IFP"));
	}

	public void setController(AlunoPeriodoCurricularDto obj) {

		// this.entity = obj;
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
		sexoField.setValue(obj.getSexo());
		dataNascField.setValue(LocalDate.parse("21/12/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//		dataNascField.setText(obj.getRg());		
		nomePaiField.setText(obj.getNomePai());
		nomeMaeField.setText(obj.getNomeMae());
		nacionalidade.setText(obj.getNacionalidade());
		naturalidade.setText(obj.getNaturalidade());
		naturalidadeUfField.setValue(obj.getNaturalidadeUF());
		rgField.setText(obj.getRg());
		rgEmissorField.setValue("DETRAN");

		Map<TextField, String> mapaNomes = new HashMap<TextField, String>();
		mapaNomes.put(matriculaField, obj.getMatricula());
		mapaNomes.put(nomeMaeField, obj.getNomeMae());
		mapaNomes.put(nacionalidade, obj.getNacionalidade());
		mapaNomes.put(naturalidade, obj.getNaturalidade());
		mapaNomes.put(nomePaiField, obj.getNomePai());
		mapaNomes.put(rgField, obj.getRg());

		// Collection<integer> conjNomes = mapaNomes.keySet();

		Set<Entry<TextField, String>> set = mapaNomes.entrySet();
		@SuppressWarnings("rawtypes")
		Iterator it = set.iterator();

		// getKey() - recupera a chave do mapa
		// getValue() - recupera o valor do mapa

		while (it.hasNext()) {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			Entry<TextField, String> entry = (Entry) it.next();
			System.out.println("MAP: " + entry.getKey() + "\t\t" + entry.getValue());

			TextField textField = entry.getKey();

			System.out.println("Iterator" + it);

			if (entry.getValue() == null) {
				System.out.println(entry.getValue() + " é  nulo");
				if (!textField.getStyleClass().contains("blakk")) {
					textField.getStyleClass().add("blakk");
				}

			} else {
				System.out.println(entry.getValue() + " não é  nulo");
				if (textField.getStyleClass().contains("blakk")) {
					textField.getStyleClass().remove("blakk");
				}
			}
		}

//		if (obj.getNomeMae() == null) {
//			if (!nomeMaeField.getStyleClass().contains("blakk")) {
//				nomeMaeField.getStyleClass().add("blakk");
//			}
//			
//		} else {
//			if (nomeMaeField.getStyleClass().contains("blakk")) {
//				nomeMaeField.getStyleClass().remove("blakk");
//			}
//		}
		System.out.println("classes" + nomeMaeField.getStyleClass());
	}

}
