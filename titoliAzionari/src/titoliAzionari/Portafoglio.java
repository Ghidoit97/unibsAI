package titoliAzionari;
import java.util.*;

public class Portafoglio {
	
	private final static String DESCR_DENOMINAZIONE="Denominazione portafoglio: %s %n";
	private final static String INTROD_COMPOSIZIONE="Composizione: \n";
	private final static String DESCR_TOTALE="Valore totale: %1.2f";
	
	private String denominazione;
	private ElencoTitoli listaTitoli;
	
	private Vector<LottoPosseduto> composizione;
	
	public Portafoglio(String _denominazione, ElencoTitoli _listaTitoli){
		denominazione=_denominazione;
		listaTitoli=_listaTitoli;
		composizione=new Vector<LottoPosseduto>();
	}
	
	public void addLotto(LottoPosseduto lotto){
		composizione.add(lotto);
	}
	
	 public double valore()
		{
		 // da completare per effettuare simulazione
		}
	 
	public String toString(){
		
		StringBuffer msg=new StringBuffer();
		msg.append(String.format(DESCR_DENOMINAZIONE, denominazione));
		msg.append(INTROD_COMPOSIZIONE);
		
		for(int i=0; i<composizione.size(); i++)
		{
			msg.append(composizione.get(i).toString() + "\n");
		}
		
		msg.append(String.format(DESCR_TOTALE, valore()));
		
		return msg.toString();
	
	}
}
