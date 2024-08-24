/**
 * 
 */
package fundamentos;

public class Fundamentos {


	public static void main(String[] args) {
		String nome = "Emille Feliciano";
		int idade = 22;
		char sexo = 'F';
		double altura = 1.63;
		System.out.println("Uso de variáveis na linguagem Java");
		System.out.println("");
		System.out.println("Exemplos: ");
		System.out.println("");
		System.out.println("Nome: " + nome);
		System.out.println("Idade: " + idade);
		System.out.println("Sexo: " + sexo);
		System.out.println("Altura: " + altura);
		System.out.println("_______________________________________________");
		System.out.println("");
		double i = 10;
		System.out.println("Operadores Aritméticos e Atribuições");
		System.out.println("");
		System.out.println("Exemplos: ");
		System.out.println("");
		System.out.println("i = " + i);
		System.out.println("i = " + i + " + 5 | i = " +  (i + 5));
		System.out.println("i = " + i + " - 5 | i = " +  (i - 5));
		System.out.println("i = " + i + " * 5 | i = " +  (i * 5));
		System.out.println("i = " + i + " / 5 | i = " +  (i / 5));
		System.out.println("i = " + i + " % 5 | i = " +  (i % 5));
		System.out.println("i += 5       | = " + (i += 5));
		System.out.println("i -= 5       | = " + (i -= 5));
		System.out.println("i *= 5       | = " + (i *= 5));
		System.out.println("i /= 5       | = " + (i /= 5));
		System.out.println("i %= 5       | = " + (i %= 5));
		i++;
		System.out.println("i++          | i = " + i);
		i--;
		System.out.println("i--          | i = " + i);
		
		System.out.println("_______________________________________________");
		System.out.println("");
		System.out.println("ESTRUTURAS DE CONTROLE");
		System.out.println("");
		System.out.println("Estruturas de controle condicional");
		System.out.println("");
		System.out.println("Exemplo 1 - Uso do 'if'");
		
		if (sexo == 'F') {
			System.out.println("Alistamento militar não obrigatório");
			
		}
		System.out.println("");
		System.out.println("Exemplo 2 - Uso do 'if - else'");
		
		if (idade < 18) {
			System.out.println("Menor de idade");
			
		}else {
			System.out.println("Maior de idade");
		}
		System.out.println("");
		System.out.println("Exemplo 3 - Uso do 'else - if'");
		
		if (idade < 16) {
			System.out.println("PROIBIDO VOTAR");
			
		}else if (idade >= 18 && idade <=70){
			System.out.println("VOTO OBRIGATÓRIO");
			
		}else if (idade == 16 || idade == 17 || idade > 70){
			System.out.println("VOTO FACULTATIVO");
		}
		System.out.println("");
		System.out.println("Exemplo 4 - Uso do 'Switch case'");
		
		System.out.println("1. Cadastro de clientes");
		System.out.println("2. Cadastro de usuários");
		System.out.println("3. Relatórios");
		int opcao = 1;
		switch (opcao) {
		
		case 1:
			System.out.println("CLIENTES");
			break;
		case 2:
			System.out.println("USUÁRIOS");
			break;
		case 3:
			System.out.println("RELATÓRIOS");
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
		System.out.println("");
		System.out.println("Estruturas de repetições");
		System.out.println("");
		System.out.println("Exemplo 5 - Uso do 'for'");
		
		for (int j = 5; j > 0; j--) {
			System.out.println("Seja forte e corajoso");
		}
		System.out.println("");
		for (int e = 10; e > 0; e--) {
			System.out.println(e);
		}
		
		System.out.println("");
		System.out.println("Exemplo  - Tabuada");
		
		for (int tabuada = 0; tabuada <= 10; tabuada++) {
			System.out.println("");
			for (int valor = 0; valor <= 10; valor++) {
				System.out.println(tabuada + "x" + valor + " = " + (tabuada * valor));

			}
		}
		
		System.out.println("");
		System.out.println("Exemplo 7  - Uso da estrutura 'while'");
		int contador = 1;
		while(contador <= 10) {
			System.out.println(contador);
			contador++;
		}
		System.out.println("");
		System.out.println("Exemplo 8  - Uso da estrutura 'do while'");
		char novoJogo;
		do {
			System.out.println("Deseja jogar novamente(s/n)?");
			novoJogo = 'n';
			
		}while (novoJogo == 's');
		System.out.println("GAME OVER");
	}

}
