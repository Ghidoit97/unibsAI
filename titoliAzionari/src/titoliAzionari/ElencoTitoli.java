package titoliAzionari;

import java.util.Vector;
import java.io.Serializable;

public class ElencoTitoli implements Serializable{
	
	private Vector<Titolo> elenco;
	
	public ElencoTitoli()
	{
		elenco=new Vector<Titolo>();
	}
	
	public int getNumTitoli()
	{
		return elenco.size();
	}
	
	public Titolo getTitolo(int num)
	{
		return elenco.get(num);
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
			lista.variazGiornaliera();
		}
	}
}
