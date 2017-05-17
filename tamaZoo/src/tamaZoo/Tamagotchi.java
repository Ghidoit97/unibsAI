package tamaZoo;

// QUESTA CLASSE Tamagotchi e' la stessa usata per l'esercitazione precedente

public class Tamagotchi {
	
	public final static int MAX_AFFETTO = 100;
	public final static int MAX_SAZIETA = 100;
	
	public final static int SOGLIA_AFFETTO_BASSO = 30;
	public final static int SOGLIA_SAZIETA_BASSA = 30;
	public final static int SOGLIA_SAZIETA_ALTA = 90;
	
	private final double FATTORE_CAREZZE = 2;
	private final double FATTORE_BISCOTTI = 4;
	private final double INCREMENTO_BISCOTTO = 1.1;
	
	private final static String DESCRIZIONE = "Sono %s%nIl mio grado di saziet� � %1.2f%nIl mio grado di soddisfazione affettiva � %1.2f";
	private final static String MESS_DEAD = "\nAttenzione sono violate le condizioni per la mia sopravvivenza! Addio!";
	private final static String MESS_SAD = "\nAttenzione sono infelice!";
	
	
    private String nome;
	private double gradoAffettivo;
	private double gradoSaziet�;
	
	public Tamagotchi (String nome, int gradoAffettivo, int gradoSaziet�)
	{
		this.nome=nome;
		this.gradoAffettivo=gradoAffettivo;
		this.gradoSaziet�=gradoSaziet�;
	}
	
		
	public void riceviCarezze(int numCarezze)
	{
		gradoAffettivo=Math.min(gradoAffettivo+numCarezze,MAX_AFFETTO);
		gradoSaziet� = Math.max(0, gradoSaziet� - numCarezze/FATTORE_CAREZZE);
	}
	
	public void riceviBiscotti(int numBiscotti)
	{
		for (int i = 1; i <= numBiscotti; i++)
		{
		 gradoSaziet�=Math.min(gradoSaziet�*INCREMENTO_BISCOTTO,MAX_SAZIETA);
		}
		gradoAffettivo = Math.max(0, gradoAffettivo - numBiscotti/FATTORE_BISCOTTI);
	}
	
	public boolean sonoMorto ()
	{
		return gradoAffettivo == 0 || gradoSaziet� == 0 || gradoSaziet� == MAX_SAZIETA; 
	}
	
	public boolean sonoTriste ()
	{
		return gradoAffettivo < SOGLIA_AFFETTO_BASSO || gradoSaziet� < SOGLIA_SAZIETA_BASSA || gradoSaziet� > SOGLIA_SAZIETA_ALTA; 
	}
	
	public String toString()
	{
		StringBuffer result = new StringBuffer();
		result.append(String.format(DESCRIZIONE, nome, gradoSaziet�, gradoAffettivo));
		if (sonoMorto())
			result.append(MESS_DEAD);
		else 
		 if (sonoTriste())
		   result.append(MESS_SAD);
		
		return result.toString(); 
		
	}
}

