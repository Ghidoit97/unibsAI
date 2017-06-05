package titoliAzionari;

import java.io.Serializable;

import mylib.InputDati;

/**
 * La classe UtilitaTitoli permette di organizzare correttamente
 * le relazioni tra le varie classi che andranno a comporre il 
 * Portafoglio, per una corretta interazione con l'utente.
 * @author fabio ghidini
 * @author federico mitelli
 *
 */

public class UtilitaTitoli implements Serializable{
	
	 private final static String MSG_NOME_TITOLO = "INSERIRE LA DENOMINAZIONE DEL NUOVO TITOLO DA CREARE:";
	 private final static String MSG_PREZZO_TITOLO = "INSERIRE IL PREZZO INIZIALE DEL TITOLO %s:";
	 private final static String MSG_NUMERO_AZIONI = "INSERIRE IL NUMERO DI AZIONI ACQUISTATE DEL TITOLO %s:";
	 private final static String MSG_ALTRO_TITOLO = "INSERIRE UN ALTRO TITOLO IN ELENCO ?";
	 private final static String MSG_NOME_PORTFOLIO = "INSERIRE LA DENOMINAZIONE DEL PORTAFOGLIO CONSIDERATO:";
	 
	 /**
	  * Crea e ritorna un nuovo oggetto di tipo Titolo ricevendo da tastiera
	  * valore e nome.
	  * @return titolo (Titolo)		nuovo titolo creato
	  */
	 
	 public static Titolo creaTitolo()
	 {
		 String nome=InputDati.leggiStringaNonVuota(MSG_NOME_TITOLO);
		 double prezzo=InputDati.leggiDoubleConMinimo(String.format(MSG_PREZZO_TITOLO, nome), 0);
		 Titolo titolo=new Titolo(nome, prezzo);
		 return titolo;
	 }
	 
	 /**
	  * Crea e ritorna un nuovo oggetto di tipo ElencoTitoli
	  * utitlizzando la funzione di inserimento di nuovi titoli
	  * finchè l'utente decide di inserirne.
	  * @return listino (ElencoTitoli)	nuovo elenco titoli creato
	  */
	 
	 public static ElencoTitoli creaElencoTitolo()
	 {
		 ElencoTitoli listino=new ElencoTitoli();
		 
		 do{
			 Titolo t=creaTitolo();
			 listino.inserisci(t);
			 
		 }while(InputDati.yesOrNo(MSG_ALTRO_TITOLO));
		 
		 return listino;
	 }
	 
	 /**
	  * Crea e ritorna un nuovo oggetto di tipo Portafoglio,
	  * richiede in entrata un nome e un listino per poi richiedere
	  * all'utente il numero di azioni di ogni titolo inserito 
	  * aggiungendoli al lotto e ritornando così il Portafoglio.
	  * @param nome		(String)	nome del Portafoglio
	  * @param listino	(ElencoTitoli)	elenco titoli di riferimento
	  * @return	wallet 	(Portafoglio)	oggetto di tipo Portafoglio
	  */
	 
	 public static Portafoglio creaPortafoglio(String nome, ElencoTitoli listino)
	 {
		 Portafoglio wallet=new Portafoglio(nome,listino);
		 for(int i=0;i<listino.getNumTitoli();i++)
		 {
			 Titolo t=listino.getTitolo(i);
			 int numAzioni=InputDati.leggiInteroConMinimo(String.format(MSG_NUMERO_AZIONI,t.toString()), 1);
			 wallet.addLotto(new Lotto(t,numAzioni));
		 }
		 return wallet;
	 }
	 
	 /**
	  * Richiede in entrata un listino (elencoTitoli) di riferimento,
	  * al quale viene relazionato un nome richiesto a tastiera;
	  * infine richiama l'altro metodo creaPortafoglio
	  * @param listino	(ElencoTitoli)	listino di riferimento
	  * @return creaPortafoglio (Portafoglio)	richiama il metodo organizzato per nome e listino
	  */
	 
	 public static Portafoglio creaPatrimonio(ElencoTitoli listino)
	 {
		 String nome=InputDati.leggiStringaNonVuota(MSG_NOME_PORTFOLIO);
		 return creaPortafoglio(nome,listino);
	 }
}
