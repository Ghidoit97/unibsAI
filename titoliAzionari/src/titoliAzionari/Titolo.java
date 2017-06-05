package titoliAzionari;

import java.io.Serializable;

import mylib.NumeriCasuali;

/**
 * La classe Titolo descrive un oggetto di tipo Titolo,
 * ovvero un entità software che contiene un valore (prezzo)
 * e un nome.
 * 
 * @author fabio ghidini
 * @author federico mitelli
 *
 */

public class Titolo implements Serializable{
	
	private final static double MAX_RIALZO=+30.0/100.0;
	private final static double MAX_RIBASSO=-30.0/100.0;
	private final static String DESCRIZIONE="%s Valore: %.2f";
	
	private String nome;
	private double valore;
	
	/**
	 * Inizializza la struttura dati di Titolo
	 * 
	 * @param nome		(String) nome del titolo
	 * @param valore	(double) valore/prezzo del titolo
	 */
	
	public Titolo(String nome, double valore)
	{
		this.nome=nome;
		this.valore=valore;
	}
	
	/**
	 * Ritorna il valore del titolo in formato double
	 * @return valore del titolo
	 */
	
	public double getPrezzo()
	{
		return valore;
	}
	
	/**
	 * Ritorna una stringa con la descrizione del titolo con nome e valore
	 * @return String.format 	stringa contenente la descrizione del titolo
	 */ 
	
	public String toString()
	{
		return String.format(DESCRIZIONE,nome,valore);
	}
	
	/**
	 * Simula la variazione del valore effettuando un estrazione casuale
	 * di un double attraverso la classe di utilità NumeriCasuali
	 */
	
	public void variazGiornaliera()
	{
		double varia=NumeriCasuali.estraiDouble(MAX_RIBASSO, MAX_RIALZO);
		valore=valore+(valore*varia);
	}
}
