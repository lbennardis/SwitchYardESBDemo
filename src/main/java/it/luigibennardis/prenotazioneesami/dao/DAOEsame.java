package it.luigibennardis.prenotazioneesami.dao;

import static java.lang.System.out;

import it.luigibennardis.prenotazioneesami.dto.DTOEsame;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DAOEsame {
	private DTOEsame[] esamiDisponibili = null;
		
	public DTOEsame[] listaEsamiDisponibili(String matricolaStudente, String codiceAppello) throws ParseException{
		
		try{
			
			//***VERIFICA LE CONDIZIONI DI ISCRIZIONE E DI PROPEDUTICITA
			//***ACCEDE ALLA BASE DATI E RITORNA LA LISTA DEGLI ESAMI CHE LO STUDENTE PUO' SOSTENERE AL PROSSIMO APPELLO
			
			
			esamiDisponibili = new DTOEsame[4];
			 
			out.println("len: " + esamiDisponibili.length);
			SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
			
			Date dt = ft.parse("26/09/2013");
			esamiDisponibili[0] = new DTOEsame();
			esamiDisponibili[0].setCodice("AUT001");
			esamiDisponibili[0].setDataAppello(dt);
			esamiDisponibili[0].setDescrizione("Economia Politica");
			
			Date dt1 = ft.parse("19/09/2013");
			esamiDisponibili[1] = new DTOEsame();
			esamiDisponibili[1].setCodice("AUT021");
			esamiDisponibili[1].setDataAppello(dt1);
			esamiDisponibili[1].setDescrizione("Statistica multivariata");
			
			Date dt2 = ft.parse("21/09/2013");
			esamiDisponibili[2] = new DTOEsame();
			esamiDisponibili[2].setCodice("AUT022");
			esamiDisponibili[2].setDataAppello(dt2);
			esamiDisponibili[2].setDescrizione("Probabilità");
			
			Date dt3 = ft.parse("28/09/2013");
			esamiDisponibili[3] = new DTOEsame();
			esamiDisponibili[3].setCodice("AUT032");
			esamiDisponibili[3].setDataAppello(dt3);
			esamiDisponibili[3].setDescrizione("Informatica");
			
			return esamiDisponibili;
		}
		catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String toXML(){
						 
		String XLMEsami = "<ListaEsami>";
		
		if (esamiDisponibili == null){
			XLMEsami.concat("<Esame>");
			
			XLMEsami.concat("<Codice>");
			XLMEsami.concat("</Codice>");
			
			XLMEsami.concat("<Descrizione>");
			XLMEsami.concat("</Descrizione>");
						
			XLMEsami.concat("<DataAppello>");
			XLMEsami.concat("</DataAppello>");
			
			XLMEsami.concat("</Esame>");
			
		}else{
			for(int iEsami = 0; iEsami < esamiDisponibili.length ; iEsami++){
				XLMEsami.concat("<Esame>");
				
				XLMEsami.concat("<Codice>");
				XLMEsami.concat(esamiDisponibili[iEsami].getCodice());
				XLMEsami.concat("</Codice>");
				
				XLMEsami.concat("<Descrizione>");
				XLMEsami.concat(esamiDisponibili[iEsami].getDescrizione());
				XLMEsami.concat("</Descrizione>");
							
				XLMEsami.concat("<DataAppello>");
				XLMEsami.concat(esamiDisponibili[iEsami].getDataAppello().toString());
				XLMEsami.concat("</DataAppello>");
				
				XLMEsami.concat("</Esame>");
			}
		}
		
		XLMEsami.concat("</ListaEsami>");
		return XLMEsami;
	}
}

 