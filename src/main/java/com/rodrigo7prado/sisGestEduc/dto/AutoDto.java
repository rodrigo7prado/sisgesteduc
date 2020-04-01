package com.rodrigo7prado.sisGestEduc.dto;

public class AutoDto {

	private String componenteCurricular;
	
	private String serie1;
	private String serie2;
	private String serie3;
	
	public AutoDto() {
	}
	
	public AutoDto(String componenteCurricular, String serie1, String serie2, String serie3) {
		this.componenteCurricular = componenteCurricular;
		this.serie1 = serie1;
		this.serie2 = serie2;
		this.serie3 = serie3;
	}

	public String getPeriodoCurricular() {
		return componenteCurricular;
	}

	public String getComponenteCurricular() {
		return componenteCurricular;
	}

	public void setComponenteCurricular(String componenteCurricular) {
		this.componenteCurricular = componenteCurricular;
	}

	public String getSerie1() {
		return serie1;
	}

	public void setSerie1(String serie1) {
		this.serie1 = serie1;
	}

	public String getSerie2() {
		return serie2;
	}

	public void setSerie2(String serie2) {
		this.serie2 = serie2;
	}

	public String getSerie3() {
		return serie3;
	}

	public void setSerie3(String serie3) {
		this.serie3 = serie3;
	}
}
