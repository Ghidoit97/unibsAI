package titoliAzionari;
import java.util.*;

public class Portafoglio {
	
	private String nome;
	private ElencoTitoli elenco;
	private Vector<Lotto> gruppo;
	
	public Portafoglio(String nome,ElencoTitoli elenco)
	{
		this.nome=nome;
		this.elenco=elenco;
		gruppo=new Vector<Lotto>();
	}
	
	public void inserisci(Lotto daInserire)
	{
		gruppo.add(daInserire);
	}
	
	public String toString()
	{
		return gruppo.toString();
	}
	
	public void variazione()
	{
		
		elenco.variazione();
	}
}
