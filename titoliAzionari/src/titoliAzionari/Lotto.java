package titoliAzionari;

import java.io.Serializable;

public class Lotto implements Serializable{
	
	private final static String DESCRIZIONE="titolo %d azioni del %s\n";
	
	private int quantita;
	private Titolo riferimento;
	
	public Lotto(Titolo riferimento, int quantita)
	{
		this.riferimento=riferimento;
		this.quantita=quantita;
	}
	
	public double valore()
	{
		return quantita*riferimento.getPrezzo();
	}
	
	public String toString()
	{
		return String.format(DESCRIZIONE,quantita,riferimento.toString());
	}
}
