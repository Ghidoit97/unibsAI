package massaia;

import java.util.*;

import mylib.InputDati;

public class ElencoIngredienti {
	
	private final static String NOME="Inserisci nome nuovo ingrediente: ";
	private final static String CALORIE="Inserisci calorie apportate per ciascun ettogrammo ingerito: ";
	private final static String INTESTAZIONE="Lista di ingredienti disponibili: ";
	private Vector<Ingredienti> elenco;
	
	public ElencoIngredienti()
	{
		elenco=new Vector<Ingredienti>();
	}
	
	public void aggiungi()
	{
		String nome=InputDati.leggiStringaNonVuota(NOME);
		double calorie=InputDati.leggiDoubleConMinimo(CALORIE, 0);
		elenco.add(new Ingredienti(nome,calorie));
	}
	
	public boolean trova(String nome)
	{
		boolean trovato=false;
		if(elenco.isEmpty()) trovato=false;
		else 
			for(Ingredienti lista: elenco)
			{	
				if(lista.getNome().equalsIgnoreCase(nome))
					trovato=true;
			}
		return trovato;
	}
	
	public Ingredienti getIngrediente(String nome)
	{
		Ingredienti ingrediente=null;
		
		for(Ingredienti lista: elenco)
		{	
			if(lista.getNome().equalsIgnoreCase(nome))
				ingrediente=lista;
		}
		
		return ingrediente;
	}
	
	public String toString()
	{
		StringBuffer msg=new StringBuffer();
		msg.append(INTESTAZIONE + "\n\n");
		for(Ingredienti lista: elenco)
			msg.append(lista.toString()+"\n");
		return msg.toString();
	}
}
