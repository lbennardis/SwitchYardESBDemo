package it.luigibennardis.prenotazioneesami.switchyard.remoteinvoker;

import it.luigibennardis.prenotazioneesami.dto.DTODatiPrenotazione;
import it.luigibennardis.prenotazioneesami.dto.DTOEsame;
import it.luigibennardis.prenotazioneesami.dto.DTOInformazioniEsame;
import it.luigibennardis.prenotazioneesami.dto.DTOStudente;

import javax.xml.namespace.QName;

import org.switchyard.remote.RemoteInvoker;
import org.switchyard.remote.RemoteMessage;
import org.switchyard.remote.http.HttpInvoker;

public class Test {

	private static final QName SERVICEPRENOTAZIONE = new QName(
            "urn:it.luigibennardis.esb.prenotazioneesami.switchyard:SWT-servizio-prenotazione-esami:1.0",
            "PrenotazioneEsame");
        
    private static final String URL = "http://localhost:8080/switchyard-remote";
   
    
    public static void main(final String[] ignored) throws Exception {
        
    	        
    	System.out.println("==============================================");
    	System.out.println("AVVIO CLIENT PRENOTAZIONE ESAME-REMOTE INVOKER");
    	System.out.println("==============================================");
    	
        //***CLIENT DI INVOCAZIONE DI UN SERVIZIO SWITCHYARD 
        //***CON TECNOLOGIA REMOTE INVOKER SU PROTOCOLLO HTTP 
        
        RemoteInvoker invokerListaEsame = new HttpInvoker(URL);
        RemoteMessage messageListaEsame = new RemoteMessage();
        
        //***STRINGA CON MATRICOLA OGGETTO DA UTILIZZARE COME PARAMETRO DI INVOCAZIONE 
        //***DEL MEDODO ESPOSTO DAL SERVIZIO DI PRENOTAZIONE ESAMI 
        String matricolaStudente = new String ("INFO00001");
        
        
        messageListaEsame.setService(SERVICEPRENOTAZIONE);
        messageListaEsame.setOperation("listaEsami");
        messageListaEsame.setContent(matricolaStudente); 
                
        DTOEsame[] resultListaEsami = null; 
        RemoteMessage replyListaEsami = null;
        
        //***INVOCAZIONE METODO ESPOSTO DAL SERVIZIO DI PRENOTAZIONE ESAMI
        //***RITORNA LA LISTA DELGI ESAMI CHE LO STUDENTE POTRA' SOSTENERE AL PROSSIMO APPELLO
        try {
           	replyListaEsami = invokerListaEsame.invoke(messageListaEsame);
        }catch(java.net.ConnectException connEx ){
        	System.err.println("FAULT IN FASE DI CONNESSIONE. SERVIZIO: " + URL + " NON DISPONIBILE");
        }         
        
        //***VERIFICHIAMO EVENTUALI FAULT IN FASE DI INVOCAZIONE
        if (replyListaEsami.isFault()){
        	System.err.println("FAULT IN FASE DI invokerListaEsame.invoke(messageListaEsame)"
                    + replyListaEsami.getContent());
        }else{
        	
        	//***NEL CONTENT TROVIAMO UN ARRAY DI OGGETTI DI DIPO DTOEsame
        	Object[] objects = (Object[])replyListaEsami.getContent();
        	
        	resultListaEsami  = new DTOEsame[objects.length +1] ;
        	
        	for (int i = 0; i<objects.length; i++){
        	resultListaEsami[i] =(DTOEsame)objects[i];
        	
        	System.out.println(resultListaEsami[i].getDescrizione());
        	System.out.println(resultListaEsami[i].getCodice());
        	System.out.println(resultListaEsami[i].getDataAppello().toString());
        	
        	}
        	        
        }
        
        RemoteInvoker invokerVersione = new HttpInvoker(URL);
        RemoteMessage messageVersione = new RemoteMessage();
        
        messageVersione.setService(SERVICEPRENOTAZIONE);
        messageVersione.setOperation("version");
        messageVersione.setContent(null);

        RemoteMessage replyVersione = invokerVersione.invoke(messageVersione);
        if (replyVersione.isFault()){
        	System.err.println("FAULT IN CASO NON TROVA IL METODO setOperation impostato "
                    + replyVersione.getContent());
        }else{
        	
        if(replyVersione.getContent()!= null)
        {	
        	String result = (String)replyVersione.getContent();
        	System.out.println("versione ->" + result );
	        }else{
	        	System.err.println("replyVersione E' NULLO!! ");
	        }
        }
        
        RemoteInvoker invokerPrEsame = new HttpInvoker(URL);
        
        DTOInformazioniEsame dtoInfoEsame = new DTOInformazioniEsame();
        
        ///***SELEZIONE UNO DEGLI ESAMI DELLA LISTA E NE RICHIEDE LA PRENOTAZIONE
        dtoInfoEsame.setEsame(resultListaEsami[1]);
                 
        DTOStudente studente = new DTOStudente();
        
        studente.setCognome("Bennardis");
        studente.setNome("Luigi");
        studente.setMatricola(matricolaStudente);
        
        dtoInfoEsame.setStudente(studente); 
        
        //***VIENE INVOCATO IL METODO DI PRENOTAZIONE DEGLI ESAMI ESPOSTO DAL SERVIZIO 
        RemoteMessage messagePrEsame = new RemoteMessage();
        messagePrEsame.setService(SERVICEPRENOTAZIONE).setOperation("prenotaEsami").setContent(dtoInfoEsame);

        RemoteMessage replyEsame = invokerPrEsame.invoke(messagePrEsame);
        if (replyEsame.isFault()){
        	System.err.println("FAULT IN CASO NON TROVA IL METODO setOperation impostato "
                    + replyEsame.getContent());
        }else{
        	
        	if(replyEsame.getContent()!= null){	
        		DTODatiPrenotazione result = (DTODatiPrenotazione)replyEsame.getContent();
        		System.out.println("codice prenotazione -> " + result.getCodicePrenotazione());
	        }else{
	        	System.err.println("codice prenotazione -> NULLO");
	        }
        
        }
    }

       
}
    
    