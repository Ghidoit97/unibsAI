package olimpiadi;

import java.util.Vector;

/**
 * Descrive un oggetto di tipo gara.
 * 
 * @author Federico Mitelli @author Fabio Ghidini
 * 
 */

public class Gara {
	/**
	 * nome nome gara
	 * eseguita true se eseguita
	 * premiate vettore delle nazioni premiate
	 */
	private String nome;
	private boolean eseguita;
	private Vector <Nazione> premiate;
	
	public Gara(String _nome){
		nome=_nome;
		eseguita=false;
		premiate=new Vector <Nazione>();
	}
	
	public String getNome(){
		return nome;
	}
	/**
	 * Ritorna true se la nazione risulta premiata, false in caso contrario
	 * 
	 * @param nNazione String passa il vettore nazione
	 * @return ritorna un valore di tipo boolean
	 */
	boolean giaPremiata(String nNazione){
		boolean isPremiata=false;
		for(Nazione value : premiate){
			if(value.getNome().equalsIgnoreCase(nNazione)){
				isPremiata=true;
			}
		}
		return isPremiata;
	}
	
	public void setEseguita(){
		eseguita=true;
	}
	/**
	 * Aggiunge la nazione premiata al vettore premiata
	 * @param n Nazione passa la nazione premiata
	 */
	public void aggiungiPremiata(Nazione n){
		premiate.add(n);
	}
}
