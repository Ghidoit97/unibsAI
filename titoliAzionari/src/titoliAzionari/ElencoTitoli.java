package titoliAzionari;
import java.util.*;

public class ElencoTitoli {
	
	private Vector<Titolo> elenco;
	
	private final String INTESTAZIONE="Elenco titoli azionari: \n";
	
	public ElencoTitoli()
	{
		elenco=new Vector <Titolo> ();
	}
	
	public void aggiungiTitolo(Titolo _titolo){
		for(Titolo value : elenco)
			if(value.getNome().equalsIgnoreCase(_titolo.getNome()))
			elenco.add(_titolo);
	}
	
	public String toString()
	{
		StringBuffer msg=new StringBuffer();
		msg.append(INTESTAZIONE);
		for(Titolo value : elenco){
			msg.append(value+"\n");
		}
		return msg.toString();
	}
	
	public void simulaVariazione()
	{
		//da completare
	}
}
