import java.util.*;

public class exercicio338 {
	
		public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		int nota, total=0, count=0;
		double med;
		
		do{
			
			System.out.print("Insira as suas notas: ");
			nota = sc.nextInt();
			
			if (nota >= 0 && nota <= 20) {

				total += nota;
				
				count++;
				
			}
			
		}while(nota >= 0);

		if (count != 0){
			
			med = total / count;
			System.out.println("A soma é " + total);
			System.out.printf("A média é %.2f", med);
		
		}
		
	}

}