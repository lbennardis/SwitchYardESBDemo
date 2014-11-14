package it.luigibennardis.prenotazioneesami.trasformazioni;

import java.util.Date;
import java.text.SimpleDateFormat;

import it.luigibennardis.prenotazioneesami.dto.DTODatiPrenotazione;
import it.luigibennardis.prenotazioneesami.dto.DTOEsame;
import it.luigibennardis.prenotazioneesami.dto.DTOInformazioniEsame;
import it.luigibennardis.prenotazioneesami.dto.DTOStudente;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Element;

public final class TrasformaSOAP {

//https://docs.jboss.org/author/display/SWITCHYARD/Tutorial AGGIUNGERE UNIT TEST PER LE TRASFORMAZIONI 
		
	/* IN SWITCHYARD.XML LA DEFINIZIONE DELLA TRASFORMAZIONE E' QUESTA
		<transform.java xmlns="urn:switchyard-config:transform:1.0" class="it.luigibennardis.prenotazioneesami.trasformazioni.TrasformaSOAP" 
		from="{urn:it.luigibennardis.esb.prenotazioneesami.switchyard:SWT-servizio-prenotazione-esami:1.0}prenotaEsami" to="java:it.luigibennardis.prenotazioneesami.dto.DTOInformazioniEsame"/>
		
        <transform.java xmlns="urn:switchyard-config:transform:1.0" class="it.luigibennardis.prenotazioneesami.trasformazioni.TrasformaSOAP" 
		from="java:it.luigibennardis.prenotazioneesami.dto.DTODatiPrenotazione" to="{urn:it.luigibennardis.esb.prenotazioneesami.switchyard:SWT-servizio-prenotazione-esami:1.0}prenotaEsamiResponse"/>
	 */
	
	
	//CONVERTE UN OGGETTO JAVA DTODatiPrenotazione IN UN PAYLOAD DI OUTPUT
	@Transformer(to = "{urn:it.luigibennardis.esb.prenotazioneesami.switchyard:SWT-servizio-prenotazione-esami:1.0}prenotaEsamiResponse")
	public Element transformDTODatiPrenotazioneToPrenotaEsamiResponse(
			DTODatiPrenotazione from) {
		try{
		StringBuilder ackXml = new StringBuilder()
		.append("<prenotaEsami xmlns:prenotaEsame=\"urn:it.luigibennardis.esb.prenotazioneesami.switchyard:SWT-servizio-prenotazione-esami:1.0\">")
        .append("<codicePrenotazione>" + from.getCodicePrenotazione() + "</codicePrenotazione>")
        .append("</prenotaEsami>");
		 return Commons.toElement(ackXml.toString());
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	/*.append("<matricolaStudente>" + from.getStudente().getMatricola() + "</matricolaStudente>")
        .append("<codiceEsame>" + from.getEsame().getCodice() + "</codiceEsame>")
        .append("<descrizioneEsame>" + from.getEsame().getDescrizione() + "</descrizioneEsame>")
        .append("<dataAppello>" + from.getEsame().getDataAppello() + "</dataAppello>")
        */
	
	//CONVERTE IL PAYLOAD DI INPUT IN UN OGGETTO JAVA DTOInformazioniEsame
	@Transformer(from = "{urn:it.luigibennardis.esb.prenotazioneesami.switchyard:SWT-servizio-prenotazione-esami:1.0}prenotaEsami")
	public DTOInformazioniEsame transformPrenotaEsamiToDTOInformazioniEsame(
			Element from) {
		// TODO Auto-generated method stub
		DTOInformazioniEsame  infoPrenEsame = new DTOInformazioniEsame();
		DTOStudente  infoStudente = new DTOStudente();
		DTOEsame  infoEsame = new DTOEsame();
		
		try{
		
			//PAYLOAD SOAP COLE LE INDORMAZIONI DELLO STUDENTE E DELL'ESAME DA SOSTENERE
			/*
			<esame>
               <codice> 
               <dataAppello> 
               <descrizione> 
            </esame>
             
            <studente>
               <cognome> 
               <matricola> 
               <nome> 
            </studente>
			*/
	
			
			SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy"); 
		    Date dataAppello = null; 
		    String appoDateFormat = Commons.getElementValue(from, "dataAppello");
		    dataAppello = ft.parse(appoDateFormat); 
		    
		    //***INFORMAZIONI ESAME DAL PAYLOAD SOAP
		    infoEsame.setCodice(Commons.getElementValue(from, "codice"));
			infoEsame.setDataAppello(dataAppello); 
			infoEsame.setDescrizione(Commons.getElementValue(from, "descrizione"));
			
			 //***INFORMAZIONI STUDENTE DAL PAYLOAD SOAP
		    infoStudente.setNome(Commons.getElementValue(from, "nome"));
			infoStudente.setCognome(Commons.getElementValue(from, "cognome"));
			infoStudente.setMatricola(Commons.getElementValue(from, "matricola"));
						 
			infoPrenEsame.setEsame(infoEsame);
			infoPrenEsame.setStudente(infoStudente);
			
		}catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
			
		return infoPrenEsame;
		
	}
	
		
	
	@Transformer(to = "{urn:it.luigibennardis.esb.prenotazioneesami.switchyard:SWT-servizio-prenotazione-esami:1.0}codiceProssimoAppelloResponse")
	public Element transformStringToCodiceProssimoAppelloResponse(String from) {
		// TODO Auto-generated method stub
		return null;
	}

		
	
	@Transformer(to = "{urn:it.luigibennardis.esb.prenotazioneesami.switchyard:SWT-servizio-prenotazione-esami:1.0}versionResponse")
	public Element transformStringToVersionResponse(String from) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	

	
	@Transformer(to = "{urn:it.luigibennardis.esb.prenotazioneesami.switchyard:SWT-servizio-prenotazione-esami:1.0}listaEsamiResponse")
	public Element transformDTOEsameToListaEsamiResponse(
			DTOEsame[] from) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Transformer(from = "{urn:it.luigibennardis.esb.prenotazioneesami.switchyard:SWT-servizio-prenotazione-esami:1.0}listaEsami")
	public String transformListaEsamiToString(Element from) {
		// TODO Auto-generated method stub
		return "ciccio";
	}

	

}
