package olimpiadi;
import mylib.*;
import java.util.Vector;

/**Descrive un oggetto di tipo ElencoNazioni :
 * 
 * 
 * @author federico mitelli @author fabio ghidini
 *
 */
public class ElencoNazioni {
	private final static String MSG_MEDAGLIERE="Medagliere Olimpico",
								MSG_MEDAGLIERE_ORDINATO="Medagliere Olimpico Ordinato",
								MSG_VUOTO="Attenzione medaglie non presenti";
	/**
	 * elementi Vector di oggetti di tipo Nazione 
	 */
	private Vector <Nazione> elementi;
	
	public ElencoNazioni(){
		elementi=new Vector <Nazione>();
	}
	
	/**
	 * Restituisce un elenco di nomi delle nazioni
	 * @return nomi array di String 
	 */
	public String[] getNomi(){
		String[] nomi=new String[elementi.size()];
		int i=0;
		for(Nazione value: elementi){
			nomi[i]=value.getNome();
			i++;
		}
		return nomi;
	}
	
	/**
	 * Controlla se una nazione è presente in elementi
	 * attraverso il nome
	 * @param nome nome della nazione da ricercare
	 * @return trovato boolean , se nazione trovata allora true ,altrimenti false
	 */
	public boolean presente(String nome){
		boolean trovato=false;
		for(Nazione value: elementi){
			if(nome.equalsIgnoreCase(value.getNome())){
				trovato=true;
			}
		}
		return trovato;
	}
	
	/**
	 * Controlla se la nazione è gia presente nel Vector elementi e 
	 * se non lo è la inserisce alla fine di elementi
	 * @param n oggetto di tipo Nazione che verrà inserito nel vector
	 */
	public void aggiungiNazione(Nazione n){
		if(this.presente(n.getNome())){
			System.out.println("Nazione gia presente nell'elenco");
		}else{
			elementi.add(n);
		}
	}
	
	/**Controlla se l'elenco non è vuoto e 
	 * Stampa l'elenco di tutte le nazioni e il relativo numero di medaglie per tipo
	 */
	public void visualizzaMedagliere(){
		if(this.isEmpty()){
			System.out.println(MSG_VUOTO);
		}else{
			System.out.println(BelleStringhe.incornicia(MSG_MEDAGLIERE));
			System.out.println(Medaglie.intestazione());
			for(Nazione value: elementi){
				System.out.println(value.toString());
			}
		}
		
	}
	/**Controlla se l'elenco è vuoto , se non lo è stampa 
	 * l'elenco di tutte le nazioni e le relative medaglie per tipo ordinandolo
	 * per tipo e numero di medaglie
	 * 
	 */
	public void visualizzaMedagliereOrdinato(){
		if(this.isEmpty()){
			System.out.println(MSG_VUOTO);
		}
		else{
			Vector <Nazione> med=elementi;
			int i,j;
			Nazione x;
			for(i=0;i<med.size()-1;i++){
				for(j=med.size()-1;j>i;j--){
					if(med.get(j-1).getMedaglie(0)<med.get(j).getMedaglie(0)){
						x=med.get(j-1);
						med.set(j-1,med.get(j));
						med.set(j, x);
					}else if(med.get(j-1).getMedaglie(1)<med.get(j).getMedaglie(1)){
						x=med.get(j-1);
						med.set(j-1,med.get(j));
						med.set(j, x);
					}else if(med.get(j-1).getMedaglie(2)<med.get(j).getMedaglie(2)){
						x=med.get(j-1);
						med.set(j-1,med.get(j));
						med.set(j, x);
					}
				}
			}
			System.out.println(Medaglie.intestazione());
			for(Nazione val: med){
				System.out.println(val);
				
			}
		}
	}
	
	/**
	 * Restituisce un oggetto di tipo nazione
	 * @param domanda 
	 * @return Nazione 
	 */
	public Nazione scegliNazione(String domanda){

		  String [] scelte = getNomi();
		  MyMenu menuScelte = new MyMenu (domanda, scelte);
		  int scelta = menuScelte.scegli();
		  if (scelta == 0)
			  return null;
		  else
			  return elementi.get(scelta-1);
	}
	
	/**Controlla se la lista elementi è vuota
	 * 
	 * @return true se è vuoto false se è presente almeno un elemento
	 */
	public boolean isEmpty()
	{
		return elementi.isEmpty();
	}
	
}
