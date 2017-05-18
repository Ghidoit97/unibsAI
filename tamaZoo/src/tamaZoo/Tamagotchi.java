package tamaZoo;

// QUESTA CLASSE Tamagotchi e' la stessa usata per l'esercitazione precedente

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
	
	
    private String nome;
	private double gradoAffettivo;
	private double gradoSazieta;
	private String nomeTipo;
	
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
	
	public void riceviCarezze(int numCarezze)
	{
		gradoAffettivo=Math.min(gradoAffettivo+numCarezze,MAX_AFFETTO);
		gradoSazieta = Math.max(0, gradoSazieta - numCarezze/FATTORE_CAREZZE);
	}
	
	public void riceviBiscotti(int numBiscotti)
	{
		for (int i = 1; i <= numBiscotti; i++)
		{
		 gradoSazieta=Math.min(gradoSazieta*INCREMENTO_BISCOTTO,MAX_SAZIETA);
		}
		gradoAffettivo = Math.max(0, gradoAffettivo - numBiscotti/FATTORE_BISCOTTI);
	}
	
	public boolean sonoMorto ()
	{
		return gradoAffettivo == 0 || gradoSazieta == 0 || gradoSazieta == MAX_SAZIETA; 
	}
	
	public boolean sonoTriste ()
	{
		return gradoAffettivo < SOGLIA_AFFETTO_BASSO || gradoSazieta < SOGLIA_SAZIETA_BASSA || gradoSazieta > SOGLIA_SAZIETA_ALTA; 
	}
	
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

