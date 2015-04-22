package tsi.too.tipo;

public class Onibus {
	private final static int NUMERO_MAXIMO = 45;
	private String motorista;
	private Passageiro onibus[];
	private double taxa;
	private static int numPassageiro;
	
	public Onibus() {
		onibus = new Passageiro[NUMERO_MAXIMO];
		numPassageiro = 0;
	}

	public Onibus(String motorista) {
		this();
		setMotorista(motorista);
	}

	public Onibus(String motorista, double taxa) {
		this();
		setMotorista(motorista);
		setTaxa(taxa);
	}
	
	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public static int getNumeroMaximo() {
		return NUMERO_MAXIMO;
	}

	public static int getNumPassageiro() {
		return numPassageiro;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

	@Override
	public String toString() {
		return "Motorista: " + motorista;
	}
	
	public boolean adicionaPassageiro(Passageiro passageiro) {
		if(numPassageiro > NUMERO_MAXIMO) return false;
		onibus[numPassageiro++] = passageiro;
		return true;
	}
	
	public int pesquisaPassageiro(String nome) {
		for(int indice = 0; indice < numPassageiro;indice++)
			if(nome.equalsIgnoreCase(onibus[indice].getNome()))
				return indice;
		return -1;
	}
	
	public boolean excluirPassageiro(int indice){
		if(indice < 0 || indice > numPassageiro)
			return false;
		onibus[indice] = onibus[numPassageiro - 1];
		onibus[numPassageiro-1] = null;
		numPassageiro--;
		return true;
	}
	
	public Passageiro obterPassageiro(int indice){
		if(indice < 0 || indice > numPassageiro)
			return null;
		return onibus[indice];
	}
	
	public double calculaTotalArrecadado() {
		double valor = 0;
		for(int indice = 0;indice < numPassageiro;indice++)
			valor += onibus[indice].calculaTaxa(taxa);
		return valor;
	}
	
}
