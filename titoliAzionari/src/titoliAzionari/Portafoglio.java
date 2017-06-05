package titoliAzionari;
import java.io.Serializable;
import java.util.*;

/**
 * La classe Portafoglio descrive la struttura dell'oggetto Portafoglio,
 * un'entità software identificata da un nome, da un elenco di titoli e
 * un vettore di Lotto. Permette di effettuare varie operazioni, tra cui
 * l'inserimento di un nuovo Lotto, la stampa della descrizione, la
 * simulazione della variazione del valore dell'elenco titoli e il calcolo
 * del valore totale.
 * @author fabio ghidini
 * @author federico mitelli
 *
 */

public class Portafoglio implements Serializable{
	
	private final String DESCRIZIONE="Portafoglio <%s>:%n";
	
	private String nome;
	private ElencoTitoli elenco;
	private Vector<Lotto> lotto;
	
	/**
	 * Inizializza la struttura dati di Portafoglio con nome,
	 * elenco titoli e un vector di Lotto.
	 * @param nome	(String)	nome del Portafoglio
	 * @param elenco	(ElencoTitoli)	elenco di titoli associato
	 */
	
	public Portafoglio(String nome,ElencoTitoli elenco)
	{
		this.nome=nome;
		this.elenco=elenco;
		lotto=new Vector<Lotto>();
	}
	
	/**
	 * Permette di inserire un lotto nel Vector di Lotto
	 * @param daInserire	nuovo lotto da inserire
	 */
	
	public void addLotto(Lotto daInserire)
	{
		lotto.add(daInserire);
	}
	
	/**
	 * Stampa un messaggio di tipo String con la descrizione del
	 * portafoglio, riportando i messaggi di ogni lotto
	 * @return msg.toString ()	(StringBuffer)	stringa del messaggio
	 */
	
	public String toString()
	{
		StringBuffer msg=new StringBuffer();
		msg.append(String.format(DESCRIZIONE,nome));
		for(Lotto gruppo: lotto)
			msg.append(gruppo.toString());
		return msg.toString();
	}
	
	/**
	 *	Effettua la simulazione della variazione di valore dei
	 *  titoli dell'elenco.
	 */
	
	public void variazione()
	{
		elenco.variazione();
	}
	
	/**
	 * Ritorna il valore totale giornaliero dopo la simulazione
	 * di variazione.
	 * @return value (double) valore totale 
	 */
	
	public double valore()
	{
		double value=0;
		for(int i=0;i<lotto.size();i++)
		{
			value=value+lotto.get(i).valore();
		}
		return value;
	}
}