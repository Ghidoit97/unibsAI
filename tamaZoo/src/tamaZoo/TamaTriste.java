package tamaZoo;

public class TamaTriste extends Tamagotchi{
	
	public TamaTriste(String nome, int sazieta, String nomeTipo)
	{
		super(nome,0,sazieta,nomeTipo);
	}
	
	public void riceviCarezze(int numCarezze)
	{
		setGradoSazieta(Math.max(0, getGradoSazieta() - numCarezze/FATTORE_CAREZZE));
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
		return getGradoSazieta() == 0 || getGradoSazieta() == MAX_SAZIETA; 
	}
	
	public boolean sonoTriste ()
	{
		return true;
	}
}
