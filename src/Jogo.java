import java.util.Scanner;
import java.util.Arrays;


public class Jogo {
	protected int vidas;
	
	public Jogo() {
		this.vidas = 5;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	public void jogando(PalavraSecreta palavraJogo) {
		int vida = this.vidas;
		int c = 0;
		char[] array = palavraJogo.palavra.toCharArray();
		char chute;
		char[] letraUsada = new char[26];
		char[] resposta = new char[array.length];
		char[] respostaAnt = new char[array.length];
		String respostaToString;
		String respostaAntToString;
		String respostaFinal = null;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Sua dica é: " + palavraJogo.dica + "\n");
		for(int i = 0; i < array.length; i++) {
			if(array[i] == ' ') {
				System.out.print(" ");
				resposta[i] = ' ';
				respostaAnt[i] = ' ';
			}
			else
				System.out.print("_ ");
				resposta[i] = '_';
				respostaAnt[i] = '_';
		}
		do {
			System.out.println("\nAdivinhe uma letra dessa palavra");
			chute = teclado.next().charAt(0);
			Arrays.sort(letraUsada);
			if(Arrays.binarySearch(letraUsada, chute) < 0) {
			System.out.println("");
			for(int i = 0; i < array.length; i++) {
				if(chute == array[i])
					resposta[i] = chute;
			}
			respostaToString = Character.toString(resposta[0]);
			respostaAntToString = Character.toString(respostaAnt[0]);
			respostaFinal = Character.toString(array[0]);
			for(int i = 0; i < resposta.length; i++) {
				System.out.print(resposta[i] + " " );
			}
			for(int i = 0; i < resposta.length - 1; i++) {
				respostaToString += Character.toString(resposta[i + 1]);
				respostaAntToString += Character.toString(respostaAnt[i + 1]);
				respostaFinal += Character.toString(array[i + 1]);
			}
			if(respostaToString.equals(respostaAntToString)) {
				vida--;
				letraUsada[c] = chute;
			}
			for(int i = 0; i < array.length; i++) {
				respostaAnt[i] = resposta[i];
			}
			System.out.println("Número de vidas: " + vida);
			if(respostaToString.equals(respostaFinal))
				vida = 100;
			c++;
			Arrays.sort(letraUsada);
			if (c >= 1) {
				System.out.print("\nLetras usadas: ");
				for(int i = 0; i < c; i++) {
					System.out.print(letraUsada[25 - i] + " ");
				}
			}
			}
			else {
				System.out.println("A letra ja foi usada");
				System.out.println("Sua dica é: " + palavraJogo.dica + "\n");
				for(int i = 0; i < array.length; i++) {
					if(array[i] == ' ') {
						System.out.print(" ");
						resposta[i] = ' ';
						respostaAnt[i] = ' ';
					}
					else
						System.out.print("_ ");
						resposta[i] = '_';
						respostaAnt[i] = '_';
				}
			}	
			
		}while(vida != 0 && vida != 100);
		if(vida == 0) {
			System.out.println("\nPerdeu!!");
			System.out.println("A palavra secreta era: " + respostaFinal);
		}
		else if(vida == 100)
			System.out.println("\nParabéns! Você acertou a palavra");
	}
}
