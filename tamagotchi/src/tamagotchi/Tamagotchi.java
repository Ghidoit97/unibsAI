package tamagotchi;
import mylib.*;
/**
 * La classe Tamagotchi descrive un oggetto di tipo Tamagotchi , 
 * un entit� software che � in grado di recepire stimoli esterni ,
 * i quali determinano la sua sopravvivenza e il suo grado di benessere .
 * La classe modifica questi valori in base agli input dell'utente e
 * stabilisce se il tamagotchi � felice , triste o morto.
 * @author Federico Mitelli
 * @author Fabio Ghidini
 */

public class Tamagotchi {
	public final static double MAX_SAZIETA=100,
							   MIN_SAZIETA=0,
							   MAX_SODD=100,
							   MIN_SODD=0,
							   SOGLIA_SODD_BASSA=30,
							   SOGLIA_SAZ_BASSA=30,
							   SOGLIA_SAZ_ALTA=90;
	
	private final static String DESCRIZIONE="Ciao ,sono %s%nIl mio grado di sazieta' : %1.2f%nIl mio grado di soddisfazione affettiva : %1.2f%n",
								MESS_MORTO="Sono morto",
								MESS_INFELICE="Sono infelice",
								MESS_FELICE="Sono felice";
	/**
	 * Attributi :
	 * -{@link nome}			nome del tamagotchi 	
	 * -{@link soddisfazione}	livello di soddisfazione del tamagotchi
	 * -{@link sazieta}			livello di saziet� del tamagotchi
	 * 
	 */
	private String nome;
	private double soddisfazione,sazieta;
	
	/**
	 * Inizializza i valori iniziali degli attributi 
	 * @param _nome 		nome del tamagotchi
	 * @param _sodd			grado iniziale di soddisfazione
	 * @param _sazieta		grado iniziale di saziet�
	 */
	public Tamagotchi(String _nome,double _sodd,double _sazieta){
		nome=_nome;
		soddisfazione=_sodd;
		sazieta=_sazieta;
		
	}
	/**
	 * Inizializza i valori iniziali degli attributi 
	 * In questi caso i valori di  soddisfazione e di sazieta
	 * vengono generati dal metodo {@link mylib.NumeriCasuali#estraiDouble(double, double)} 
	 * in modo che i valori siano compresi nella soglia di benessere.
	 * @param _nome		nome del tamagotchi
	 */
	public Tamagotchi(String _nome){
		nome=_nome;
		soddisfazione=NumeriCasuali.estraiDouble(SOGLIA_SODD_BASSA, MAX_SODD);
		sazieta=NumeriCasuali.estraiDouble(SOGLIA_SAZ_BASSA, SOGLIA_SAZ_ALTA);
	}
	
	/**
	 * Controlla se la soddisfazione � tra i parametri vitali del tamagotchi
	 * se s� , somma il numero di carezze ricevute alla soddisfazione.
	 * Se dopo aver sommato la soddisfazione supera il livello massimo di soddisfazione(MAX_SODD)
	 * la riporta al livello massimo, mentre se � minore del livello minimo di soddisfazione(MIN_SODD)
	 * la riporta la livello minimo.
	 * Sottrae al livello di saziet� la meta delle carezze ricevute.
	 * Controlla se il livello di saziet� � sceso sotto il livello minimo di saziet�(MIN_SODD),
	 * se � cos� lo riporta al livello minimo di saziet�
	 * 
	 * @param nCarezze numero di carezze ricevute
	 */
	public void riceviCarezze(double nCarezze){
		if(soddisfazione<MAX_SODD && soddisfazione>MIN_SODD){
			soddisfazione+=nCarezze;
			if(soddisfazione>MAX_SODD) 
				soddisfazione=MAX_SODD;
			else if(soddisfazione<MIN_SODD) 
				soddisfazione=MIN_SODD;
			
		}
		
		sazieta-=(nCarezze/2);
		if(sazieta<MIN_SAZIETA) sazieta=MIN_SAZIETA;
		
		
	}
	
	/**
	 * Controlla se il grado  di saziet� � minore del livello massimo di saziet�(MAX_SAZIETA).
	 * Se vero per ogni biscotto ricevuto il grado di saziet� aumenta del 10% .
	 * Controlla se il grado di saziet� � maggiore del livello massimo di saziet� .
	 * Se vero riporta il grado di saziet� al livello massimo di saziet� .
	 * Sottrae al grado di soddisfazione un quarto del numero di biscotti ricevuti e
	 * controlla se il grado di soddisfazione � minore del livello minimo di soddisfazione(MIN_SODD)
	 * se  vero la riporta la livello minimo.
	 * 
	 * @param nBiscotti numero di biscotti ricevuti
	 */
	public void riceviBiscotti(double nBiscotti){
		if(sazieta<MAX_SAZIETA){
			
			for(int i=0 ;i<nBiscotti;i++)
				sazieta+=sazieta*0.1;
			
			
			if(sazieta>MAX_SAZIETA)
				sazieta=MAX_SAZIETA;
			
		}
		
		soddisfazione-=(nBiscotti/4);
		if(soddisfazione<MIN_SODD)
			soddisfazione=MIN_SODD;
		
	}
	
	/**
	 * Controlla se il tamagotchi � triste.
	 * Se la soddisfazione � maggiore della soglia bassa di soddisfazione e la sazieta � compresa 
	 * tra i valori di saziet� che assicurano benessere allora
	 * @return false
	 * invece se il controllo � stato negativo 
	 * @return true
	 */
	public boolean sonoTriste(){
		if(soddisfazione>SOGLIA_SODD_BASSA && (sazieta>SOGLIA_SAZ_BASSA && sazieta<SOGLIA_SAZ_ALTA)){
			return false;
		}else return true;
	}
	
	/**
	 * Controlla se i valori di :
	 * saziet� , se corrispondono al suo massimo o al suo minimo 
	 * o
	 * soddisfazione , se corrisponde al suo minimo
	 * se vero
	 * @return true
	 * se falso 
	 * @return false
	 */
	public boolean sonoMorto(){
		if(sazieta==MIN_SAZIETA || sazieta==MAX_SAZIETA || soddisfazione==MIN_SODD){
			return true;
		}else return false;
	}
	
	/**
	 * Crea un messaggio di tipo String che contiene gli attributi del tamagotchi e 
	 * i loro valori e controlla se � morto {@link #sonoMorto()} , o se
	 * � triste {@link #sonoTriste()} ed in ogni caso genera un messaggio adeguato
	 * allo stato del tamagotchi.
	 * 
	 * @return msg.toString() messaggio che descrive il tamagotchi
	 */
	public String toString(){
		StringBuffer msg=new StringBuffer();
		msg.append(String.format(DESCRIZIONE, nome,sazieta,soddisfazione));
		
	    if(sonoMorto()){
			msg.append(String.format("%n%s", MESS_MORTO));
		}else{
			if(sonoTriste()==true){
				msg.append(String.format("%n%s", MESS_INFELICE));
			}
			else msg.append(String.format("%n%s", MESS_FELICE));
		}
	    return msg.toString();
	}

}
