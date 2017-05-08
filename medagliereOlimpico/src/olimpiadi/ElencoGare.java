package olimpiadi;

import java.util.Vector;

import mylib.MyMenu;

public class ElencoGare {
	/**
	 * elementi è un vector di tipo Gara ,è una lista di gare
	 */
	private Vector <Gara> elementi;
	
	public ElencoGare(){
		elementi=new Vector <Gara>();
	}
	
	/**
	 * Controlla se la lista non sia vuota e il nome della gara inserita non sia vuoto
	 * e inserisce la gara nel vector elementi
	 * @param g oggetto di tipo Gara inserita
	 */
	public void aggiungiGara(Gara g){
		if(!this.presente(g.getNome()) && !g.getNome().equals("")){
			elementi.add(g);
		}else{
			System.out.println("Gara gia' presente");
		}
	}
	/**
	 * Restituisce un array di String che contiene la lista dei nomi delle gare
	 * @return nomi array di String
	 */
	public String[] getNomi(){
		String nomi[]=new String[elementi.size()];
		int i=0;
		for(Gara value:elementi){
			nomi[i]=value.getNome();
			i++;
		}
		return nomi;
	}
	
	/**
	 * Controlla se nella lista esiste una gara con nome inserito come parametro
	 * @param gara nome della gara da trovare
	 * @return true se la gara è presente , false se non lo è
	 */
	public boolean presente(String gara){
		boolean trovato=false;
		for(Gara value:elementi){
			if(gara.equalsIgnoreCase(value.getNome())){
				trovato=true;
			}
		}
		return trovato;
	}
	
	/**Permette la scelta di una gara che verrà restituita come un oggetto di tipo Gara
	 * 
	 * @param domanda String domanda per la scelta della gara
	 * @return oggetto di tipo gara 
	 */
	public Gara scegliGara(String domanda){
		  String[] scelte=getNomi();
		  MyMenu menuScelte = new MyMenu (domanda, scelte);
		  int scelta = menuScelte.scegli();
		  if (scelta == 0)
			  return null;
		  else
			  return elementi.get(scelta-1);
	}
		
	/**Controlla se la lista elementi è vuota
	 * 
	 * @return true se è vuoto ,false se è presente almeno un elemento
	 */
	public boolean isEmpty(){
		return elementi.isEmpty();
		
	}
	
}
