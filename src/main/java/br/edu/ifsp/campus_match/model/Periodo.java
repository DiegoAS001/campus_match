package br.edu.ifsp.campus_match.model;

public enum Periodo {

	MATUTINO("Matutino"),
	VESPERTINO("Vespertino"),
	NOTURNO("Noturno"),
	MATUTINO_VESPERTINO("Matutino - Vespertino"),
	VESPERTINO_NOTURNO("Vespertino - Noturno"),
	ASSINCRONO("Assíncrono");

	private String periodo;
	
	Periodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
}
