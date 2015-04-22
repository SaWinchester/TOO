package tsi.too.app;

import static javax.swing.JOptionPane.*;

import java.util.StringTokenizer;

public class Tokens {

	public static void main(String[] args) {
		String frase;
		
		// L� a frase que ser� usada para obter os tokens (palavras e s�mbolos).
		frase = showInputDialog(null, "Frase:", "Tokens", QUESTION_MESSAGE);
		
		// Verifica se o usu�rio clicou no bot�o Cancelar. 
		if (frase == null) System.exit(0);
		
		showMessageDialog(null, obterTokens(frase, ", ;."), "Tokens", INFORMATION_MESSAGE);
		
		// Finaliza o aplicativo Java GUI.
		System.exit(0);
	} // main()
	
	// Obt�m e retorna os tokens (palavras e s�mbolos) do par�metro frase.
	private static String obterTokens(String frase, String separador) {
		StringTokenizer  tokens = new StringTokenizer(frase, separador);
		String saida = "N�mero de Tokens: " + tokens.countTokens() + "\n\n";
		
		// Obt�m todo os tokens da string frase.
		while (tokens.hasMoreTokens())
			saida += tokens.nextToken() + "\n";
		
		return saida;
	} // obterTokens()
} // class Tokens
