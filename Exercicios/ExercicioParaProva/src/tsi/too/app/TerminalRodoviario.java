package tsi.too.app;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import tsi.too.tipo.Aposentado;
import tsi.too.tipo.Estudante;
import tsi.too.tipo.Onibus;
import tsi.too.tipo.Passageiro;
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
	private static Onibus onibus;
	
	public TerminalRodoviario() {
		onibus = new Onibus("SAW",3.45);
	}

	public static void main(String[] args) {
		
		new TerminalRodoviario().menu();
	}//main
	
	private void menu() {
		String opcoes[] = {	"Cadastrar Passageiro","Consultar","Excluir","Relatorio","Total Arrecadado", "Sair"};
		int opcao;
		do {
			opcao = showOptionDialog(null, "Escolha a opção: ", "Terminal Rodoviario", DEFAULT_OPTION, 
					QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			switch (opcao) {
			case 0:cadastrar();break;
			case 1:consultar();	break;
			case 2:excluir();   break;
			case 3:relatorio();	break;
			case 4:totalArrecadado();	break;
			}
		} while (opcao != CLOSED_OPTION && opcao != opcoes.length - 1);
	}//menu
	
	private static void cadastrar() {
		String opcoes[] = {	"Estudante","Aposentado","Passageiro normal","Sair"};
		int opcao;
		do {
			opcao = showOptionDialog(null, "Escolha a opção: ", "Terminal Rodoviario", DEFAULT_OPTION, 
					QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			switch (opcao) {
			case 0:cadastrarEstudante();break;
			case 1:cadastrarAposentado();	break;
			case 2:cadastrarPassageiroNormal();   break;
			
			}
		} while (opcao != CLOSED_OPTION && opcao != opcoes.length - 1);
	}//cadastrar
	
	private static void cadastrarPassageiroNormal() {
		Passageiro passageiro = new Passageiro();
		if(!cadastrarPassageiro(passageiro)) return;
		if(onibus.adicionaPassageiro(passageiro))
			msgInfo("Passageiro cadastrado.","Cadastra Passageiro Normal");
		else
			msgErro("Onibus lotado.","Cadatra Passageiro Normal.");
	}

	private static void cadastrarEstudante() {
		Passageiro passageiro = new Estudante();
		if(!cadastrarPassageiro(passageiro)) return;
		
		String ra;
		ra = lerString("Forneça o RA do " + passageiro.getNome(), "Cadatra Passageiro Estudante.", "Você deve fornece um nome.");
		if(ra == null) return;
		
		((Estudante)passageiro).setRa(ra);
		
		if(onibus.adicionaPassageiro(passageiro))
			msgInfo("Passageiro cadastrado.","Cadatra Passageiro Estudante.");
		else
			msgErro("Onibus lotado.","Cadatra Passageiro Estudante.");
		
	}
	
	private static void cadastrarAposentado() {
		Passageiro passageiro = new Aposentado();
		if(!cadastrarPassageiro(passageiro)) return;
		String rg;
		rg = lerString("Forneça o RG do " + passageiro.getNome(), "Cadatra Passageiro Aposentado.", "Você deve fornece um nome.");
		if(rg == null) return;
		
		((Aposentado)passageiro).setRg(rg);
		
		if(onibus.adicionaPassageiro(passageiro))
			msgInfo("Passageiro cadastrado.","Cadatra Passageiro Aposentado.");
		else
			msgErro("Onibus lotado.","Cadatra Passageiro Aposentado.");
	}
	
	public static boolean cadastrarPassageiro(Passageiro passageiro) {
		String nome;
		nome = lerString("Forneça o do passageiro:", "Cadatra Passageiro.", "Você deve fornece um nome.");
		if(nome == null) return false;
		
		passageiro.setNome(nome);
		return true;
	}
	
	public static void totalArrecadado() {
		double valorTotal = onibus.calculaTotalArrecadado();
		showMessageDialog(null, String.format("Total arrecadado e de R$%1.2f", valorTotal), "Total Arrecadado", INFORMATION_MESSAGE);
	}
	
	public static void relatorio() {
		JTextArea areaTexto = new JTextArea(10, 25);
		String texto = "";
		
		texto += onibus.toString() + "\n";
		
		for(int indice = 0;indice < Onibus.getNumPassageiro();indice++)
			texto += onibus.obterPassageiro(indice).toString() + "\n";
		
		areaTexto.setText(texto);
		areaTexto.setEditable(false);
		
		showMessageDialog(null, new JScrollPane(areaTexto), "Relatorio", INFORMATION_MESSAGE);
	}
	
	public static void excluir() {
		String nome;
		nome = lerString("Forneça o nome do passageiro a ser consultado:", "Consultar", "Você deve fornecer um nome.");
		if(nome == null) return;
		
		int indice = onibus.pesquisaPassageiro(nome);
		if(indice == -1) return;
		String opcoes[] = {"Sim","Não"};
		int opcao = showOptionDialog(null, "Você deseja excluir o Passageiro:\n" + onibus.obterPassageiro(indice).toString(),
			"Excluir", DEFAULT_OPTION, QUESTION_MESSAGE, null, opcoes, opcoes[0]);
		if(opcao == 0){
			if(onibus.excluirPassageiro(indice))
				msgInfo("Passageiro Excluido com sucesso.", "Excluir");
			else
				msgErro("Erro ao excluir o Passageiro", "Excluir");
		}else
			msgInfo("Exclusão cancelada.", "Excluir");
	}
	
	public static void consultar() {
		String nome;
		nome = lerString("Forneça o nome do passageiro a ser consultado:", "Consultar", "Você deve fornecer um nome.");
		if(nome == null) return;
		
		int indice = onibus.pesquisaPassageiro(nome);
		Passageiro passageiro = onibus.obterPassageiro(indice);
		if(passageiro == null)return;
		
		showMessageDialog(null, "Passageiro Encontrado:\n\n" + passageiro.toString(), "Consultar", INFORMATION_MESSAGE);
	}
	
	public static String lerString(String msg,String titulo,String erro){
		String texto;
		do {
			texto = showInputDialog(null,msg, titulo,INFORMATION_MESSAGE);
			if(texto == null) return null;
			
			if(texto.equals(""))
				msgErro(erro, titulo);
		} while (texto.equals(""));
		return texto;
	}
	
	public static void msgInfo(String message, String title) {
		showMessageDialog(null, message, title, INFORMATION_MESSAGE);
	}
	
	public static void msgErro(String message, String title) {
		showMessageDialog(null, message, title, ERROR_MESSAGE);
	}

}
