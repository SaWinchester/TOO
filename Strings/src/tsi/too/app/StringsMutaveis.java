package tsi.too.app;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StringsMutaveis {

	public static void main(String[] args) {
		String saida = "", s1 = "String s1";
		StringBuffer stringBuffer = 
				new StringBuffer("A Trilogia do Cavalheiro das Trevas infelizmente terminou."),
				sB1 = new StringBuffer("StringBuffer sB1");
		
		// Cria uma �rea de texto para exibir a sa�da do programa na GUI.
		JTextArea areaTexto = new JTextArea(15, 80);
		
		// Cria uma barra de rolagem para a �rea de texto (JTextArea).
		JScrollPane barraRolagem = new JScrollPane(areaTexto);

		saida += "stringBuffer = " + stringBuffer + 
				        "\nsB1 = " + sB1 +
		                "\n\nAntes de tentarModificarArgumentoString() s1 = " + s1;
		tentarModificarArgumentoString(s1);
		saida += "\nDepois de tentarModificarArgumentoString() s1 = " + s1 +
                        "\n\nAntes de modificarArgumentoString() sB1 = " + sB1 + 
		                "\nCapacidade de sB1: " + sB1.capacity() + 
		                "\nTamanho de sB1: " + sB1.length();
		
		modificarArgumentoString(sB1);
		saida += "\n\nDepois de modificarArgumentoString() sB1 = " + sB1 + 
		                "\nCapacidade de sB1: " + sB1.capacity() + 
		                "\nTamanho de sB1: " + sB1.length();

		// Define novo tamanho do StringBuffer para 100.
		sB1.setLength(100);
		saida += "\n\nNovo tamanho de sB1: " + sB1.length() + 
		               "\nNova capacidade de sB1: " + sB1.capacity();

		/* O m�todo delete da classe StringBuffer apaga a substring
		 *  
		 * 							"ABCDEFGHIJKLMNOPQRSTUVWXYZ" 
		 * da string
		 * 							"ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
		 */
		sB1 = sB1.delete(0, sB1.indexOf("0"));
		
		saida += "\n\nsB1 o m�todo delete(0, sB1.indexOf(\"0\")  = " + sB1;
				
		// Define novo tamanho do StringBuffer para 15.
		sB1.setLength(15);
		saida += "\n\nsB1 com espa�os em branco = " + sB1 +
				
				        /* Converte o StringBuffer em String usando o toString e depois remove os
				         * espa�os em branco ap�s a string  "0123456789" usando o m�todo trim() da
				         * classe String.
				         */
				        "\nsB1 sem espa�os em branco = " + sB1.toString().trim() +
				        
		                "\nNovo tamanho de sB1: " + sB1.length() + 
	                    "\nNova capacidade de sB1: " + sB1.capacity() +
	                    
	                    "\n\nAcrescenta a string \"aeiou\" no StringBuffer sB1 = " + 
	                    sB1.append("aeiou") +
	                    
	                    "\n\nInsere a string \"JK&TK\" no StringBuffer sB1 na 1� posi��o depois do " + 
	                    sB1.indexOf("9") +  " = "  + sB1.insert(sB1.indexOf("9") + 1, "JK&TK");
		
		// Escreve a sa�da na �rea de texto.
		areaTexto.setText(saida);
		
		// Exibe a String saida centralizada no v�deo.
		showMessageDialog(null, barraRolagem, "M�todos da Classe StringBuffer", 
				INFORMATION_MESSAGE);
		
		// Finaliza o aplicativo Java GUI.
		System.exit(0);
	} // main()
	
	public static void tentarModificarArgumentoString(String arg) {
	    arg = "Novo objeto String.";
	}
	
	/* Substitui o conte�do do StringBuffer arg usando o m�todo replace da classe StringBuffer. 
	 * Este m�todo recebe 3 argumentos:
	 * 
	 * 1. a posi��o inicial (inclusive) na string (StringBuffer);
	 * 2. a posi��o final (exclusive) na string (StringBuffer);
	 * 3. a string que ser� usada para substituir o conte�do do StringBuffer. 
	 */
	public static void modificarArgumentoString(StringBuffer arg) {
		arg.replace(0, arg.length(), "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
	}
} // class StringsMutaveis 
