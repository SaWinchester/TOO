package tsi.too.tipo;

public class Estudante extends Passageiro {
	private String ra;

	public Estudante() {
		super();
	}

	public Estudante(String nome, String ra) {
		super(nome);
		setRa(ra);
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	@Override
	public String toString() {
		return super.toString() + ", Registro Acadêmico: " + ra + ".";
	}

	@Override
	public double calculaTaxa(double taxa) {
		return taxa/2;
	}
	
}
