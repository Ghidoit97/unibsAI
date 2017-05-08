package olimpiadi;

import mylib.*;
/**
 * 
 * @author federico mitelli @author fabio ghidini
 *
 */
public class MedagliereMain {
	/**
	 * Costanti String del Menu
	 */
	final static String TITOLO_PRINCIPALE="Menu Principale";
	final static String[] VOCI_PRINCIPALE={"Inserisci una nazione","Inserisci una gara","Inserisci un risultato di una gara",
											"Visualizza Medagliere","Visualizza Medagliere Ordinato"};
	
	/**
	 * Presenta un menu con 6 scelte che in base al valore digitato dall'utente esegue la funzione apposita
	 * -1 Richiede l'inserimento del nome della nazione da inserire e richiama il metodo {@link ElencoNazioni#aggiungiNazione(Nazione)}
	 * -2 Richiede l'inserimento del nome della gara da inserire e richiama il metodo {@link ElencoGare#aggiungiGara(Gara)}
	 * -3 Richiede di segliere una gara da modificare da un elenco , setta la gara come eseguita {@link Gara#setEseguita()}
	 *  chiede una nazione per ogni tipo di medaglia e richiama i metodi {@link Gara#aggiungiPremiata(Nazione)} e
	 *   {@link Nazione#aggiungiMedaglia(int)}
	 * -4 Richiama il metodo {@link ElencoNazioni#visualizzaMedagliere()} e visualizza il medagliere
	 * -5 Richiama il metodo {@link ElencoNazioni#visualizzaMedagliereOrdinato()()} e visualizza il medagliere 	ordinato
	 * @param args 
	 */
	public static void main(String[] args) {
		ElencoNazioni nazioni=new ElencoNazioni();
		ElencoGare gare=new ElencoGare();
		MyMenu menu= new MyMenu(TITOLO_PRINCIPALE, VOCI_PRINCIPALE);
		int scelta;
		do{
			scelta=menu.scegli();
			switch(scelta){
				case 1:String nome=InputDati.leggiStringa("Inserisci il nome della nazione");
					   Nazione n = new Nazione(nome);
					   nazioni.aggiungiNazione(n);
					   break;
					   
				case 2:String nomeGara=InputDati.leggiStringa("Inserisci il nome della gara");
					   Gara g=new Gara(nomeGara);
					   gare.aggiungiGara(g);
					   break;
				
				case 3:Gara ga=gare.scegliGara("Che gara modifichi?");
					   ga.setEseguita();
					   Nazione oro=nazioni.scegliNazione("Che nazione ha vinto l'oro?");
					   ga.aggiungiPremiata(oro);
					   oro.aggiungiMedaglia(0);
					   Nazione argento=nazioni.scegliNazione("Che nazione ha vinto l'argento?");
					   ga.aggiungiPremiata(argento);
					   oro.aggiungiMedaglia(1);
					   Nazione bronzo=nazioni.scegliNazione("Che nazione ha vinto il bronzo?");
					   ga.aggiungiPremiata(bronzo);
					   oro.aggiungiMedaglia(2);
					   break;
					   
				case 4:nazioni.visualizzaMedagliere();
					   break;
					   
				case 5:nazioni.visualizzaMedagliereOrdinato();
					   break;
				
				case 0:System.out.println("Uscita");
				       break;
				       

				
				       
			}
		}while(scelta!=0);

	}

}
