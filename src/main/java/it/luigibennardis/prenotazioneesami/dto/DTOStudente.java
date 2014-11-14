package it.luigibennardis.prenotazioneesami.dto;

public class DTOStudente {
	private String Nome = null;
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	private String Cognome = null;
	private String matricola = null;
	
	
public String toXML(){
		
		String XLMStudente = "<Esame>";
		XLMStudente.concat("<Studente>");
		
		XLMStudente.concat("<Cognome>");
		XLMStudente.concat(this.getCognome());
		XLMStudente.concat("</Cognome>");
		
		XLMStudente.concat("<Nome>");
		XLMStudente.concat(this.getNome());
		XLMStudente.concat("</Nome>");
		
		XLMStudente.concat("<Matricola>");
		XLMStudente.concat(this.getMatricola());
		XLMStudente.concat("</Matricola>");
					
		XLMStudente.concat("</Studente>");
			 
		return XLMStudente;
	}

	
	
}
