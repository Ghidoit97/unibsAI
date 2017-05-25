package tamaZoo;

/**
 * Sottoclasse di Tamagotchi: TamaGordo
 * Pensa solo a mangiare ed è insensibile alle carezze
 * Sono stati effettuati degli override di metodi presenti nella superclasse Tamagotchi
 * 
 * @author Ghidini Fabio
 * @author Mitelli Federico
 *
 */

public class TamaGordo extends Tamagotchi{

	private final static double MULTIPLO_RIDUZIONE=2;
	
	/**
	 * Inizializza la struttura dati del TamaGordo
	 * 
	 * @param nome nome del tamagotchi
	 * @param sazieta grado di sazieta'
	 * @param nomeTipo tipologia, in questo caso ingordo
	 */
	
	public TamaGordo(String nome, int sazieta, String nomeTipo)
	{
		super(nome,MAX_AFFETTO,sazieta,nomeTipo);
	}
	
	public TamaGordo(String nome, int sazieta)
	{
		super(nome,MAX_AFFETTO,sazieta);
	}
	/**
	 * Gestisce la variazione del proprio stato in base alle carezze ricevute.
	 * Modifica solo il grado di sazieta' moltiplicandolo per 2(MULTIPLO_RIDUZIONE.
	 * 
	 * @param numCarezze	numero di carezze somministrate
	 */
	
	public void riceviCarezze(int numCarezze)
	{
		setGradoSazieta(MULTIPLO_RIDUZIONE*Math.max(0, getGradoSazieta() - numCarezze/FATTORE_CAREZZE));
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
	 * Effettua un controllo dello stato vitale del tamaGordo.
	 * Muore solo se il grado di sazieta' è uguale a 0.
	 * 
	 * @return false (boolean) se è ancora vivo
	 * @return true (boolean) se è morto
	 */
	
	public boolean sonoMorto ()
	{
		return getGradoSazieta() == 0;
	}
	
	/**
	 * Effettua un controllo dello stato emozionale del tamaGordo.
	 * 
	 * @return true (boolean) se il grado sazieta risulta minore alla soglia minima
	 * @return false (boolean) se il grado sazieta risulta maggior o uguale della soglia minima
	 */
	
	public boolean sonoTriste ()
	{
		return getGradoSazieta() < SOGLIA_SAZIETA_BASSA; 
	}
}
