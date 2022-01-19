import java.util.Scanner;

public class PalavraSecreta {
	protected String palavra;
	protected int numLetras;
	protected String dica;
	Scanner teclado = new Scanner(System.in);
	
	
	public PalavraSecreta() {
		this.palavra = null;
		this.numLetras = 30;
		this.dica = null;
	}
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra() {
		String palavra;
		do {
			palavra = teclado.next();
			if(palavra.length() <= this.numLetras)
			this.palavra = palavra;
		else 
			System.out.println("Palavra inválida");
		}while(this.palavra != palavra);
	}
	public int getNumLetras() {
		return numLetras;
	}
	public void setNumLetras(int numLetras) {
		this.numLetras = numLetras;
	}
	public String getDica() {
		return dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	
	
}
