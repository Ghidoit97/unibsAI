package titoliAzionari;

import java.io.Serializable;

import mylib.InputDati;

public class UtilitaTitoli implements Serializable{
	
	 private final static String MSG_NOME_TITOLO = "INSERIRE LA DENOMINAZIONE DEL NUOVO TITOLO DA CREARE:";
	 private final static String MSG_PREZZO_TITOLO = "INSERIRE IL PREZZO INIZIALE DEL TITOLO %s:";
	 private final static String MSG_NUMERO_AZIONI = "INSERIRE IL NUMERO DI AZIONI ACQUISTATE DEL TITOLO %s:";
	 private final static String MSG_ALTRO_TITOLO = "INSERIRE UN ALTRO TITOLO IN ELENCO ?";
	 private final static String MSG_NOME_PORTFOLIO = "INSERIRE LA DENOMINAZIONE DEL PORTAFOGLIO CONSIDERATO:";
	 
	 public static Titolo creaTitolo()
	 {
		 String nome=InputDati.leggiStringaNonVuota(MSG_NOME_TITOLO);
		 double prezzo=InputDati.leggiDoubleConMinimo(String.format(MSG_PREZZO_TITOLO, nome), 0);
		 Titolo titolo=new Titolo(nome, prezzo);
		 return titolo;
	 }
	 
	 public static ElencoTitoli creaElencoTitolo()
	 {
		 ElencoTitoli listino=new ElencoTitoli();
		 
		 do{
			 Titolo t=creaTitolo();
			 listino.inserisci(t);
			 
		 }while(InputDati.yesOrNo(MSG_ALTRO_TITOLO));
		 
		 return listino;
	 }
	 
	 public static Portafoglio creaPortafoglio(String nome, ElencoTitoli listino)
	 {
		 Portafoglio wallet=new Portafoglio(nome,listino);
		 for(int i=0;i<listino.getNumTitoli();i++)
		 {
			 Titolo t=listino.getTitolo(i);
			 int numAzioni=InputDati.leggiInteroConMinimo(String.format(MSG_NUMERO_AZIONI,t.toString()), 1);
			 wallet.inserisci(new Lotto(t,numAzioni));
		 }
		 return wallet;
	 }
	 
	 public static Portafoglio creaPatrimonio(ElencoTitoli listino)
	 {
		 String nome=InputDati.leggiStringaNonVuota(MSG_NOME_PORTFOLIO);
		 return creaPortafoglio(nome,listino);
	 }
}
