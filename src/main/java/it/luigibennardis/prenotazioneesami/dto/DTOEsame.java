package it.luigibennardis.prenotazioneesami.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DTOEsame {

	private String codice = null;
	private String descrizione = null;
	private Date dataAppello = null;
	
	
	public String getCodice() {
		return codice;
	}
	public Date getDataAppello() {
		return dataAppello;
	}
	public void setDataAppello(Date dataAppello) {
		this.dataAppello = dataAppello;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
			
public String toXML(){
		
		String XLMEsame = "<Esame>";
		 						
			XLMEsame.concat("Esame");
			
			XLMEsame.concat("<Codice>");
			XLMEsame.concat(this.getCodice());
			XLMEsame.concat("</Codice>");
			
			XLMEsame.concat("<Descrizione>");
			XLMEsame.concat(this.getDescrizione());
			XLMEsame.concat("</Descrizione>");
			
			XLMEsame.concat("<DataAppello>");
			XLMEsame.concat(this.getDataAppello().toString());
			XLMEsame.concat("</DataAppello>");
			
			XLMEsame.concat("</Esame>");
		return XLMEsame;
	}
}
