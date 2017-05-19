package titoliAzionari;

import mylib.NumeriCasuali;

public class Titolo {
	
	private final static double MAX_RIALZO=+30.0/100.0;
	private final static double MAX_RIBASSO=-30.0/100.0;
	private final static String DESCRIZIONE="titolo: %s %t Valore: %.2f %n";
	
	private String nome;
	private double valore;
	
	public Titolo(String nome, double valore)
	{
		this.nome=nome;
		this.valore=valore;
	}
	
	public double getValore()
	{
		return valore;
	}
	
	public String toString()
	{
		return String.format(DESCRIZIONE,nome,valore);
	}
	
	public void variazione()
	{
		double varia=NumeriCasuali.estraiDouble(MAX_RIBASSO, MAX_RIALZO);
		valore=valore+(valore*varia);
	}
}
