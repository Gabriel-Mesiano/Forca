import java.util.Scanner;

public class Menu {
	private String op, op2;
	private PalavraSecreta palavramenu;
	private Scanner teclado = new Scanner(System.in);
	private Jogo jogomenu;
	
	public Menu(PalavraSecreta palavra, Jogo jogo) {
		this.palavramenu = palavra;
		this.jogomenu = jogo;
	}
	public void inicial(){
		do {
			System.out.println("--- Forca ---");
			System.out.println("1 - Começar");
			System.out.println("2 - Configuraçoes");
			System.out.println("3 - Sair");
			op = teclado.next();
			switch(op) {
				case "1":
					this.ClearConsole();
					this.menujogar();
					break;
				case "2":
					this.menuconfig();
					break;
				case "3":
					System.out.println("Obrigado por jogar!!");
					break;
				default:
					System.out.println("Selecione uma opção válida");
			
			
			}
		}while(!op.equals("3"));
	
	}
	public void menuconfig(){
		do {
			System.out.println("--- Configurações ---");
			System.out.println("1 - Tamanho máximo da palavra");
			System.out.println("2 - Número de vidas");
			System.out.println("3 - Voltar");
			op2 = teclado.next();
			switch(op2) {
				case "1":
					System.out.println("Digite o número máximo de letras de uma palavra");
					palavramenu.setNumLetras(teclado.nextInt());
					System.out.println("Número máximo de letras configurado para " + palavramenu.getNumLetras());
					break;
				case "2":
					System.out.println("Digite o número de vidas desejadas");
					jogomenu.setVidas(teclado.nextInt());
					System.out.println("Número de vidas configuradas para " + jogomenu.getVidas());
					break;
				case "3":
					break;
				default:
					System.out.println("Selecione uma opção válida");
			
			
			}
		}while(!op2.equals("3"));
	
	}
	public void menujogar(){
			System.out.println("--- Jogar ---");
			System.out.println("Escolha a Palavra Secreta: ");
			this.palavramenu.setPalavra();
			System.out.println("Diga em qual categoria essa palavra se encaixa");
			this.palavramenu.setDica(teclado.next());
			jogomenu.jogando(palavramenu);
	}
	public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO.start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO.start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
