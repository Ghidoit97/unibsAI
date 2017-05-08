package olimpiadi;
import mylib.*;

public class Medaglie {
	public static final int NUM_MEDAGLIE = 3;
	 public static final String [] NOMIMEDAGLIE = {"ORO", "ARGENTO", "BRONZO"};
		
	 public final static int LARGH_PRIMA_COL=12;
	 public final static int LARGH_COL_MEDAGLIA=9;
		
	 public static String intestazione() 
		{
		 StringBuffer msg = new StringBuffer();
		 msg.append(BelleStringhe.incolonna("", LARGH_PRIMA_COL));
		 for (int i=0; i < NOMIMEDAGLIE.length; i++){
			msg.append(BelleStringhe.centrata(NOMIMEDAGLIE[i],LARGH_COL_MEDAGLIA));
		 }
		 
		 return msg.toString();
		}
}
