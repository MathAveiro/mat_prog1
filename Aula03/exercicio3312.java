import java.util.*;

public class exercicio3312 {
	
		public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		String resp = "";
		boolean terminar = false;
		int secret;
		int valor, qnt=1;
		do {
			qnt = 1;
			secret = (int)(100.0*Math.random()) + 1;
			System.out.print("Introduza um valor: ");
			valor = sc.nextInt();
			do {

				if(valor < secret) System.out.print("O número a adivinhar é mais alto. Introuza novamente um valor: ");
				else if (valor > secret) System.out.print("O número a adivinhar é mais baixo. Introuza novamente um valor: ");
				valor = sc.nextInt();

				qnt += 1;
			} while (valor != secret);
			
			System.out.println("O valor secreto é: "+secret+" e foram feitas "+qnt+" tentativas.");
			System.out.print("Deseja terminar o jogo? (s/n): ");
			resp = sc.next();
		} while (resp.equals("n"));


		
	}

}