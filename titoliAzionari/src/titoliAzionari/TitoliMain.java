package titoliAzionari;

import mylib.ServizioFile;
import mylib.InputDati;
import java.io.*;

public class TitoliMain implements Serializable{
	
	/**
	 * @author fabio ghidini
	 * @author federico mitelli
	 *
	 * Il programma titoli_azionari permette la gestione di:
	 * un elenco di titoli, per ognuno dei quali l'utente deve specificare il nome e il valore iniziale
	 * la composizione di un portafoglio, che consiste nello stabilire, per ciascun titolo in elenco, un numero di azioni acquistate
	 * la simulazione dell'oscillazione del valore del portafoglio: per ogni giornata il programma calcola il valore iniziale complessivo del
	    portafoglio, determina in modo random una variazione positiva o negativa del valore di ogni titolo, quindi calcola di conseguenza il
	    nuovo valore complessivo del portafoglio e comunica all'utente la situazione attuale del suo patrimonio
	 * permette inoltre di salvare su file tutte le informazioni introdotte e di poter riavviare successivamente il programma facendo
	   ripartire la simulazione dal punto nel quale era stata interrota.
	 *
	 * @param args the command line arguments
	 */
	
	final private static String NOMEFILETITOLI = "archiviotitoli.txt";
	final private static String MSG_NO_CAST = "ATTENZIONE PROBLEMI CON IL CAST";
	final private static String MSG_OK_FILE = "CARICAMENTO DA FILE EFFETTUATO";
	final private static String MSG_NO_FILE = "NON POSSO CARICARE DA FILE: ESEGUO CREAZIONE DA ZERO";
	final private static String MSG_INTRO_PORTFOLIO = "SITUAZIONE PORTAFOGLIO";
	final private static String MSG_PROCEDI = "PROCEDERE CON LA SIMULAZIONE ?";
	final private static String MSG_SALVA = "SALVATAGGIO DATI";
	final private static String MSG_SALUTO = "GRAZIE PER AVER USATO IL NOSTRO PROGRAMMA";
	final private static String MSG_INTRO_GIORNO = "GIORNO N.%d NUOVA SITUAZIONE INVESTIMENTI";
	
	public static void main(String[] args) {
		File fTitoli = new File(NOMEFILETITOLI);
		  
		Portafoglio patrimonio = null;
		  
		ElencoTitoli listaTitoli = null;
		  
		Contenitore container = null;
			
		boolean caricamentoRiuscito = false;
			
		if ( fTitoli.exists() )
		{
			try 
			{
				container = (Contenitore)ServizioFile.caricaSingoloOggetto(fTitoli);
				listaTitoli = container.getElencoTitoli();
				patrimonio = container.getPortafoglio();
			}
			catch (ClassCastException e)
			{
				System.out.println(MSG_NO_CAST);
			}
			finally
			{
				if ( (patrimonio != null) && (listaTitoli != null) )
				{
					System.out.println(MSG_OK_FILE);
					caricamentoRiuscito = true;
				}
			}	
		}
				
		if (!caricamentoRiuscito)
		{
			System.out.println(MSG_NO_FILE);
			listaTitoli = UtilitaTitoli.creaElencoTitolo();
			patrimonio = UtilitaTitoli.creaPatrimonio(listaTitoli);
		}
				
			 System.out.println(MSG_INTRO_PORTFOLIO);
			 System.out.println(patrimonio);
				
			 int giorni = 0;
			 while (InputDati.yesOrNo(MSG_PROCEDI))
				{
				 giorni++;
				 listaTitoli.variazione();
				 System.out.println(String.format(MSG_INTRO_GIORNO, giorni));
			 	 System.out.println(patrimonio);
				}
				
				System.out.println(MSG_SALVA);
				container = new Contenitore(listaTitoli,patrimonio);
			
				ServizioFile.salvaSingoloOggetto(fTitoli, container);
				
			    System.out.println(MSG_SALUTO);
	}
}
