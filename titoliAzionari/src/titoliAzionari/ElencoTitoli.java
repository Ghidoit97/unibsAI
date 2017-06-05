package titoliAzionari;

import java.util.Vector;
import java.io.Serializable;

/**
 * Questa classe rappresenta un'elenco di titoli.
 * @author fabio ghidini
 * @author federico mitelli
 * 
*/

public class ElencoTitoli implements Serializable{
	
	private Vector<Titolo> elenco;
	
	/**
     * metodo pubblico che istanzia il Vector listino
     */
	
	
	public ElencoTitoli()
	{
		elenco=new Vector<Titolo>();
	}
	
	 /**
	    * metodo pubblico che restituisce la dimensione del Vector listino
	    */
	
	public int getNumTitoli()
	{
		return elenco.size();
	}
	
	/**
     * metodo pubblico che permette di visualizzare l'oggetto presente alla posizione 'i' del vector
     * @param i numero contenente la posizione dell'oggetto da leggere
     */
	
	public Titolo getTitolo(int num)
	{
		return elenco.get(num);
	}
	
	/**
     * metodo pubblico che permette di aggiungere un'oggetto di tipo Titolo al Vector listino
     * @param tit oggetto di tipo Titolo da aggiungere al Vector
     */
	
	public void inserisci(Titolo daInserire)
	{
		elenco.add(daInserire);
	}
	
	/**
     * metodo pubblico che permette di ristituire una stringa 
     * con la descrizione del degli oggetti presenti nel Vector
     */
	
	public String toString()
	{
		StringBuffer msg=new StringBuffer();
		for(Titolo lista: elenco)
			msg.append(lista.toString());
		return msg.toString();
	}
	
	/**
     * metodo pubblico che simula la variazione giornaliera dell'andamento dei titoli azionari
     */
	
	public void variazione()
	{
		for(Titolo lista: elenco)
		{
			lista.variazGiornaliera();
		}
	}
}
