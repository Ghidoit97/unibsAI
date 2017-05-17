package tamaZoo;

public class TamaGordo extends Tamagotchi{

	private final static double MULTIPLO_RIDUZIONE=2;
	
	public TamaGordo(String nome, int sazieta, String nomeTipo)
	{
		super(nome,MAX_AFFETTO,sazieta,nomeTipo);
	}
	
	public void riceviCarezze(int numCarezze)
	{
		setGradoSazieta(MULTIPLO_RIDUZIONE*Math.max(0, getGradoSazieta() - numCarezze/FATTORE_CAREZZE));
	}
	
	public void riceviBiscotti(int numBiscotti)
	{
		for (int i = 1; i <= numBiscotti; i++)
		{
		 setGradoSazieta(Math.min(getGradoSazieta()*INCREMENTO_BISCOTTO,MAX_SAZIETA));
		}
	}
	
	public boolean sonoMorto ()
	{
		return getGradoAffettivo() == 0 || getGradoSazieta() == 0 || getGradoSazieta() == MAX_SAZIETA; 
	}
	
	public boolean sonoTriste ()
	{
		return getGradoSazieta() < SOGLIA_SAZIETA_BASSA; 
	}
}
