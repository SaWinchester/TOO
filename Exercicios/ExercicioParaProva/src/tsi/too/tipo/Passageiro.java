package tsi.too.tipo;

public class Passageiro {
	private String nome;

	public Passageiro(){}
	
	

	public Passageiro(String nome) {
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Passageiro: " + nome;
	}
	
	public double calculaTaxa(double taxa){
		return taxa;
	}
}
