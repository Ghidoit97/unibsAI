package titoliAzionari;

public class Titolo {
	
	private String nome;
	private double valore;
	private final String VALORE_TITOLO="Il valore del titolo %s è %d";
	public Titolo(String _nome, double _valore){
		nome=_nome;
		valore=_valore;
	}
	
	public void modificaValore(double nuovoValore){
		valore=nuovoValore;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public double getValore()
	{
		return valore;
	}
	
	public String toString(){
		return String.format(VALORE_TITOLO, nome, valore);
	}
}
