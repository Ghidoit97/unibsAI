package tamaZoo;

/**
 * Sottoclasse di Tamagotchi: TamaTriste
 * è sempre infelice indipendentemente da quante carezze o biscotti riceve (però non muore mai di infelicità)
 * Sono stati effettuati degli override di metodi presenti nella superclasse Tamagotchi
 * 
 * @author Ghidini Fabio
 * @author Mitelli Federico
 */

public class TamaTriste extends Tamagotchi{
	
	/**
	 * Inizializza la struttura dati del TamaTriste
	 * 
	 * @param nome nome del tamagotchi
	 * @param sazieta grado di sazieta'
	 * @param nomeTipo tipologia, in questo caso triste
	 */
	
	public TamaTriste(String nome, int sazieta, String nomeTipo)
	{
		super(nome,0,sazieta,nomeTipo);
	}
	
	/**
	 * Gestisce la variazione del proprio stato in base alle carezze ricevute.
	 * Modifica solo il grado di sazieta'.
	 * 
	 * @param numCarezze	numero di carezze somministrate
	 */
	
	public void riceviCarezze(int numCarezze)
	{
		setGradoSazieta(Math.max(0, getGradoSazieta() - numCarezze/FATTORE_CAREZZE));
	}
	
	/**
	 * Gestisce la variazione del proprio stato in base ai biscotti ricevuti.
	 * Modifica solo il grado di sazieta'.
	 * 
	 * @param numBiscotti	numero di biscotti somministrati
	 */
	
	public void riceviBiscotti(int numBiscotti)
	{
		for (int i = 1; i <= numBiscotti; i++)
		{
		 setGradoSazieta(Math.min(getGradoSazieta()*INCREMENTO_BISCOTTO,MAX_SAZIETA));
		}
	}
	
	/**
	 * Effettua un controllo dello stato vitale del tamatriste.
	 * Muore solo se il grado di sazieta' è uguale a 0 o 100.
	 * 
	 * @return false (boolean) se è ancora vivo
	 * @return true (boolean) se è morto
	 */
	
	public boolean sonoMorto ()
	{
		return getGradoSazieta() == 0 || getGradoSazieta() == MAX_SAZIETA; 
	}
	
	/**
	 * Effettua un controllo dello stato emozionale del tamatriste.
	 * Risulta sempre triste.
	 * 
	 * @return true (boolean) sempre triste
	 */
	
	public boolean sonoTriste ()
	{
		return true;
	}
}
