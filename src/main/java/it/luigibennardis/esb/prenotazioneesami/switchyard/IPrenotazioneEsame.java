package it.luigibennardis.esb.prenotazioneesami.switchyard;

import it.luigibennardis.prenotazioneesami.dto.DTODatiPrenotazione;
import it.luigibennardis.prenotazioneesami.dto.DTOEsame;
import it.luigibennardis.prenotazioneesami.dto.DTOInformazioniEsame;
 
public interface IPrenotazioneEsame {
	
	public DTODatiPrenotazione prenotaEsami(DTOInformazioniEsame infoEsame);
	public DTOEsame[] listaEsami(String matricolaStudente);
	public String codiceProssimoAppello(); 
	public String version();
	
		
}
