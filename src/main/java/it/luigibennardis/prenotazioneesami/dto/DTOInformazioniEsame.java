package it.luigibennardis.prenotazioneesami.dto;

public class DTOInformazioniEsame {
	  
	private DTOStudente studente = null;
	private DTOEsame esame = null;
	 
	
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
	
public String toXML(){
		
		String XLMInformazioniEsame = "<InformazioniEsame>";
		 
			XLMInformazioniEsame.concat("<Studente>");
			if (this.getStudente() != null){
				XLMInformazioniEsame.concat("<Cognome>");
				XLMInformazioniEsame.concat(this.getStudente().getCognome());
				XLMInformazioniEsame.concat("</Cognome>");
				
				XLMInformazioniEsame.concat("<Nome>");
				XLMInformazioniEsame.concat(this.getStudente().getNome());
				XLMInformazioniEsame.concat("</Nome>");
				
				XLMInformazioniEsame.concat("<Matricola>");
				XLMInformazioniEsame.concat(this.getStudente().getMatricola());
				XLMInformazioniEsame.concat("</Matricola>");
			}			
			XLMInformazioniEsame.concat("</Studente>");
			
			
			XLMInformazioniEsame.concat("<Esame>");
			if (this.getEsame() != null){
			XLMInformazioniEsame.concat("<Codice>");
			XLMInformazioniEsame.concat(this.getEsame().getCodice());
			XLMInformazioniEsame.concat("</Codice>");
			
			XLMInformazioniEsame.concat("<Descrizione>");
			XLMInformazioniEsame.concat(this.getEsame().getDescrizione());
			XLMInformazioniEsame.concat("</Descrizione>");
			
			XLMInformazioniEsame.concat("<DataAppello>");
			XLMInformazioniEsame.concat(this.getEsame().getDataAppello().toString());
			XLMInformazioniEsame.concat("</DataAppello>");
			}
			XLMInformazioniEsame.concat("</Esame>");
		XLMInformazioniEsame.concat("</InformazioniEsame>");
		return XLMInformazioniEsame;
	}
	 
	
}
