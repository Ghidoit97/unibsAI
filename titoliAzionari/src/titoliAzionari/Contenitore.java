package titoliAzionari;

import java.io.Serializable;

/**
 * Questa classe rappresenta un contenitore contenete l'elenco dei titoli e il portafoglio.
 * @author fabio ghidini
 * @author federico mitelli
 * 
*/

public class Contenitore implements Serializable{
	
	private ElencoTitoli elencoTitoli;
	private Portafoglio portafoglio;
	
	/**
	 * costruttore della pagina che istanzia gli oggetti
	 * @param _elencoTitoli oggetto rappresentate la classe ElencoTitoli
	 * @param _portafoglio oggetto rappresentante la classe Portafoglio
	*/
	
	public Contenitore(ElencoTitoli elencoTitoli, Portafoglio portafoglio)
	{
		this.elencoTitoli=elencoTitoli;
		this.portafoglio=portafoglio;
	}
	
	/**
	 * metodo pubblico che restituisce l'oggetto elencoTitoli
	*/
	
	public ElencoTitoli getElencoTitoli()
	{
		return elencoTitoli;
	}
	
	/**
     * metodo pubblico che restituisce l'oggetto portafoglio
     */
	
	public Portafoglio getPortafoglio()
	{
		return portafoglio;
	}

}
