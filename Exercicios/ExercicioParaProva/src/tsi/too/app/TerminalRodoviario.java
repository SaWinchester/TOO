package tsi.too.app;

import tsi.too.tipo.Onibus;
import static javax.swing.JOptionPane.*;
/*
 * Teste as classes implementadas fazendo um menu com as seguintes opções:
 Cadastrar nome do motorista;
 Cadastrar valor da passagem;
 Cadastrar passageiro;
 Mostrar todos passageiros;
 Mostrar total arrecadado;
 Sair.
 */
public class TerminalRodoviario {
	private static Onibus onibus = new Onibus();
	public static void main(String[] args) {
		menu();
	}
	private static void menu() {
		String opcoes[] = {"Cadastrar Motorista", "Cadastrar Taxa",
				"Cadastrar Passageiro","Consultar","Excluir","Relatorio","Total Arrecadado", "Sair"};
		int opcao;
		do {
			opcao = showOptionDialog(null, "Escolha a opção: ", "Terminal Rodoviario", DEFAULT_OPTION, 
					QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			
		} while (opcao != CLOSED_OPTION && opcao != opcoes.length - 1);
	}

}
