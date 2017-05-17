package titoliAzionari;

public class LottoPosseduto {
	private Titolo azione;
	private int quantita;
	
	public LottoPosseduto(Titolo _azione, int _quantita){
		azione=_azione;
		quantita=_quantita;
	}
	
	public double valore(){
		//da completare
	}
	
	public String toString()
	{
		return quantita + " " + azione.toString();
	}
}
