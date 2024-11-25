package br.edu.ifsp.campus_match.model;

public enum AreaConhecimento {

	CIENCIAS_EXATAS_E_DA_TERRA("Ciências Exatas e da Terra"),
    CIENCIAS_BIOLOGICAS("Ciências Biológicas"),
    ENGENHARIAS("Engenharias"),
    CIENCIAS_DA_SAUDE("Ciências da Saúde"),
    CIENCIAS_AGRARIAS("Ciências Agrárias"),
    CIENCIAS_SOCIAIS_APLICADAS("Ciências Sociais Aplicadas"),
    CIENCIAS_HUMANAS("Ciências Humanas"),
    LINGUISTICA_LETRAS_E_ARTES("Linguística Letras e Artes");
	
	private String AreaConhecimento;

	AreaConhecimento(String areaConhecimento) {
		this.AreaConhecimento = areaConhecimento;
	}

	public String getAreaConhecimento() {
		return AreaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		AreaConhecimento = areaConhecimento;
	}
}
