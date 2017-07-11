package massaia;

import mylib.InputDati;
import mylib.MyMenu;

public class MassaiaMain {

	private final static String BENVENUTO="Benvenuto nel programma per massaie!";
	private final static String TITOLO="PROGRAMMA PER MASSAIE";
	private final static String [] VOCI={"Aggiungi ingredienti","Visualizza elenco ingredienti","Aggiungi ricetta","Visualizza elenco ricette","Visualizza menu con valore di calorie tollerabile"};
	private final static String MAX_CALORIE="Inserisci valore massimo di calorie per il menu: ";
	private final static String ARRIVEDERCI="Il programma è terminato, arrivederci!";
	private final static String ERRATO="Valore immesso errato, riprovare. ";
	
	public static void main(String[] args) {

		ElencoIngredienti ingredienti=new ElencoIngredienti();
		ElencoRicette ricette=new ElencoRicette(ingredienti);
		ComposizioneMenu composizione;
		
		System.out.println(BENVENUTO);
		
		MyMenu principale=new MyMenu(TITOLO,VOCI);
		
		boolean continua=true;
		
		do{
			int voceSelezionata=principale.scegli();
			switch(voceSelezionata)
			{
			case 0:
				System.out.println(ARRIVEDERCI);
				continua=false;
				break;
			case 1:
				ingredienti.aggiungi();
				break;
			case 2:
				System.out.println(ingredienti.toString());
				break;
			case 3:
				ricette.aggiungi();
				break;
			case 4:
				System.out.println(ricette.toString());
				break;
			case 5:
				double maxCalorie=InputDati.leggiDoubleConMinimo(MAX_CALORIE, 0);
				composizione=new ComposizioneMenu(maxCalorie,ricette);
				System.out.println(composizione.toString());
				break;
			default:
				break;
			}
		}while(continua);
	}

}
