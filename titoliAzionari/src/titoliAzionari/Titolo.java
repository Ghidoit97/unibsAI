package titoliAzionari;

public class Titolo {
	
	private String nome;
	private double valore;
	
	public Titolo(String _nome, double _valore){
		nome=_nome;
		valore=_valore;
	}
	
	public void modificaValore(double nuovoValore){
		valore=nuovoValore;
	}
	
	public String toString(){
		return "Nome Titolo: "+nome+"\tValore:"+valore;
	}
}
