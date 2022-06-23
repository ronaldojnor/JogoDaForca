import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogoDaForca {

	public static void main(String[] args) throws FileNotFoundException {
		
		//LER O ARQUIVO E GERAR A PALAVRA
		ArrayList<String> letras = new ArrayList<>();
		File arquivo = new File("/Users/Chavesb/Desktop/frutas.txt");
		Scanner palavra = new Scanner(arquivo);
		Scanner jogador = new Scanner(System.in);
		
		//SALVANDO AS PALAVRAS DO ARQUIVO EM UMA VARIAVEL
		while(palavra.hasNextLine()) {
			letras.add(palavra.nextLine());
		}
		
		//INICIO DO JOGO E GERANDO UMA PALAVRA ALEATORIA
		String palavraSecreta = letras.get((int) (Math.random()*letras.size()));
		System.out.println("Bem vindo ao jogo da Forca!");
		System.out.println("A palavra tem " + palavraSecreta.length() + " letras!");
		List<Character> chute = new ArrayList<>();
		
		//printLetras(palavraSecreta, chute);
		int chuteErrado = 0;
		while(true) {
			
			//IMPRIME A FORCA, CASO CHUTE SEJA ERRADO
			imprimeForca(chuteErrado);
			if (chuteErrado >= 7) {
				System.out.println("Voce perdeu!");
				System.out.println("A palavra é: " + palavraSecreta);
				break;
			}
			
			//VERIFICA AS VARIAVEIS, CASO ERRADO IMPRIME A FORCA
			if (!jogadorChute(jogador, chute, palavraSecreta)){
				chuteErrado++;
			}
			
			if (printLetras(palavraSecreta, chute)) {
				System.out.println("Voce ganhou!");
				break;
			}
		}
		
	}

	//METODO DE IMPRESSAO DA FORCA
	private static void imprimeForca(int chuteErrado) {
		System.out.println("  _______     ");
		System.out.println(" |/      |    ");
		if (chuteErrado == 1) {
			System.out.println(" |      (_)   ");
			System.out.println(" |            ");
			System.out.println(" |            ");
			System.out.println(" |            ");
			System.out.println(" |            ");
			System.out.println("_|___         ");
		}
		if (chuteErrado == 2) {
			System.out.println(" |      (_)   ");
			System.out.println(" |      \\     ");
			System.out.println(" |            ");
			System.out.println(" |            ");
			System.out.println(" |            ");
			System.out.println("_|___         ");
		}
		if (chuteErrado == 3) {
			System.out.println(" |      (_)   ");
			System.out.println(" |      \\|    ");
			System.out.println(" |            ");
			System.out.println(" |            ");
			System.out.println(" |            ");
			System.out.println("_|___         ");
		}
		if (chuteErrado == 4) {
			System.out.println(" |      (_)   ");
			System.out.println(" |      \\|/   ");
			System.out.println(" |            ");
			System.out.println(" |            ");
			System.out.println(" |            ");
			System.out.println("_|___         ");
		}	
		if (chuteErrado == 5) {
			System.out.println(" |      (_)   ");
			System.out.println(" |      \\|/   ");
			System.out.println(" |       |    ");
			System.out.println(" |            ");
			System.out.println(" |            ");
			System.out.println("_|___         ");
		}
		if (chuteErrado == 6) {
			System.out.println(" |      (_)   ");
			System.out.println(" |      \\|/   ");
			System.out.println(" |       |    ");
			System.out.println(" |      /     ");
			System.out.println(" |            ");
			System.out.println("_|___         ");
		}
		if (chuteErrado == 7) {
			System.out.println(" |      (_)   ");
			System.out.println(" |      \\|/   ");
			System.out.println(" |       |    ");
			System.out.println(" |      / \\   ");
			System.out.println(" |            ");
			System.out.println("_|___         ");			
		}
	}

	//ESCOLHA DO JOGADOR
	private static boolean jogadorChute(Scanner jogador, List<Character> chute, String palavraSecreta) {
		System.out.println("Escolha uma letra: ");	
		String letraChute = jogador.nextLine().toLowerCase();
		chute.add(letraChute.charAt(0));
		
	return palavraSecreta.contains(letraChute);
	}

	//VERIFICA SE SE A LETRA ESCOLHIDA ESTA NA PALAVRA GERADA
	private static boolean printLetras(String palavraSecreta, List<Character> chute) {
		int letraCerta = 0;
		for (int i = 0; i < palavraSecreta.length(); i++) {
			if (chute.contains(palavraSecreta.charAt(i))) {
				System.out.print(palavraSecreta.charAt(i));
				letraCerta++;
			} 
			else {
				System.out.print("-");
			}
							
		}
		System.out.println();
		return (palavraSecreta.length() == letraCerta);
	}

}
