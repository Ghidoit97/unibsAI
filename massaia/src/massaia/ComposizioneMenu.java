package massaia;

import java.util.*;

public class ComposizioneMenu {
	
	private final static String INTESTAZIONE="Menu con valore di calorie tollerabile: ";
	private final static String CALORIE_TOTALI_MENU="Calorie totali menu: %.2f %n";
	
	private double maxCalorie;
	private ElencoRicette ricettario;
	private int primo=1;
	private int secondo=2;
	
	public ComposizioneMenu(double maxCalorie,ElencoRicette ricettario)
	{
		this.maxCalorie=maxCalorie;
		this.ricettario=ricettario;
	}
	
	public String toString()
	{
		StringBuffer msg=new StringBuffer();
		msg.append(INTESTAZIONE + "\n");
		Vector<Ricette> ricette=ricettario.getElenco();
		for(Ricette lista: ricette)
		{
			if(lista.getTipo()==1)
			{
				for(Ricette elenco: ricette)
				{
					if(elenco.getTipo()==2)
						{
							double calorieMenu=elenco.getCalorieTotali()+lista.getCalorieTotali();
							if(calorieMenu<=maxCalorie){
								msg.append(lista.toString() + "\n");
								msg.append(elenco.toString() + "\n");
								msg.append(String.format(CALORIE_TOTALI_MENU,calorieMenu));
							}
						}
				}
			}
		}
		return msg.toString();
	}
	
}
