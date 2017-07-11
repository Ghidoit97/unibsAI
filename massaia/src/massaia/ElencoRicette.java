package massaia;

import java.util.*;

import mylib.InputDati;

public class ElencoRicette {
	
	private final static String TITOLO="Elenco di ricette presenti: ";
	private final static String NOME="Inserisci nome della nuova ricetta: ";
	private final static String ALTRO_INGREDIENTE="Vuoi inserire un altro ingrediente? ";
	private final static String INSERISCI_INGREDIENTE="Inserisci il nome dell'ingrediente: ";
	private final static String INSERISCI_QUANTITA="Inserisci la quantita dell'ingrediente in ettogrammi: ";
	private final static String NON_PRESENTE="L'ingrediente non risulta essere presente. ";
	private final static String TIPO="Inserisci 1 se la ricetta è un primo piatto, oppure 2 se è un secondo piatto: ";
	
	private Vector<Ricette> ricette;
	private ElencoIngredienti ingredienti;
	
	public ElencoRicette(ElencoIngredienti ingredienti)
	{
		ricette=new Vector<Ricette>();
		this.ingredienti=ingredienti;
	}
	
	public void aggiungi()
	{
		boolean continua=true;
		ArrayList<Ingredienti> ingredientiRicetta=new ArrayList<Ingredienti>();
		ArrayList<Double> quantita=new ArrayList<Double>();
		
		String nome=InputDati.leggiStringaNonVuota(NOME);
		
		do{
			String altroIngrediente=InputDati.leggiStringaNonVuota(INSERISCI_INGREDIENTE);
			if(ingredienti.trova(altroIngrediente))
			{
				ingredientiRicetta.add(ingredienti.getIngrediente(altroIngrediente));
				quantita.add(InputDati.leggiDoubleConMinimo(INSERISCI_QUANTITA, 0));
				continua=InputDati.yesOrNo(ALTRO_INGREDIENTE);
			}
			else System.out.println(NON_PRESENTE);
			
		}while(continua);
		
		int tipo=InputDati.leggiIntero(TIPO, 1, 2);
		ricette.add(new Ricette(nome,ingredientiRicetta,quantita,tipo));
	}
	
	public Vector<Ricette> getElenco()
	{
		return ricette;
	}
	
	public String toString()
	{
		StringBuffer msg=new StringBuffer();
		msg.append(TITOLO+"\n");
		for(Ricette lista: ricette)
			msg.append(lista.toString());
		return msg.toString();
	}

}
