package olimpiadi;

import java.lang.invoke.CallSite;
import java.lang.reflect.Array;

import mylib.BelleStringhe;
/**Descrive un oggetto di tipo Nazione
 * 
 * @author federico mitelli @author fabio ghidini
 *
 */
public class Nazione {
	
	public final static int LARGH_PRIMA_COL=12,
							LARGH_COL_MEDAGLIA=9;
	private static final int ORO=0,ARGENTO=1,BRONZO=2;
	
	/**
	 * nome Nome della nazione
	 * contaMedaglie vettore di tre elementi che immagazzina il numero di medaglie per tipo
	 * 				contaMedaglie[0] medaglie oro
	 * 				contaMedaglie[1] medaglie argento
	 * 				contaMedaglie[2] medaglie bronzo
	 */
	private String nome;
	private int[] contaMedaglie=new int[3];
	
	
	public Nazione(String _nome){
		
		nome=_nome;
	}
	
	/**Incrementa il contatore delle medaglie in base al 
	 * tipo di medaglia inserito
	 * 
	 * @param tipoMedaglia tipo di medaglia
	 */
	public void aggiungiMedaglia(int tipoMedaglia){
		if(tipoMedaglia==0){
			contaMedaglie[ORO]++;
		}else if(tipoMedaglia==1){
			contaMedaglie[ARGENTO]++;
		}else if(tipoMedaglia==2){
			contaMedaglie[BRONZO]++;
		}
	}
	
	/**Restituisce il numero di medaglie in base al tipo di medaglia inserito
	 * 
	 * @param tipo tipo di medaglia
	 * @return numero di medaglie o -1 se non sono presenti medaglie
	 */
	public int getMedaglie(int tipo){
		if(tipo==ORO){
			return contaMedaglie[ORO];
		}else if(tipo==ARGENTO){
			return contaMedaglie[ARGENTO];
		}else if(tipo==BRONZO){
			return contaMedaglie[BRONZO];
		}else{
			return -1;
		}
	}
	
	/**
	 * Restituisce il nome della nazione
	 * @return nome 
	 */
	public String getNome(){
		return nome;
	}
	
	/**
	 * Restituisce il nome e il numero di medaglie per tipo in una
	 * formattazione di tipo tabellare
	 */
	public String toString() throws RuntimeException{
		StringBuffer msg=new StringBuffer();
		String oro,argento,bronzo;
		
			oro=String.valueOf(contaMedaglie[ORO]);
			argento=String.valueOf(contaMedaglie[ARGENTO]);
			bronzo=String.valueOf(contaMedaglie[BRONZO]);
		
		msg.append(BelleStringhe.incolonna(getNome(), LARGH_PRIMA_COL));
		msg.append(BelleStringhe.centrata(oro,LARGH_COL_MEDAGLIA));
		msg.append(BelleStringhe.centrata(argento,LARGH_COL_MEDAGLIA));
		msg.append(BelleStringhe.centrata(bronzo,LARGH_COL_MEDAGLIA));
		
		return msg.toString();
	}
	
}
