package titoliAzionari;

import mylib.EstrazioniCasuali;

public class Titolo {
	
	private final static String DESCRIZIONE="titolo: %s %t Valore: %.2f %n";
	
	private String nome;
	private double valore;
	
	public Titolo(String nome, double valore)
	{
		this.nome=nome;
		this.valore=valore;
	}
	
	public String toString()
	{
		return String.format(DESCRIZIONE,nome,valore);
	}
	
	public void variazione()
	{
		double varia=EstrazioniCasuali.estraiIntero(-100,100);
		valore=valore*(100+varia)/100;
	}
}
