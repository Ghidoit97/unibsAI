package tamaZoo;

/**
 * La classe Tamagotchi descrive un oggetto di tipo Tamagotchi , 
 * un entità software che Ë in grado di recepire stimoli esterni ,
 * i quali determinano la sua sopravvivenza e il suo grado di benessere .
 * La classe modifica questi valori in base agli input dell'utente e
 * stabilisce se il tamagotchi Ë felice , triste o morto.
 * 
 * @author Ghidini Fabio
 * @author Mitelli Federico
 */

public class Tamagotchi {
	
	public final static int MAX_AFFETTO = 100;
	public final static int MAX_SAZIETA = 100;
	
	public final static int SOGLIA_AFFETTO_BASSO = 30;
	public final static int SOGLIA_SAZIETA_BASSA = 30;
	public final static int SOGLIA_SAZIETA_ALTA = 90;
	
	protected final double FATTORE_CAREZZE = 2;
	protected final double FATTORE_BISCOTTI = 4;
	protected final double INCREMENTO_BISCOTTO = 1.1;
	
	private final static String DESCRIZIONE = "Sono %s%nIl mio grado di sazieta e' %1.2f%nIl mio grado di soddisfazione affettiva e' %1.2f";
	private final static String MESS_DEAD = "\nAttenzione sono violate le condizioni per la mia sopravvivenza! Addio!";
	private final static String MESS_SAD = "\nAttenzione sono infelice!";
	
	/**
	 * Attributi :
	 * @link nome				nome del tamagotchi 	
	 * @link gradoAffettivo		livello di soddisfazione del tamagotchi
	 * @link gradoSazieta		livello di saziet· del tamagotchi
	 * @link nomeTipo			nome della specie	
	 */
	
    private String nome;
	private double gradoAffettivo;
	private double gradoSazieta;
	private String nomeTipo;
	
	/**
	 * Inizializza i valori iniziali degli attributi 
	 * 
	 * @param nome 				nome del tamagotchi
	 * @param gradoAffettivo	grado iniziale di soddisfazione
	 * @param gradoSazieta		grado iniziale di sazieta
	 * @param nomeTipo			nome della specie
	 */
	public Tamagotchi (String nome, int gradoAffettivo, int gradoSazieta, String nomeTipo)
	{
		this.nome=nome;
		this.gradoAffettivo=gradoAffettivo;
		this.gradoSazieta=gradoSazieta;
		this.nomeTipo=nomeTipo;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String _nome)
	{
		this.nome=_nome;
	}
	
	public double getGradoAffettivo()
	{
		return gradoAffettivo;
	}
	
	public void setGradoAffettivo(double _gradoAffettivo)
	{
		gradoAffettivo=_gradoAffettivo;
	}
	
	public double getGradoSazieta()
	{
		return gradoSazieta;
	}
	
	public void setGradoSazieta(double _gradoSazieta)
	{
		gradoSazieta=_gradoSazieta;
	}
	
	/**
	 *Imposta il nuovo valore del gradoAffettivo
	 *Imposta il nuovo valore del gradoSazieta
	 * 
	 * @param numCarezze numero di carezze ricevute
	 */
	public void riceviCarezze(int numCarezze)
	{
		gradoAffettivo=Math.min(gradoAffettivo+numCarezze,MAX_AFFETTO);
		gradoSazieta = Math.max(0, gradoSazieta - numCarezze/FATTORE_CAREZZE);
	}
	
	/**
	 *Imposta il nuovo valore del gradoAffettivo
	 *Imposta il nuovo valore del gradoSazieta
	 *
	 * @param numBiscotti numero di biscotti ricevuti
	 */
	
	public void riceviBiscotti(int numBiscotti)
	{
		for (int i = 1; i <= numBiscotti; i++)
		{
		 gradoSazieta=Math.min(gradoSazieta*INCREMENTO_BISCOTTO,MAX_SAZIETA);
		}
		gradoAffettivo = Math.max(0, gradoAffettivo - numBiscotti/FATTORE_BISCOTTI);
	}
	
	/**
	 * Effettua un controllo dello stato vitale del tamaGordo.
	 * 
	 * @return false (boolean) se è ancora vivo
	 * @return true (boolean) se è morto
	 */
	
	public boolean sonoMorto ()
	{
		return gradoAffettivo == 0 || gradoSazieta == 0 || gradoSazieta == MAX_SAZIETA; 
	}
	
	/**
	 * Effettua un controllo dello stato emozionale del tamaGordo.
	 * 
	 * @return false (boolean) se è felice
	 * @return true (boolean) se è triste
	 */
	
	public boolean sonoTriste ()
	{
		return gradoAffettivo < SOGLIA_AFFETTO_BASSO || gradoSazieta < SOGLIA_SAZIETA_BASSA || gradoSazieta > SOGLIA_SAZIETA_ALTA; 
	}
	
	/**
	 * Ritorna una stringa con la descrizione dello stato del tamagotchi,
	 * seguita da un messaggio che esprime se è morto o vivo
	 * e, in caso, se è triste o felice.
	 * 
	 * @return msg (String) Stringa dello stato del tamagotchi
	 */
	public String toString()
	{
		StringBuffer msg = new StringBuffer();
		msg.append(String.format(DESCRIZIONE, nome, gradoSazieta, gradoAffettivo));
		if (sonoMorto())
			msg.append(MESS_DEAD);
		else 
		 if (sonoTriste())
		   msg.append(MESS_SAD);
		
		return msg.toString(); 
		
	}
}

