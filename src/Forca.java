
public class Forca {

	public static void main(String[] args) {
		PalavraSecreta palavra = new PalavraSecreta();
		Jogo jogo = new Jogo();
		Menu menu = new Menu(palavra, jogo);
		menu.inicial();
		System.out.println("Fim do programa!");
	}

}
