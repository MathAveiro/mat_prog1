import java.util.*;

public class exercicio3310 {
	
		public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		int valor, segundoV;
		
		System.out.print("Introduza um número: ");
		valor = sc.nextInt();
		
		double max=valor, min=valor;
		
		do{
			
			System.out.print("Insira outro número: ");
			segundoV = sc.nextInt();
			
			if(segundoV < min) min = segundoV;
			if(segundoV > max) max = segundoV;			
			
			if(segundoV == 2 * valor) break;
					
			valor = segundoV;
			
		}while(segundoV > 0);
	
		
		System.out.println("O maior número lido foi " + max + ", o menor foi " + min + ", os valores que deram forçaram a paragem foram " + valor + " e " + segundoV + ".");
	}

}