package titoliAzionari;

public class Lotto {
	
	private final static String DESCRIZIONE="%d azioni del %s";
	
	private int quantita;
	private Titolo riferimento;
	
	public Lotto(Titolo riferimento, int quantita)
	{
		this.riferimento=riferimento;
		this.quantita=quantita;
	}
	
	public double getValore()
	{
		return quantita*riferimento.getValore();
	}
	
	public String toString()
	{
		return String.format(DESCRIZIONE,riferimento.toString(),quantita);
	}
}
