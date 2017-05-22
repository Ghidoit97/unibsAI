package titoliAzionari;

import java.io.Serializable;

import mylib.NumeriCasuali;

public class Titolo implements Serializable{
	
	private final static double MAX_RIALZO=+30.0/100.0;
	private final static double MAX_RIBASSO=-30.0/100.0;
	private final static String DESCRIZIONE="%s Valore: %.2f";
	
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
