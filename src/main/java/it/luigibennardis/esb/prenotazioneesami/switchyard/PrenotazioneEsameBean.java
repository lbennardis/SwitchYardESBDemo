package it.luigibennardis.esb.prenotazioneesami.switchyard;

import it.luigibennardis.prenotazioneesami.dao.DAOEsame;
import it.luigibennardis.prenotazioneesami.dto.DTODatiPrenotazione;
import it.luigibennardis.prenotazioneesami.dto.DTOEsame;
import it.luigibennardis.prenotazioneesami.dto.DTOInformazioniEsame;

import org.switchyard.component.bean.Service;

@Service(IPrenotazioneEsame.class)
public class PrenotazioneEsameBean implements IPrenotazioneEsame {

	@Override
	public DTODatiPrenotazione prenotaEsami(DTOInformazioniEsame infoEsame) {
		String codicePrenotazione = null;
		DTODatiPrenotazione localDatiPrenotazione = null;
		
		// VERIFICA CHE LO STUDENTE SIA IN REGOLA CON IL PAGAMENTO DELLE TASSE 
		//infoEsame.getStudente();
		//infoEsame.getCodiceEsame();
		
		// VERIFICA CHE LO STUDENTE RISPETTI LA PROPEDUTICITA' 
		//infoEsame.getStudente();
		//infoEsame.getCodiceEsame();
		
		// VERIFICA LA DISPONIBILITA' DI POSTI PER L'APPELLO 
		// infoEsame.getCodiceEsame();
		
		// GENERA IL CODICE PRENOTAZIONE [CODICEFACOLTA-CODICEESAME-CODAPPELLO]
		// 
		
		codicePrenotazione = "001111";
		System.out.println("codicePrenotazione " + codicePrenotazione);
				
		
		 
		localDatiPrenotazione = new DTODatiPrenotazione(codicePrenotazione, 
				infoEsame.getStudente(), 
				infoEsame.getEsame());
		
		if(localDatiPrenotazione != null){
			System.out.println("localDatiPrenotazione.  NON é NULL "); }
			
		 
		return localDatiPrenotazione ;
	}

	@Override
	public DTOEsame[] listaEsami(String matricolaStudente) {
		try {
			
			System.out.println("matricolaStudente " + matricolaStudente);
			
			DTOEsame[] esamiDisponibili = null;
			String codiceAppello = this.codiceProssimoAppello();
			
			esamiDisponibili = new DAOEsame().listaEsamiDisponibili(matricolaStudente,codiceAppello);
			
			
		return esamiDisponibili;
		
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String version() {
		// TODO Auto-generated method stub
		return "v11";
	}

	@Override
	public String codiceProssimoAppello() {
		//***CALCOLA IL CODICE APPELLO PER CUI SI POTRANNO PRENOTARE ESAMI
		//***[CODICEFACOLTA-ANNO-PROGAPPELLO]
		
		return "201501";  
	}

	
	

}
