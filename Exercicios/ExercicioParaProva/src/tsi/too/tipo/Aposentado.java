package tsi.too.tipo;

public class Aposentado extends Passageiro {
	private String rg;

	public Aposentado() {
		super();
	}

	public Aposentado(String nome, String rg) {
		super(nome);
		setRg(rg);
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return super.toString() + ", RG:" + rg+ ".";
	}

	@Override
	public double calculaTaxa(double taxa) {
		return 0;
	}
	
}
