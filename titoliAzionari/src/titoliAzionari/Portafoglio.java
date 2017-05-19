package titoliAzionari;
import java.util.*;

public class Portafoglio {
	
	private String nome;
	private ElencoTitoli elenco;
	private Vector<Lotto> lotto;
	
	public Portafoglio(String nome,ElencoTitoli elenco)
	{
		this.nome=nome;
		this.elenco=elenco;
		lotto=new Vector<Lotto>();
	}
	
	public void inserisci(Lotto daInserire)
	{
		lotto.add(daInserire);
	}
	
	public String toString()
	{
		StringBuffer msg=new StringBuffer();
		for(Lotto gruppo: lotto)
			msg.append(gruppo.toString());
		return msg.toString();
	}
	
	public void variazione()
	{
		
		elenco.variazione();
	}
}
