package titoliAzionari;

public class Contenitore {
	
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
