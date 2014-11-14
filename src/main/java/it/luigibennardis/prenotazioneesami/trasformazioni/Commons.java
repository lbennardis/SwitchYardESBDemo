package it.luigibennardis.prenotazioneesami.trasformazioni;


import it.luigibennardis.prenotazioneesami.dto.DTODatiPrenotazione;

import java.io.StringReader;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Commons {
	public  static String getElementValue(Element parent, String elementName) {
        String value = null;
        NodeList nodes = parent.getElementsByTagName(elementName);
        if (nodes.getLength() > 0) {
            value = nodes.item(0).getChildNodes().item(0).getNodeValue();
        }
        return value;
    }
	
	public static Element toElement(String xml) {
    	DOMResult dom = new DOMResult();
        try {
            TransformerFactory.newInstance().newTransformer().transform(new StreamSource(new StringReader(xml)), dom);
        } catch (Exception e) {
        	e.printStackTrace();
            
        }
        return ((Document) dom.getNode()).getDocumentElement();
    }
    
}
/*
public String transformListaEsamiToString(Element from) {

String  oggetto = new String();

try{
	
	oggetto = Commons.getElementValue(from, "listaEsami");
	
}catch (Exception ex)
{
	ex.printStackTrace();
}
	
return oggetto;

}
public Element transformStringToCodiceProssimoAppelloResponse(String from) {
		
		
		StringBuilder ackXml = new StringBuilder()
        .append("<prenotaEsame:getCodiceEsame xmlns:prenotaEsame=\"urn:com.example.switchyard:switchyardExample_BeanSoa:1.0\">")
        .append("<codiceProssimoAppello>" + from + "</codiceProssimoAppello>")
        .append("</prenotaEsame:getCodiceEsame>");
		 return Commons.toElement(ackXml.toString());
		 
	}
	
	
	@Transformer(to = "{urn:it.luigibennardis.esb.prenotazioneesami.switchyard:SWT-servizio-prenotazione-esami:1.0}prenotaEsamiResponse")
	public Element transformDTODatiPrenotazioneToPrenotaEsamiResponse(
			DTODatiPrenotazione from) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transformer(from = "{urn:it.luigibennardis.esb.prenotazioneesami.switchyard:SWT-servizio-prenotazione-esami:1.0}listaEsami")
	public String transformListaEsamiToString(Element from) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
*/