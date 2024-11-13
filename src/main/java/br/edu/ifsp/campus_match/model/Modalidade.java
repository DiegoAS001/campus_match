package br.edu.ifsp.campus_match.model;

public enum Modalidade {

	PRESENCIAL("Presencial"),
	ENSINO_A_DISTANCIA("Ensino a Distância"),
	MISTO("Misto");

	private String modalidade;
	
	Modalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	
}
