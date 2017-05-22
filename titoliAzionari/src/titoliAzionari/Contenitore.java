package titoliAzionari;

import java.io.Serializable;

public class Contenitore implements Serializable{
	
	private ElencoTitoli elencoTitoli;
	private Portafoglio portafoglio;
	
	public Contenitore(ElencoTitoli elencoTitoli, Portafoglio portafoglio)
	{
		this.elencoTitoli=elencoTitoli;
		this.portafoglio=portafoglio;
	}
	
	public ElencoTitoli getElencoTitoli()
	{
		return elencoTitoli;
	}
	
	public Portafoglio getPortafoglio()
	{
		return portafoglio;
	}

}
