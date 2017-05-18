package tamaZoo;
import mylib.*;

public class GestoreTamaZoo 
{

	// QUI SERVIRANNO UN PO' DI COSTANTI DI VARIO TIPO	
	private final static String BENVENUTO="Benvenuto nel mondo dei Tamagotchi!";
	private final static String RICHIEDI_NUMERO="Inserisci il numero di Tamagotchi che vuoi creare:";
	private final static String PREMESSA_INSERIMENTO="Inserimento del Tamagotchi numero ";
	private final static String INSER_NOME="Che nome vuoi dargli?";
	private final static String SCELTA="Inserisci il numero dell'azione che vuoi eseguire:";
	private final static String [] VOCI={"Dai carezze", "Dai biscotti"};
	private final static String MSG_CAREZZE="Verranno somministrati %d carezze ad ogni tamagotchi %n%n";
	private final static String MSG_BISCOTTI="Verranno somministrati %d biscotti ad ogni tamagotchi %n%n";
	private final static String ERRORE="Impossibile riconoscere l'operazione";
	private final static String ARRIVEDERCI="Torna presto nel nostro Zoo!";
	private final static String TUTTI_MORTI="Purtroppo i tuoi tamagotchi sono tutti morti -- Il programma termina";

	private final static int MIN_BISCOTTI=1;
	private final static int MAX_BISCOTTI=8;
	private final static int MIN_CAREZZE=1;
	private final static int MAX_CAREZZE=10;
	
	private final static int BASE=1;
	private final static int TRISTE=2;
	private final static int GORDO=3;
	private final static int NUM_SPECIE=3;
	
	private final static String MODELLO_BASE="modello base";
	private final static String TAMA_TRISTE="triste";
	private final static String TAMA_GORDO="ingordo";
	
	// DEFINIRE UN ATTRIBUTO static DI TIPO TamaZoo
	private static TamaZoo zoo=new TamaZoo();
		
	public static void main(String[] args) 
	{
		System.out.println(BENVENUTO);

		int numeroTamagotchi = InputDati.leggiInteroPositivo(RICHIEDI_NUMERO); // richiedere il numero all'utente
		
		for (int i =1; i<=numeroTamagotchi; i++)
		{
			// creare ad ogni iterazione un nuovo Tamagotchi (usando l'apposito metodo)
			// e inserirlo nello zoo (usando l'apposito metodo della classe TamaZoo)
			System.out.println(PREMESSA_INSERIMENTO + i);
			Tamagotchi nuovo=creaTamagotchi();
			zoo.inserisci(nuovo);
		}
		
		MyMenu principale= new MyMenu(SCELTA,VOCI);// creare un menu con le scelte a disposizione dell'utente
		
    boolean fine = false;
		
		do 
		{
		 int voceSelezionata = principale.scegli();
			
	     switch ( voceSelezionata ) 
	     {
			   // i casi da gestire sono la somministrazione 
				 // di biscotti e carezze. In entrambi i casi si estrae un numero casuale e 
				 // si invoca l'apposito metodo per la somministrazione nella classe TamaZoo
	      case 1:
	    	 int numCarezze=NumeriCasuali.estraiIntero(MIN_CAREZZE, MAX_CAREZZE);
	    	 System.out.printf(MSG_CAREZZE,numCarezze);
	    	 zoo.daiCarezze(numCarezze);
	    	 break;
	    	 
	      case 2:
	    	 int numBiscotti=NumeriCasuali.estraiIntero(MIN_BISCOTTI, MAX_BISCOTTI);
	    	 System.out.printf(MSG_BISCOTTI,numBiscotti);
	    	 zoo.daiBiscotti(numBiscotti);
	    	 break;
	     
	      case 0:
	    	 System.out.println(ARRIVEDERCI);
	    	 fine = true;
	    	 break;
	    	 
	      default:
				   // MESSAGGIO DI ERRORE
	    	 System.out.println(ERRORE);
	    	 break;
	    	 
	     }//switch
		 
	     
	     // controllare se nello zoo c'e' almeno un Tamagotchi vivo
			// in caso contrario bisogna terminare il programma
	     	if(!zoo.ciSonoVivi())
	    	 {
	    		 System.out.println(TUTTI_MORTI);
	    		 fine=false;
	    	 }
     
		} while ( !fine );
		 
		

	}

	public static Tamagotchi creaTamagotchi()
	{
		Tamagotchi nuovo=null;
		String nome = InputDati.leggiStringaNonVuota(INSER_NOME);// chiedere il nome all'utente
		int specie=NumeriCasuali.estraiIntero(1, NUM_SPECIE);
		int affetto = NumeriCasuali.estraiIntero(0,Tamagotchi.MAX_AFFETTO);// estrarre a caso il valore iniziale di affetto 
		int sazieta = NumeriCasuali.estraiIntero(0,Tamagotchi.MAX_SAZIETA);// estrarre a caso il valore iniziale di sazieta'
		// restituire un nuovo Tamagotchi
		switch(specie)
		{
		case BASE: 
			Tamagotchi base=new Tamagotchi(nome,affetto,sazieta,MODELLO_BASE);
			nuovo=base;
			break;
		case TRISTE: 
			Tamagotchi triste=new TamaTriste(nome,sazieta,TAMA_TRISTE);
			nuovo=triste;
			break;
		case GORDO: 
			Tamagotchi gordo=new TamaGordo(nome,sazieta,TAMA_GORDO);
			nuovo=gordo;
			break;
		}
		return nuovo;
	}
	
}

