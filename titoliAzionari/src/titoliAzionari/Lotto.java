package titoliAzionari;

import java.io.Serializable;

public class Lotto implements Serializable{
	
	private final static String DESCRIZIONE="titolo %d azioni del %s\n";
	
	private int quantita;
	private Titolo riferimento;
	
	/**
	 * Si tratta del costruttore della classe che istanzia i valori
	 * @param _azione oggetto di tipo Titolo
	 * @param _quantita indica il numero di azioni comprate per quel titolo
	*/
	
	public Lotto(Titolo riferimento, int quantita)
	{
		this.riferimento=riferimento;
		this.quantita=quantita;
	}
	
	/**
	 * metodo pubblico che restituisce il valore del lotto
	*/
	
	public double valore()
	{
		return quantita*riferimento.getPrezzo();
	}
	
	/**
	 * metodo pubblico che restituisce una stringa che descrive il lotto
	 */
	public String toString()
	{
		return String.format(DESCRIZIONE,quantita,riferimento.toString());
	}
}
