package it.luigibennardis.prenotazioneesami.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DTODatiPrenotazione     {
	/**
	 * 
	 */
	private String codicePrenotazione = null;
	private DTOEsame esame = null;
	private DTOStudente  studente = null;
	
	public DTOEsame getEsame() {
		return esame;
	}

	public void setEsame(DTOEsame esame) {
		this.esame = esame;
	}

	public DTOStudente getStudente() {
		return studente;
	}

	public void setStudente(DTOStudente studente) {
		this.studente = studente;
	}	
	 
	public String getCodicePrenotazione() {
		return codicePrenotazione;
	}

	public void setCodicePrenotazione(String codicePrenotazione) {
		this.codicePrenotazione = codicePrenotazione;
	}
	 
	DTODatiPrenotazione(){}
	
	
	public DTODatiPrenotazione(String codPrenotazione, DTOStudente studente, DTOEsame esame){
		this.setCodicePrenotazione(codPrenotazione);
		this.setStudente(studente);
		this.setEsame(esame);
	}
	
public String toXML(){
		
		String XLMDatiPrenotazione = "<DatiPrenotazione>";
		 
		XLMDatiPrenotazione.concat("<Studente>");
		 
			XLMDatiPrenotazione.concat("<Cognome>");
			XLMDatiPrenotazione.concat(this.getStudente().getCognome());
			XLMDatiPrenotazione.concat("</Cognome>");
			
			XLMDatiPrenotazione.concat("<Nome>");
			XLMDatiPrenotazione.concat(this.getStudente().getNome());
			XLMDatiPrenotazione.concat("</Nome>");
			
			XLMDatiPrenotazione.concat("<Matricola>");
			XLMDatiPrenotazione.concat(this.getStudente().getMatricola());
			XLMDatiPrenotazione.concat("</Matricola>");
		 			
		XLMDatiPrenotazione.concat("</Studente>");
				
		XLMDatiPrenotazione.concat("<Esame>");
		 
			XLMDatiPrenotazione.concat("<Codice>");
			XLMDatiPrenotazione.concat(this.getEsame().getCodice());
			XLMDatiPrenotazione.concat("</Codice>");
			
			XLMDatiPrenotazione.concat("<Descrizione>");
			XLMDatiPrenotazione.concat(this.getEsame().getDescrizione());
			XLMDatiPrenotazione.concat("</Descrizione>");
			
			XLMDatiPrenotazione.concat("<DataAppello>");
			XLMDatiPrenotazione.concat(this.getEsame().getDataAppello().toString());
			XLMDatiPrenotazione.concat("</DataAppello>");
		  
		XLMDatiPrenotazione.concat("<Esame>");
		XLMDatiPrenotazione.concat("</DatiPrenotazione>");
	
	return XLMDatiPrenotazione;

	}

	
}
