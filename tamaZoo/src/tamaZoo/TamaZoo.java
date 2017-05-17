package tamaZoo;
import java.util.*;

public class TamaZoo 
{
  // definire come attributo una struttura dati destinata a contenere i vari Tamagotchi presenti;
  private Vector<Tamagotchi> tama;
  
  public TamaZoo ()
  {
	  // inizializzare la struttura dati che conterra' i Tamagotchi
	  tama=new Vector<Tamagotchi>();
  }
  
  public void inserisci (Tamagotchi daInserire)
  {
	  // effettuare l'inserimento di un nuovo Tamagotchi entro la struttura 
	  tama.add(daInserire);
  }
  
  public boolean ciSonoVivi ()
  {
	  // verificare se nello zoo c'e' almeno un Tamagotchi vivo (la classe Tamagotchi offre un metodo utile a tale scopo)
	  for(Tamagotchi creature: tama)
		  if(!creature.sonoMorto()) return true;
	  return false;
  }
  
  public void daiBiscotti (int quantiBiscotti)
  {
	  // somministrare il numero di biscotti specificato ai Tamagotchi presenti (la classe Tamagotchi offre un metodo utile a tale scopo)
		// ovviamente la somministrazione puo' avvenire solo per Tamagotchi vivi
		// per ogni Tamagotchi si stampa la sua nuova situazione
	  for(Tamagotchi creature: tama)
		  if(!creature.sonoMorto())
		  {
			  creature.riceviBiscotti(quantiBiscotti);
			  System.out.println(creature.toString());
		  }
  }
  
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

