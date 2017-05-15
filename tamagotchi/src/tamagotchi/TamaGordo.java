package tamagotchi;

public class TamaGordo extends Tamagotchi{
	
	public TamaGordo(String _nome, double _sodd, double _sazieta) {
		super(_nome, _sodd, _sazieta);
		_sodd=100;
	}
	
	public void riceviCarezze(double nCarezze){
		super.sazieta-=(nCarezze/2);
		if(sazieta<MIN_SAZIETA) sazieta=MIN_SAZIETA;
		
	}

}
