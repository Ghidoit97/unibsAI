package massaia;

public class Ingredienti {
	
	private final static String DESCRIZIONE="Ingrediente: %s %nCalorie per ettogrammo: %.2f%n";
	
	private String nome;
	private double calorie;
	
	public Ingredienti(String nome,double calorie)
	{
		this.nome=nome;
		this.calorie=calorie;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public double getCalorie()
	{
		return calorie;
	}
	
	public String toString()
	{
		return String.format(DESCRIZIONE,nome,calorie);
	}
}
