package titoliAzionari;

import java.util.*;
import mylib.MyMenu;
import mylib.InputDati;

public class TitoliMain {

	private final static String BENVENUTO="PROGRAMMA TIOLI AZIONARI";
	private final static String SCELTA="Inserisci il numero dell'azione che vuoi eseguire: ";
	private final static String [] VOCI={"Visualizza portafoglio","Inserisci titolo","Visualizza variazione", "Visualizza valore totale"};
	private final static String INS_PORTAFOGLIO="Inserisci il nome del portafoglio: ";
	private final static String INS_NOME="Inserisci il nome tiolo: ";
	private final static String INS_PREZZO="Inserisci il valore della singola azione: ";
	private final static String INS_QUANTITA="Inserisci il umero di azioni: ";
	private final static String VARIAZIONE="In seguito alle variazioni il valore del portafoglio è il seguente: %.2f";
	private final static String VUOTO="Non esiste nessun titolo nel portafoglio";
	
	public static void main(String[] args) {
		System.out.println(BENVENUTO);
		
		MyMenu menu=new MyMenu(SCELTA,VOCI);
		int voceSelezionata=menu.scegli();
		switch(voceSelezionata)
		{
		case 1: 
			
		}
	}
	
}
