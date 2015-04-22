package tsi.too.app;

import static javax.swing.JOptionPane.*;

public class StringsImutaveis {
	public static void main(String[] args) {
		String s1 = "Bom dia!", // s1 � iniciado com objeto an�nimo String ("Bom dia!")
		          s2 = new String("Bom dia!"), /* s2 � iniciado com novo objeto cujo valor � igual ao 
		                                                        objeto an�nimo String ("Bom dia!"). */ 
		          s3 = "Bom dia!", // s3 � iniciado com objeto an�nimo String ("Bom dia!").
		          s4 = "bom dia!", // s4 � iniciado com objeto an�nimo String ("bom dia!").
		          s5 = s1,
		       saida = "";
		
		// Comparando as refer�ncias s1 e s2.
		if (s1 == s2)
			saida = "s1 � igual a s2";
		else
			saida = "s1 n�o � igual a s2";
		
		// Comparando o conte�do dos objetos s1 e s2.
		if (s1.equalsIgnoreCase(s2))
			saida += "\ns1 � igual a s2";
		else
			saida += "\ns1 n�o � igual a s2";
		
		/* Comparando as refer�ncias s1 e s3. A linguagem Java compartilha as refer�ncias dos 
		 * objetos String an�nimos id�nticos. */
		if (s1 == s3)
			saida+= "\ns1 � igual a s3";
		else
			saida+= "\ns1 n�o � igual a s3";

		/* Comparando as refer�ncias s1 e s4. A linguagem Java compartilha as refer�ncias dos 
		 * objetos String an�nimos id�nticos. Os objetos String an�nimos s1 e s4 n�o s�o id�nticos,
		 * porque o valor literal das strings � diferente, portanto possuem refer�ncias diferentes. */
		if (s1 == s4)
			saida+= "\ns1 � igual a s4";
		else
			saida+= "\ns1 n�o � igual a s4";
		
		// Obt�m o c�digo hash das strings s1, s2, s3 e s4. 
		saida += "\n\nC�digo Hash de s1 (\"Bom dia!\") = " + s1.hashCode() +
        				"\nC�digo Hash de s2 (\"Bom dia!\") = " + s2.hashCode() +
        				"\nC�digo Hash de s3 (\"Bom dia!\") = " + s3.hashCode() +
		                "\nC�digo Hash de s4 (\"bom dia!\") = " + s4.hashCode();
		
		/* TENTANDO modificar o valor literal (objeto String) atrav�s da refer�ncia s1. Em Java, 
		 * os objetos String s�o IMUT�VEIS, portanto a instru��o abaixo n�o modifica o objeto 
		 * referenciado por s1 ("Bom dia!"), mas cria um novo objeto an�nimo ("Boa tarde!") e 
		 * coloca a refer�ncia deste em s1.  
		 */
		s1 = "Boa tarde!";
		
		if (s1 == "Boa tarde!")
			saida+= "\n\ns1 � igual a \"Boa tarde!\"";
		else
			saida+= "\n\ns1 n�o � igual a \"Boa tarde!\"";

		if (s1 == "boa tarde!")
			saida+= "\ns1 � igual a \"boa tarde!\"";
		else
			saida+= "\ns1 n�o � igual a \"boa tarde!\"";
		
		/* String literal em Java � um objeto, por isto � poss�vel invocar o m�todo equalsIgnoreCase 
		 * ou qualquer outro m�todo da classe String sobre o literal "Bom dia!".
		 */
		if ("Bom dia!".equalsIgnoreCase(s1))
			saida += "\ns1 � igual a \"Bom dia!\"";
		else
			saida += "\ns1 n�o � igual a \"Bom dia!\"";
		
		saida += "\ns3 = " + s3 + "\ns5 = " + s5;

		// Exibe a String saida centralizada no v�deo.
		showMessageDialog(null, saida, "Strings Imut�veis", INFORMATION_MESSAGE);
		
		// Finaliza o aplicativo Java GUI.
		System.exit(0);
	} // main()
} // class StringsImutaveis 
