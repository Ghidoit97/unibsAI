package massaia;

import mylib.InputDati;
import java.util.*;

public class Ricette {
	
	private final static String DESCRIZIONE1="%nRicetta: %s %nTipo: ";
	private final static String DESCRIZIONE2="Ingrediente: %s %nQuantita: %.2f %n";
	private final static String CALORIE="Calorie totali ricetta: %.2f";
	private final static String PRIMO="Primo piatto ";
	private final static String SECONDO="Secondo piatto ";
	
	private String nome;
	ArrayList<Ingredienti> ingredienti;
	ArrayList<Double> quantita;
	private int tipo;
	private double calorieTotali;
	
	public Ricette(String nome,ArrayList<Ingredienti> ingredienti,ArrayList<Double> quantita,int tipo)
	{
		this.nome=nome;
		this.ingredienti=ingredienti;
		this.quantita=quantita;
		this.tipo=tipo;
	}
	
	public String toString()
	{
		StringBuffer msg=new StringBuffer();
		msg.append(String.format(DESCRIZIONE1,nome));
		if(tipo==1) msg.append(PRIMO+"\n");
		if(tipo==2) msg.append(SECONDO+"\n");
		for(int i=0; i<ingredienti.size() && i<quantita.size();i++)
			{
				msg.append(String.format(DESCRIZIONE2,ingredienti.get(i).getNome(),quantita.get(i).doubleValue()));
				calorieTotali=calorieTotali+(ingredienti.get(i).getCalorie()*quantita.get(i));
			}
		return msg.toString();
	}
	
	public double getCalorieTotali()
	{
		return calorieTotali;
	}
	
	public int getTipo()
	{
		return tipo;
	}
}
