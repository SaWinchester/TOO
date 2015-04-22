package tsi.too.app;

public class ExpressoesRegulares {

	public static void main(String[] args) {
		ExpressoesRegulares er = new ExpressoesRegulares();
		
		er.quebrarCadeiaDeCaracteres("Comando do Windows: dir windows /w", " ");
		er.quebrarCadeiaDeCaracteres("Segunda, Ter�a, Quarta, Quinta, Sexta, S�bado, Domingo", ",");
		er.quebrarCadeiaDeCaracteres("16/05/2014", "/");
		er.quebrarCadeiaDeCaracteres("13:41:20", ":");
		
		er.testarCadeiaDeCaracteres("123456789", "\\d");
		er.testarCadeiaDeCaracteres("123456789", "\\d+");
		er.testarCadeiaDeCaracteres("1", "\\d");
		er.testarCadeiaDeCaracteres("123456789", "\\d*");
		
		er.testarCadeiaDeCaracteres("", "\\d*");
		er.testarCadeiaDeCaracteres("", "\\d");
		er.testarCadeiaDeCaracteres("", "\\d+");
		er.testarCadeiaDeCaracteres("1", "\\d+");
		
		er.testarCadeiaDeCaracteres("E23", "\\d+");
		er.testarCadeiaDeCaracteres("1E23", "\\d+");
		er.testarCadeiaDeCaracteres("1E23", "\\w");
		er.testarCadeiaDeCaracteres("1E23", "\\w*");
		er.testarCadeiaDeCaracteres("_", "\\w+");
		
		er.testarCadeiaDeCaracteres("aaabbb", "\\a");
		er.testarCadeiaDeCaracteres("aaabbb", "\\a*");
		er.testarCadeiaDeCaracteres("aaabbb", "a*b*");
		er.testarCadeiaDeCaracteres("aaabbb", "a*b*c+");
		er.testarCadeiaDeCaracteres("aaabbbc", "a*b*c+");
		er.testarCadeiaDeCaracteres("aaabbbccc", "a*b*c*");
		er.testarCadeiaDeCaracteres("aaabbbccc", "a{3}b{3}c{3}");
		er.testarCadeiaDeCaracteres("aabbcc", "a{3}b{3}c{3}");
		
		// Testes de CEP que n�o funciona.
		er.testarCadeiaDeCaracteres("35-930-254", "\\d{2}\\.\\d{3}-\\d{3}");
		er.testarCadeiaDeCaracteres("35.930.254", "\\d{2}\\.\\d{3}-\\d{3}");
		er.testarCadeiaDeCaracteres("35.930*254", "\\d{2}\\.\\d{3}-\\d{3}");
		
		// Testes de CEP que funciona.
		er.testarCadeiaDeCaracteres("35.930-254", "\\d{2}\\.\\d{3}-\\d{3}");
		er.testarCadeiaDeCaracteres("35.930-254", "(\\d{2})(\\.)(\\d{3})-(\\d{3})");
		er.testarCadeiaDeCaracteres("35.930-254", "[0-9]{2}\\.[0-9]{3}-[0-9]{3}");
		
		er.testarCadeiaDeCaracteres("a", "[aeiou]");
		er.testarCadeiaDeCaracteres("i", "[aeiou]");
		er.testarCadeiaDeCaracteres("m", "[aeiou]");
		
		er.testarCadeiaDeCaracteres("amor", "[a-z]");
		er.testarCadeiaDeCaracteres("y", "[a-z]");
		er.testarCadeiaDeCaracteres("Y", "[a-z]");
		er.testarCadeiaDeCaracteres("Y", "[a-zA-Z]");
		er.testarCadeiaDeCaracteres("p", "[a-zA-Z]");
		
		// Testa o nome e sobrenome.
		er.testarCadeiaDeCaracteres("Ayrton Senna", "[a-zA-Z]+\\s[a-zA-Z]+");
		er.testarCadeiaDeCaracteres("Ayrton Senna da Silva", "[a-zA-Z]+(\\s[a-zA-Z]+)*");
		er.testarCadeiaDeCaracteres("Pele", "[a-zA-Z]+(\\s[a-zA-Z]+)+");
		
		// Testa o nome, ou seja, exige pelo menos o nome.
		er.testarCadeiaDeCaracteres("Ayrton", "[a-zA-Z]+");
		er.testarCadeiaDeCaracteres("Pele", "[a-zA-Z]+(\\s[a-zA-Z]+)*");
		er.testarCadeiaDeCaracteres("Edson Arantes do Nascimento", "[a-zA-Z]+(\\s[a-zA-Z]+)*");
		er.testarCadeiaDeCaracteres("", "[a-zA-Z]+(\\s[a-zA-Z]+)*");
		
		// Testar telefones.
		er.testarCadeiaDeCaracteres("(32)33693-8616", "\\([0-9]{2}\\)[0-9]{4,5}-[0-9]{4}");
		er.testarCadeiaDeCaracteres("(32)3693-8616", "\\([0-9]{2}\\)[0-9]{4,5}-[0-9]{4}");
		er.testarCadeiaDeCaracteres("(32)3693:8616", "\\([0-9]{2}\\)[0-9]{4,5}-[0-9]{4}");
		er.testarCadeiaDeCaracteres("(32)693-8616", "\\([0-9]{2}\\)[0-9]{4,5}-[0-9]{4}");
		er.testarCadeiaDeCaracteres("(32)693-616", "\\([0-9]{2}\\)[0-9]{4,5}-[0-9]{4}");
	} // main()
	
	public void quebrarCadeiaDeCaracteres(String string, String expressaoRegular) {
		// Obt�m as strings usando a express�o regular.
		String strings[] = string.split(expressaoRegular);
		
		for (String str : strings)
			System.out.println(str);
		
		System.out.println();
	} // quebrarCadeiaDeCaracteres()
	
	public void testarCadeiaDeCaracteres(String string, String expressaoRegular) {
		// Verifica se o valor do objeto string � igual ao padr�o definido pela express�o regular.
		if (string.matches(expressaoRegular))
			System.out.printf("\"%s\" >> CORRETO\n", string);
		else
			System.out.printf("\"%s\" >> ERRADO\n", string);
		
		System.out.println();
	} // testarCadeiaDeCaracteres
} // class ExpressoesRegulares
