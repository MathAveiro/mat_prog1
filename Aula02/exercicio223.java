import java.util.*;

public class exercicio223 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza a idade: ");
		int idade = sc.nextInt();
		String bilhete = "";
		if (idade < 6) 	bilhete = "Isento de pagamento";
		else if (6 <= idade && idade <= 12) bilhete = "Bilhete de criança";
		else if (13 <= idade && idade <= 65) bilhete = "Bilhete normal";
		else bilhete = "Bilhete de 3ª idade";
		
		System.out.println(bilhete);
	}

}