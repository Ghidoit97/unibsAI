package titoliAzionari;
import java.util.*;

public class Portafoglio {
	
	private final String DESCRIZIONE="Portafoglio <%s>:%n";
	
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
		msg.append(String.format(DESCRIZIONE,nome));
		for(Lotto gruppo: lotto)
			msg.append(gruppo.toString());
		return msg.toString();
	}
	
	public void variazione()
	{
		elenco.variazione();
	}
	
	public double valoreTotale()
	{
		double value=0;
		for(int i=0;i<lotto.size();i++)
		{
			value=value+lotto.get(i).getValore();
		}
		return value;
	}
}