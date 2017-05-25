package tamaZoo;
import java.util.*;

/**
 * La classe TamaZoo si compone di un Vector di Tamagotchi
 * Permette di inserire nuovi Tamagotchi, di specie diverse
 * Effettua un controllo per verificare che ci siano ancora sopravvissuti
 * Permette di effettuare azioni come dare biscotti o carezze
 * 
 * @author Ghidini Fabio
 * @author Mitelli Federico
 */
public class TamaZoo 
{
  private Vector<Tamagotchi> tama;
  
  /**
   * Inizializza la struttura dati che conterra' i Tamagotchi
   */
  
  public TamaZoo ()
  {
	  tama=new Vector<Tamagotchi>();
  }
  
  /**
   * Effettua l'inserimento di un nuovo Tamagotchi dentro la struttura
   *  
   * @param daInserire il tamagotchi da inserire nel vector TamaZoo
   */
  
  public void inserisci (Tamagotchi daInserire)
  {
	  tama.add(daInserire);
  }
  
  /**
   * Verifica se nello zoo ci sia ancora almeno un tamagotchi vivo
   * @return true (boolean)		almeno un tamagotchi vivo
   * @return false (boolean)	nessun tamagotchi vivo
   */
  
  public boolean ciSonoVivi ()
  {
	  for(Tamagotchi creature: tama)
		  if(!creature.sonoMorto()) return true;
	  return false;
  }
  
  /**
   * Effettua la somministrazione di biscotti solo ai tamagotchi vivi
   * Stampa la nuova situazione
   * 
   * @param quantiBiscotti	numero di biscotti da somministrare
   */
  
  public void daiBiscotti (int quantiBiscotti)
  {
	  for(Tamagotchi creature: tama)
		  if(!creature.sonoMorto())
		  {
			  creature.riceviBiscotti(quantiBiscotti);
			  System.out.println(creature.toString());
		  }
  }
  
  /**
   * Effettua la somministrazione di carezze ai tamagotchi vivi
   * Stampa la nuova situazione
   * 
   * @param quanteCarezze	numero di carezze da somministrare
   */
  
  public void daiCarezze (int quanteCarezze)
  {
	  // somministrare il numero di carezze specificato ai Tamagotchi presenti (la classe Tamagotchi offre un metodo utile a tale scopo)
		// ovviamente la somministrazione puo' avvenire solo per Tamagotchi vivi
	  // per ogni Tamagotchi si stampa la sua nuova situazione
	  for(Tamagotchi creature: tama)
		  if(!creature.sonoMorto())
		  {
			  creature.riceviCarezze(quanteCarezze);
			  System.out.println(creature.toString());
		  }
  }
  
    
}

