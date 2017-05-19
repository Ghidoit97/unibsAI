package titoliAzionari;

import java.util.Vector;

public class ElencoTitoli {
	
	private Vector<Titolo> elenco;
	
	public ElencoTitoli()
	{
		elenco=new Vector<Titolo>();
	}
	
	public void inserisci(Titolo daInserire)
	{
		elenco.add(daInserire);
	}
	
	public String toString()
	{
		StringBuffer msg=new StringBuffer();
		for(Titolo lista: elenco)
			msg.append(lista.toString());
		return msg.toString();
	}
	
	public void variazione()
	{
		for(Titolo lista: elenco)
		{
			lista.variazione();
		}
	}
}
